package com.sniper.findme.security.configuration;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

// TODO: Auto-generated Javadoc
/**
 * The Class JwtTokenUtil.
 */
@Component
public class JwtTokenUtil implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -2550185165626007488L;

	/** The Constant JWT_TOKEN_VALIDITY. */
	public static final long JWT_TOKEN_VALIDITY = 5 * 60 * 60;

	/** The secret. */
	@Value("${jwt.secret}")
	private String secret;

	/**
	 * Gets the username from token.
	 *
	 * @param token the token
	 * @return the username from token
	 */
	public String getUsernameFromToken(String token) {
		return getClaimFromToken(token, Claims::getSubject);
	}

	/**
	 * Gets the expiration date from token.
	 *
	 * @param token the token
	 * @return the expiration date from token
	 */
	public Date getExpirationDateFromToken(String token) {
		return getClaimFromToken(token, Claims::getExpiration);
	}

	/**
	 * Gets the claim from token.
	 *
	 * @param                <T> the generic type
	 * @param token          the token
	 * @param claimsResolver the claims resolver
	 * @return the claim from token
	 */
	public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
		final Claims claims = getAllClaimsFromToken(token);
		return claimsResolver.apply(claims);
	}

	/**
	 * Gets the all claims from token.
	 *
	 * @param token the token
	 * @return the all claims from token
	 */
	private Claims getAllClaimsFromToken(String token) {
		return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
	}

	/**
	 * Checks if is token expired.
	 *
	 * @param token the token
	 * @return the boolean
	 */
	private Boolean isTokenExpired(String token) {
		final Date expiration = getExpirationDateFromToken(token);
		return expiration.before(new Date());
	}

	/**
	 * Generate token.
	 *
	 * @param userDetails the user details
	 * @return the string
	 */
	public String generateToken(UserDetails userDetails) {
		Map<String, Object> claims = new HashMap<>();
		return doGenerateToken(claims, userDetails.getUsername());
	}

	/**
	 * Do generate token.
	 *
	 * @param claims  the claims
	 * @param subject the subject
	 * @return the string
	 */
	private String doGenerateToken(Map<String, Object> claims, String subject) {
		return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY * 1000))
				.signWith(SignatureAlgorithm.HS512, secret).compact();
	}

	/**
	 * Validate token.
	 *
	 * @param token       the token
	 * @param userDetails the user details
	 * @return the boolean
	 */
	public Boolean validateToken(String token, UserDetails userDetails) {
		final String username = getUsernameFromToken(token);
		return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
	}
}
