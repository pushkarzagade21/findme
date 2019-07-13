package com.sniper.findme.profile.service;

import com.sniper.findme.common.model.ResultObject;
import com.sniper.findme.user.model.User;

// TODO: Auto-generated Javadoc
/**
 * The Interface ProfileService.
 */
public interface ProfileService {
	
	/**
	 * Update user profile.
	 *
	 * @param user the user
	 * @return the result object
	 */
	public ResultObject updateUserProfile(User user);
}
