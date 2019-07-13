package com.sniper.findme.user.service;

import com.sniper.findme.user.model.User;

// TODO: Auto-generated Javadoc
/**
 * The Interface UserService.
 */
public interface UserService {

	/**
	 * Gets the user by id.
	 *
	 * @param user the user
	 * @return the user by id
	 */
	public User getUserById(User user);

	/**
	 * Update user object.
	 *
	 * @param user the user
	 * @param userToUpdate the user to update
	 * @return the user
	 */
	public User updateUserObject(User user, User userToUpdate);

}
