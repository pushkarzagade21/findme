package com.sniper.findme.profile.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sniper.findme.common.constant.ErrorConstant;
import com.sniper.findme.common.model.ErrorDetails;
import com.sniper.findme.common.model.ResultObject;
import com.sniper.findme.common.utility.CommonUtils;
import com.sniper.findme.profile.repository.ProfileRepository;
import com.sniper.findme.profile.service.ProfileService;
import com.sniper.findme.user.model.User;
import com.sniper.findme.user.service.UserService;

// TODO: Auto-generated Javadoc
/**
 * The Class ProfileServiceImpl.
 */
@Service
@Transactional
public class ProfileServiceImpl implements ProfileService {

	@Autowired
	private UserService userService;

	@Autowired
	private ProfileRepository profileRepository;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.sniper.findme.profile.service.ProfileService#updateUserProfile(com.sniper
	 * .findme.user.model.User)
	 */
	@Override
	public ResultObject updateUserProfile(User user) {
		// TODO Auto-generated method stub
		ResultObject resultObject = new ResultObject();
		User profileToUpdate = userService.getUserById(user);
		if (!CommonUtils.isEmptyOrNull(profileToUpdate)) {
			User updatedUser = userService.updateUserObject(user, profileToUpdate);
			resultObject.setResult(profileRepository.save(updatedUser));
		} else {
			List<ErrorDetails> errorDetailsList = new ArrayList<>();
			errorDetailsList.add(new ErrorDetails("FIND_ME_ERROR_CODE_001", ErrorConstant.FIND_ME_ERROR_CODE_001));
			resultObject.setErrorList(errorDetailsList);
		}
		return resultObject;
	}

}
