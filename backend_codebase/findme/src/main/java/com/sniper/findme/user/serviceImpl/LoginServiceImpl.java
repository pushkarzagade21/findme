package com.sniper.findme.user.serviceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sniper.findme.common.constant.ErrorConstant;
import com.sniper.findme.common.constant.FindMeConstant;
import com.sniper.findme.common.model.ErrorDetails;
import com.sniper.findme.common.model.ResultObject;
import com.sniper.findme.common.utility.CommonUtils;
import com.sniper.findme.security.configuration.JwtTokenUtil;
import com.sniper.findme.security.service.JwtUserDetailsService;
import com.sniper.findme.user.model.User;
import com.sniper.findme.user.repository.UserRepository;
import com.sniper.findme.user.service.LoginService;

// TODO: Auto-generated Javadoc
/**
 * The Class LoginServiceImpl.
 */
@Service
@Transactional
public class LoginServiceImpl implements LoginService {

	/** The user repository. */
	@Autowired
	private UserRepository userRepository;

	/** The authentication manager. */
	@Autowired
	private AuthenticationManager authenticationManager;

	/** The jwt token util. */
	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	/** The user details service. */
	@Autowired
	private JwtUserDetailsService userDetailsService;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sniper.findme.user.service.LoginService#loginUserService(com.sniper.
	 * findme.user.model.User)
	 */
	@Override
	public ResultObject loginUserService(User user) {
		// TODO Auto-generated method stub
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		ResultObject resultObject = new ResultObject();
		try {
			authenticate(user.getUserName(), user.getPassword());
			final UserDetails userDetails = userDetailsService.loadUserByUsername(user.getUserName());
			final String jwtToken = jwtTokenUtil.generateToken(userDetails);

			User loggedInUser = userRepository.findUserByUserName(user.getUserName());
			if (!CommonUtils.isEmptyOrNull(loggedInUser) && !CommonUtils.isEmptyOrNull(userDetails)) {
				if (bCryptPasswordEncoder.matches(user.getPassword(), loggedInUser.getPassword())) {
					loggedInUser.setJwtToken(jwtToken);
					resultObject.setResult(loggedInUser);
				} else {
					List<ErrorDetails> errorDetailsList = new ArrayList<>();
					errorDetailsList
							.add(new ErrorDetails("FIND_ME_ERROR_CODE_004", ErrorConstant.FIND_ME_ERROR_CODE_004));
					resultObject.setErrorList(errorDetailsList);
				}
			} else {
				List<ErrorDetails> errorDetailsList = new ArrayList<>();
				errorDetailsList.add(new ErrorDetails("FIND_ME_ERROR_CODE_004", ErrorConstant.FIND_ME_ERROR_CODE_004));
				resultObject.setErrorList(errorDetailsList);
			}
		} catch (Exception e) {
			List<ErrorDetails> errorDetailsList = new ArrayList<>();
			errorDetailsList.add(new ErrorDetails("FIND_ME_ERROR_CODE_004", ErrorConstant.FIND_ME_ERROR_CODE_004));
			resultObject.setErrorList(errorDetailsList);
		}
		return resultObject;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.sniper.findme.user.service.LoginService#loginUserWithFacebookService(com.
	 * sniper.findme.user.model.User)
	 */
	@Override
	public ResultObject loginUserWithFacebookService(User user) {
		// TODO Auto-generated method stub
		ResultObject resultObject = new ResultObject();

		User loggedInUser = userRepository.findUserByUserName(user.getUserName());
		if (!CommonUtils.isEmptyOrNull(loggedInUser)
				&& loggedInUser.getIsFacebookLogin().equalsIgnoreCase(FindMeConstant.YES)) {
			try {
				authenticate(user.getUserName(), user.getPassword());
				final UserDetails userDetails = userDetailsService.loadUserByUsername(user.getUserName());
				final String jwtToken = jwtTokenUtil.generateToken(userDetails);
				loggedInUser.setJwtToken(jwtToken);
				resultObject.setResult(loggedInUser);
			} catch (Exception e) {
				List<ErrorDetails> errorDetailsList = new ArrayList<>();
				errorDetailsList.add(new ErrorDetails("FIND_ME_ERROR_CODE_005", ErrorConstant.FIND_ME_ERROR_CODE_005));
				resultObject.setErrorList(errorDetailsList);
			}
		} else if (!CommonUtils.isEmptyOrNull(loggedInUser)
				&& loggedInUser.getIsFacebookLogin().equalsIgnoreCase(FindMeConstant.NO)) {
			List<ErrorDetails> errorDetailsList = new ArrayList<>();
			errorDetailsList.add(new ErrorDetails("FIND_ME_ERROR_CODE_002", ErrorConstant.FIND_ME_ERROR_CODE_002));
			resultObject.setErrorList(errorDetailsList);
		} else {
			user.setCreationDate(new Date());
			user.setModificationDate(new Date());
			user.setPassword(CommonUtils.encryptData(user.getPassword()));
			User savedUser = userRepository.save(user);
			try {
				authenticate(savedUser.getUserName(), savedUser.getPassword());
				final UserDetails userDetails = userDetailsService.loadUserByUsername(savedUser.getUserName());
				final String jwtToken = jwtTokenUtil.generateToken(userDetails);
				loggedInUser.setJwtToken(jwtToken);
				resultObject.setResult(savedUser);
			} catch (Exception e) {
				List<ErrorDetails> errorDetailsList = new ArrayList<>();
				errorDetailsList.add(new ErrorDetails("FIND_ME_ERROR_CODE_002", ErrorConstant.FIND_ME_ERROR_CODE_002));
				resultObject.setErrorList(errorDetailsList);
			}
		}
		return resultObject;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.sniper.findme.user.service.LoginService#loginUserWithGoogleService(com.
	 * sniper.findme.user.model.User)
	 */
	@Override
	public ResultObject loginUserWithGoogleService(User user) {
		// TODO Auto-generated method stub
		ResultObject resultObject = new ResultObject();

		User loggedInUser = userRepository.findUserByUserName(user.getUserName());
		if (!CommonUtils.isEmptyOrNull(loggedInUser)
				&& loggedInUser.getIsGoogleLogin().equalsIgnoreCase(FindMeConstant.YES)) {
			try {
				authenticate(user.getUserName(), user.getPassword());
				final UserDetails userDetails = userDetailsService.loadUserByUsername(user.getUserName());
				final String jwtToken = jwtTokenUtil.generateToken(userDetails);
				loggedInUser.setJwtToken(jwtToken);
				resultObject.setResult(loggedInUser);
			} catch (Exception e) {
				List<ErrorDetails> errorDetailsList = new ArrayList<>();
				errorDetailsList.add(new ErrorDetails("FIND_ME_ERROR_CODE_005", ErrorConstant.FIND_ME_ERROR_CODE_005));
				resultObject.setErrorList(errorDetailsList);
			}
		} else if (!CommonUtils.isEmptyOrNull(loggedInUser)
				&& loggedInUser.getIsGoogleLogin().equalsIgnoreCase(FindMeConstant.NO)) {
			List<ErrorDetails> errorDetailsList = new ArrayList<>();
			errorDetailsList.add(new ErrorDetails("FIND_ME_ERROR_CODE_002", ErrorConstant.FIND_ME_ERROR_CODE_002));
			resultObject.setErrorList(errorDetailsList);
		} else {
			user.setCreationDate(new Date());
			user.setModificationDate(new Date());
			user.setPassword(CommonUtils.encryptData(user.getPassword()));
			User savedUser = userRepository.save(user);
			try {
				authenticate(savedUser.getUserName(), savedUser.getPassword());
				final UserDetails userDetails = userDetailsService.loadUserByUsername(savedUser.getUserName());
				final String jwtToken = jwtTokenUtil.generateToken(userDetails);
				loggedInUser.setJwtToken(jwtToken);
				resultObject.setResult(savedUser);
			} catch (Exception e) {
				List<ErrorDetails> errorDetailsList = new ArrayList<>();
				errorDetailsList.add(new ErrorDetails("FIND_ME_ERROR_CODE_002", ErrorConstant.FIND_ME_ERROR_CODE_002));
				resultObject.setErrorList(errorDetailsList);
			}
		}
		return resultObject;
	}

	/**
	 * Authenticate.
	 *
	 * @param username the username
	 * @param password the password
	 * @throws Exception the exception
	 */
	private void authenticate(String username, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}

}
