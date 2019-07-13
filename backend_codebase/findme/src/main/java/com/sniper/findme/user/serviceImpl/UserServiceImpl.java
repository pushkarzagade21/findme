package com.sniper.findme.user.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sniper.findme.user.model.User;
import com.sniper.findme.user.repository.UserRepository;
import com.sniper.findme.user.service.UserService;

// TODO: Auto-generated Javadoc
/**
 * The Class UserServiceImpl.
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

	/** The user repository. */
	@Autowired
	private UserRepository userRepository;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.sniper.findme.user.service.UserService#getUserById(com.sniper.findme.user
	 * .model.User)
	 */
	@Override
	public User getUserById(User user) {
		// TODO Auto-generated method stub
		Optional<User> userToFetch = userRepository.findById(user.getId());
		if (userToFetch.isPresent()) {
			return userToFetch.get();
		}
		return null;
	}

	@Override
	public User updateUserObject(User user, User userToUpdate) {
		// TODO Auto-generated method stub
		return null;
	}

}
