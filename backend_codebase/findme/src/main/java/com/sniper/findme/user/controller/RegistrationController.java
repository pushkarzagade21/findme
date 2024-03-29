package com.sniper.findme.user.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sniper.findme.common.constant.ErrorConstant;
import com.sniper.findme.common.model.ErrorDetails;
import com.sniper.findme.common.model.ResultObject;
import com.sniper.findme.common.utility.CommonUtils;
import com.sniper.findme.user.model.User;
import com.sniper.findme.user.service.RegistrationService;

// TODO: Auto-generated Javadoc
/**
 * The Class RegistrationController.
 */
@RestController
@RequestMapping("/user-registration")
public class RegistrationController {

	/** The registration service. */
	@Autowired
	private RegistrationService registrationService;

	/**
	 * Save user.
	 *
	 * @param user the user
	 * @return the result object
	 */
	@CrossOrigin
	@PostMapping(path = "/save-user", produces = "application/json")
	public ResultObject saveUser(@RequestBody User user) {
		ResultObject resultObject = new ResultObject();
		if (!CommonUtils.isEmptyOrNull(user)) {
			user.setCreationDate(new Date());
			user.setModificationDate(new Date());
			resultObject = registrationService.registerUserService(user);
		} else {
			List<ErrorDetails> errorDetailsList = new ArrayList<>();
			errorDetailsList.add(new ErrorDetails("FIND_ME_ERROR_CODE_001", ErrorConstant.FIND_ME_ERROR_CODE_001));
			resultObject.setErrorList(errorDetailsList);
		}
		return resultObject;
	}

	/**
	 * Check email exist.
	 *
	 * @param email the email
	 * @return the result object
	 */
	@CrossOrigin
	@GetMapping(path = "/check-email-exists", produces = "application/json")
	public ResultObject checkEmailExist(@RequestParam("email") String email) {
		ResultObject resultObject = new ResultObject();
		if (!CommonUtils.isEmptyOrNull(email)) {
			resultObject = registrationService.checkEmailExistService(email);
		}
		return resultObject;
	}

	/**
	 * Check username exist.
	 *
	 * @param username the username
	 * @return the result object
	 */
	@CrossOrigin
	@GetMapping(path = "/check-username-exists", produces = "application/json")
	public ResultObject checkUsernameExist(@RequestParam("username") String username) {
		ResultObject resultObject = new ResultObject();
		if (!CommonUtils.isEmptyOrNull(username)) {
			resultObject = registrationService.checkUsernameExistService(username);
		}
		return resultObject;
	}

}
