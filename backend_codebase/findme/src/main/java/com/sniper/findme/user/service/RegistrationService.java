package com.sniper.findme.user.service;

import com.sniper.findme.common.model.ResultObject;
import com.sniper.findme.user.model.User;

// TODO: Auto-generated Javadoc
/**
 * The Interface RegistrationService.
 */
public interface RegistrationService {

	/**
	 * Register user service.
	 *
	 * @param user the user
	 * @return the result object
	 */
	public ResultObject registerUserService(User user);

	/**
	 * Check email exist service.
	 *
	 * @param email the email
	 * @return the result object
	 */
	public ResultObject checkEmailExistService(String email);

	/**
	 * Check username exist service.
	 *
	 * @param username the username
	 * @return the result object
	 */
	public ResultObject checkUsernameExistService(String username);
}
