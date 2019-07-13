package com.sniper.findme.friends.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sniper.findme.common.model.ResultObject;
import com.sniper.findme.friends.service.FriendService;
import com.sniper.findme.user.service.UserService;

// TODO: Auto-generated Javadoc
/**
 * The Class FriendsController.
 */
@RestController
@RequestMapping("/friends")
public class FriendsController {

	/** The friend service. */
	@Autowired
	private FriendService friendService;

	/** The user service. */
	@Autowired
	private UserService userService;

	/**
	 * Gets the all friends.
	 *
	 * @param userId the user id
	 * @return the all friends
	 */
	@CrossOrigin
	@GetMapping(path = "/getAllFriends")
	public ResultObject getAllFriends(@RequestParam("userId") Long userId) {
		ResultObject resultObject = new ResultObject();
		return resultObject;
	}

	/**
	 * Gets the all friends.
	 *
	 * @param userId   the user id
	 * @param friendId the friend id
	 * @return the all friends
	 */
	@CrossOrigin
	@GetMapping(path = "/sendFriendRequest")
	public ResultObject sendFriendRequest(@RequestParam("userId") Long userId,
			@RequestParam("friendId") Long friendId) {
		ResultObject resultObject = new ResultObject();
		return resultObject;
	}

	/**
	 * Gets the friend request.
	 *
	 * @param userId the user id
	 * @return the friend request
	 */
	@CrossOrigin
	@GetMapping(path = "/getFriendRequest")
	public ResultObject getFriendRequest(@RequestParam("userId") Long userId) {
		ResultObject resultObject = new ResultObject();
		return resultObject;
	}

	/**
	 * Accept friend request.
	 *
	 * @param userId   the user id
	 * @param friendId the friend id
	 * @return the result object
	 */
	@CrossOrigin
	@GetMapping(path = "/acceptFriendRequest")
	public ResultObject acceptFriendRequest(@RequestParam("userId") Long userId,
			@RequestParam("friendId") Long friendId) {
		ResultObject resultObject = new ResultObject();
		return resultObject;
	}

	/**
	 * Removes the friend.
	 *
	 * @param userId   the user id
	 * @param friendId the friend id
	 * @return the result object
	 */
	@CrossOrigin
	@GetMapping(path = "/removeFriend")
	public ResultObject removeFriend(@RequestParam("userId") Long userId, @RequestParam("friendId") Long friendId) {
		ResultObject resultObject = new ResultObject();
		return resultObject;
	}

	/**
	 * Block friend.
	 *
	 * @param userId   the user id
	 * @param friendId the friend id
	 * @return the result object
	 */
	@CrossOrigin
	@GetMapping(path = "/blockFriend")
	public ResultObject blockFriend(@RequestParam("userId") Long userId, @RequestParam("friendId") Long friendId) {
		ResultObject resultObject = new ResultObject();
		return resultObject;
	}
}
