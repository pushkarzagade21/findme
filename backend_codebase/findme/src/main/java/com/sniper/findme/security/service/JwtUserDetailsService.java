package com.sniper.findme.security.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sniper.findme.common.utility.CommonUtils;
import com.sniper.findme.user.repository.UserRepository;

// TODO: Auto-generated Javadoc
/**
 * The Class JwtUserDetailsService.
 */
@Service
public class JwtUserDetailsService implements UserDetailsService {

	/** The user repository. */
	@Autowired
	private UserRepository userRepository;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.security.core.userdetails.UserDetailsService#
	 * loadUserByUsername(java.lang.String)
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		com.sniper.findme.user.model.User user = userRepository.findUserByUserName(username);
		if (!CommonUtils.isEmptyOrNull(user)) {
			return new User(user.getUserName(), user.getPassword(), new ArrayList<>());
		} else {
			return null;
		}
	}
}