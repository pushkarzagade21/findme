package com.sniper.findme.friends.service;

import com.sniper.findme.common.model.ResultObject;

// TODO: Auto-generated Javadoc
/**
 * The Interface FriendService.
 */
public interface FriendService {

	/**
	 * Gets the all friends.
	 *
	 * @param userId the user id
	 * @return the all friends
	 */
	public ResultObject getAllFriends(Long userId);

	/**
	 * Send friend request.
	 *
	 * @param userId   the user id
	 * @param friendId the friend id
	 * @return the result object
	 */
	public ResultObject sendFriendRequest(Long userId, Long friendId);

	/**
	 * Gets the friend request.
	 *
	 * @param userId the user id
	 * @return the friend request
	 */
	public ResultObject getFriendRequest(Long userId);

	/**
	 * Accept friend request.
	 *
	 * @param userId   the user id
	 * @param friendId the friend id
	 * @return the result object
	 */
	public ResultObject acceptFriendRequest(Long userId, Long friendId);

	/**
	 * Removes the friend.
	 *
	 * @param userId   the user id
	 * @param friendId the friend id
	 * @return the result object
	 */
	public ResultObject removeFriend(Long userId, Long friendId);

	/**
	 * Block friend.
	 *
	 * @param userId   the user id
	 * @param friendId the friend id
	 * @return the result object
	 */
	public ResultObject blockFriend(Long userId, Long friendId);
}
