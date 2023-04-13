package com.appsdeveloperblog.app.ws.userservice.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appsdeveloperblog.app.ws.shared.Utils;
import com.appsdeveloperblog.app.ws.ui.model.request.UserDetailsRequestModel;
import com.appsdeveloperblog.app.ws.ui.model.response.UserRest;
import com.appsdeveloperblog.app.ws.userservice.UserService;

@Service
public class UserServiceImplementation implements UserService {

	Map<String, UserRest> users;
	
	Utils utils;
	
	public UserServiceImplementation() {}
	
	@Autowired
	public UserServiceImplementation(Utils utils) {
		this.utils = utils;
	}

	@Override
	public UserRest createUser(UserDetailsRequestModel request) {
		UserRest returnValue = new UserRest();
		returnValue.setEmail(request.getEmail());
		returnValue.setFirstName(request.getFirstName());
		returnValue.setLastName(request.getLastName());

		String userId = utils.generatedUserId();
		returnValue.setUserId(userId);
		if (users == null)
			users = new HashMap<>();
		users.put(userId, returnValue);

		return returnValue;
	}
}
