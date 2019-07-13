package com.sniper.findme.friends.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sniper.findme.common.model.ResultObject;
import com.sniper.findme.friends.repository.FriendRepository;
import com.sniper.findme.friends.service.FriendService;
import com.sniper.findme.user.repository.UserRepository;

// TODO: Auto-generated Javadoc
/**
 * The Class FriendServiceImpl.
 */
@Service
@Transactional
public class FriendServiceImpl implements FriendService {

	/** The friend repository. */
	@Autowired
	private FriendRepository friendRepository;

	/** The user repository. */
	@Autowired
	private UserRepository userRepository;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.sniper.findme.friends.service.FriendService#getAllFriends(java.lang.Long)
	 */
	@Override
	public ResultObject getAllFriends(Long userId) {
		// TODO Auto-generated method stub
		ResultObject resultObject = new ResultObject();
		return resultObject;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.sniper.findme.friends.service.FriendService#sendFriendRequest(java.lang.
	 * Long, java.lang.Long)
	 */
	@Override
	public ResultObject sendFriendRequest(Long userId, Long friendId) {
		// TODO Auto-generated method stub
		ResultObject resultObject = new ResultObject();
		return resultObject;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.sniper.findme.friends.service.FriendService#getFriendRequest(java.lang.
	 * Long)
	 */
	@Override
	public ResultObject getFriendRequest(Long userId) {
		// TODO Auto-generated method stub
		ResultObject resultObject = new ResultObject();
		return resultObject;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.sniper.findme.friends.service.FriendService#acceptFriendRequest(java.lang
	 * .Long, java.lang.Long)
	 */
	@Override
	public ResultObject acceptFriendRequest(Long userId, Long friendId) {
		// TODO Auto-generated method stub
		ResultObject resultObject = new ResultObject();
		return resultObject;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.sniper.findme.friends.service.FriendService#removeFriend(java.lang.Long,
	 * java.lang.Long)
	 */
	@Override
	public ResultObject removeFriend(Long userId, Long friendId) {
		// TODO Auto-generated method stub
		ResultObject resultObject = new ResultObject();
		return resultObject;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.sniper.findme.friends.service.FriendService#blockFriend(java.lang.Long,
	 * java.lang.Long)
	 */
	@Override
	public ResultObject blockFriend(Long userId, Long friendId) {
		// TODO Auto-generated method stub
		ResultObject resultObject = new ResultObject();
		return resultObject;
	}
}
