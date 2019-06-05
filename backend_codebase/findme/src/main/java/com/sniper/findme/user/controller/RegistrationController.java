package com.sniper.findme.user.controller;

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
import com.sniper.findme.user.model.User;
import com.sniper.findme.user.service.RegistrationService;

@RestController
@RequestMapping("/user-registration")
public class RegistrationController {

	@Autowired
	private RegistrationService registrationService;

	@CrossOrigin
	@PostMapping(path = "/save-user", produces = "application/json")
	public ResultObject saveUser(@RequestBody User user) {
		ResultObject resultObject = new ResultObject();
		if (!CommonUtils.isEmptyOrNull(user)) {
			User savedUser = registrationService.registerUserService(user);
			resultObject.setResult(savedUser);
		} else {
			List<ErrorDetails> errorDetailsList = new ArrayList<>();
			errorDetailsList.add(new ErrorDetails("FIND_ME_ERROR_CODE_001", ErrorConstant.FIND_ME_ERROR_CODE_001));
			resultObject.setErrorList(errorDetailsList);
		}
		return resultObject;
	}

}
