package com.sniper.findme.user.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sniper.findme.common.utility.CommonUtils;
import com.sniper.findme.user.model.User;
import com.sniper.findme.user.repository.UserRepository;
import com.sniper.findme.user.service.RegistrationService;

@Service
@Transactional
public class RegistrationServiceImpl implements RegistrationService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public User registerUserService(User user) {
		// TODO Auto-generated method stub
		user.setPassword(CommonUtils.encryptData(user.getPassword()));
		User savedUser = userRepository.save(user);
		return savedUser;
	}

}
