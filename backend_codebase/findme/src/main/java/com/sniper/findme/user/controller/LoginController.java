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
import com.sniper.findme.user.service.LoginService;

// TODO: Auto-generated Javadoc
/**
 * The Class LoginController.
 */
@RestController
@RequestMapping("/user-login")
public class LoginController {

	/** The login service. */
	@Autowired
	private LoginService loginService;

	/**
	 * Login user.
	 *
	 * @param user the user
	 * @return the result object
	 */
	@CrossOrigin
	@PostMapping(path = "/login", produces = "application/json")
	public ResultObject loginUser(@RequestBody User user) {
		ResultObject resultObject = new ResultObject();
		if (!CommonUtils.isEmptyOrNull(user)) {
			resultObject = loginService.loginUserService(user);
		} else {
			List<ErrorDetails> errorDetailsList = new ArrayList<>();
			errorDetailsList.add(new ErrorDetails("FIND_ME_ERROR_CODE_001", ErrorConstant.FIND_ME_ERROR_CODE_001));
			resultObject.setErrorList(errorDetailsList);
		}
		return resultObject;
	}

	/**
	 * Login user with facebook.
	 *
	 * @param user the user
	 * @return the result object
	 */
	@CrossOrigin
	@PostMapping(path = "/login-with-facebook", produces = "application/json")
	public ResultObject loginUserWithFacebook(@RequestBody User user) {
		ResultObject resultObject = new ResultObject();
		if (!CommonUtils.isEmptyOrNull(user)) {
			resultObject = loginService.loginUserWithFacebookService(user);
		} else {
			List<ErrorDetails> errorDetailsList = new ArrayList<>();
			errorDetailsList.add(new ErrorDetails("FIND_ME_ERROR_CODE_001", ErrorConstant.FIND_ME_ERROR_CODE_001));
			resultObject.setErrorList(errorDetailsList);
		}
		return resultObject;
	}

	/**
	 * Login user with google.
	 *
	 * @param user the user
	 * @return the result object
	 */
	@CrossOrigin
	@PostMapping(path = "/login-with-google", produces = "application/json")
	public ResultObject loginUserWithGoogle(@RequestBody User user) {
		ResultObject resultObject = new ResultObject();
		if (!CommonUtils.isEmptyOrNull(user)) {
			resultObject = loginService.loginUserWithGoogleService(user);
		} else {
			List<ErrorDetails> errorDetailsList = new ArrayList<>();
			errorDetailsList.add(new ErrorDetails("FIND_ME_ERROR_CODE_001", ErrorConstant.FIND_ME_ERROR_CODE_001));
			resultObject.setErrorList(errorDetailsList);
		}
		return resultObject;
	}
}
