package com.sniper.findme.user.service;

import com.sniper.findme.common.model.ResultObject;
import com.sniper.findme.user.model.User;

// TODO: Auto-generated Javadoc
/**
 * The Interface LoginService.
 */
public interface LoginService {

	/**
	 * Login user service.
	 *
	 * @param user the user
	 * @return the result object
	 */
	public ResultObject loginUserService(User user);

	/**
	 * Login user with facebook service.
	 *
	 * @param user the user
	 * @return the result object
	 */
	public ResultObject loginUserWithFacebookService(User user);

	/**
	 * Login user with google service.
	 *
	 * @param user the user
	 * @return the result object
	 */
	public ResultObject loginUserWithGoogleService(User user);

}
