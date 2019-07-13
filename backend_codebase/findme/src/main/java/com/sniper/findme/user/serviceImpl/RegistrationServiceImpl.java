package com.sniper.findme.user.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sniper.findme.common.constant.ErrorConstant;
import com.sniper.findme.common.model.ErrorDetails;
import com.sniper.findme.common.model.ResultObject;
import com.sniper.findme.common.utility.CommonUtils;
import com.sniper.findme.user.model.User;
import com.sniper.findme.user.repository.UserRepository;
import com.sniper.findme.user.service.RegistrationService;

// TODO: Auto-generated Javadoc
/**
 * The Class RegistrationServiceImpl.
 */
@Service
@Transactional
public class RegistrationServiceImpl implements RegistrationService {

	/** The user repository. */
	@Autowired
	private UserRepository userRepository;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.sniper.findme.user.service.RegistrationService#registerUserService(com.
	 * sniper.findme.user.model.User)
	 */
	@Override
	public ResultObject registerUserService(User user) {
		// TODO Auto-generated method stub
		ResultObject resultObject = new ResultObject();
		resultObject = this.checkEmailExistService(user.getEmail());
		if (CommonUtils.isListEmptyOrNull(resultObject.getErrorList())) {
			user.setPassword(CommonUtils.encryptData(user.getPassword()));
			User savedUser = userRepository.save(user);
			resultObject.setResult(savedUser);
		}
		return resultObject;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.sniper.findme.user.service.RegistrationService#checkEmailExistService(
	 * java.lang.String)
	 */
	@Override
	public ResultObject checkEmailExistService(String email) {
		ResultObject resultObject = new ResultObject();
		User userWithExistingEmail = userRepository.findUserByEmail(email);
		if (!CommonUtils.isEmptyOrNull(userWithExistingEmail)) {
			List<ErrorDetails> errorDetailsList = new ArrayList<>();
			errorDetailsList.add(new ErrorDetails("FIND_ME_ERROR_CODE_002", ErrorConstant.FIND_ME_ERROR_CODE_002));
			resultObject.setErrorList(errorDetailsList);
		}
		return resultObject;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.sniper.findme.user.service.RegistrationService#checkUsernameExistService(
	 * java.lang.String)
	 */
	@Override
	public ResultObject checkUsernameExistService(String username) {
		ResultObject resultObject = new ResultObject();
		User userWithExistingUsername = userRepository.findUserByUserName(username);
		if (!CommonUtils.isEmptyOrNull(userWithExistingUsername)) {
			List<ErrorDetails> errorDetailsList = new ArrayList<>();
			errorDetailsList.add(new ErrorDetails("FIND_ME_ERROR_CODE_003", ErrorConstant.FIND_ME_ERROR_CODE_003));
			resultObject.setErrorList(errorDetailsList);
		}
		return resultObject;
	}

}
