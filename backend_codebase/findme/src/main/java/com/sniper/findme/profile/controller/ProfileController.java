package com.sniper.findme.profile.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sniper.findme.common.constant.ErrorConstant;
import com.sniper.findme.common.model.ErrorDetails;
import com.sniper.findme.common.model.ResultObject;
import com.sniper.findme.common.utility.CommonUtils;
import com.sniper.findme.profile.service.ProfileService;
import com.sniper.findme.user.model.User;

@RestController
@RequestMapping("/profile")
public class ProfileController {

	@Autowired
	private ProfileService profileService;

	/**
	 * Update profile.
	 *
	 * @param user the user
	 * @return the result object
	 */
	@CrossOrigin
	@PostMapping(path = "/update-profile", produces = "application/json")
	public ResultObject updateProfile(@RequestBody User user) {
		ResultObject resultObject = new ResultObject();
		if (!CommonUtils.isEmptyOrNull(user)) {
			resultObject = profileService.updateUserProfile(user);
		} else {
			List<ErrorDetails> errorDetailsList = new ArrayList<>();
			errorDetailsList.add(new ErrorDetails("FIND_ME_ERROR_CODE_001", ErrorConstant.FIND_ME_ERROR_CODE_001));
			resultObject.setErrorList(errorDetailsList);
		}
		return resultObject;
	}
}
