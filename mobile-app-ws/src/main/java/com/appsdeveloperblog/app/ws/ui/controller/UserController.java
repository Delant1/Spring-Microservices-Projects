package com.appsdeveloperblog.app.ws.ui.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.appsdeveloperblog.app.ws.ui.model.request.UpdateUserDetailsRequestModel;
import com.appsdeveloperblog.app.ws.ui.model.request.UserDetailsRequestModel;
import com.appsdeveloperblog.app.ws.ui.model.response.UserRest;
import com.appsdeveloperblog.app.ws.userservice.UserService;

@RestController
@RequestMapping("users") // http://localhost:8080/users
public class UserController {

	Map<String, UserRest> users;

	@Autowired
	UserService service;

	@SuppressWarnings("null")
	@GetMapping(path = "/{userId}", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<UserRest> getUser(@PathVariable String userId) {
		if (users.containsKey(userId))
			return new ResponseEntity<UserRest>(users.get(userId), HttpStatus.OK);
		else
			return new ResponseEntity<UserRest>(HttpStatus.NO_CONTENT);
	}

	@GetMapping
	public String getUser(@RequestParam(value = "page", defaultValue = "1") int page,
			@RequestParam(value = "limit", defaultValue = "50") int limit,
			@RequestParam(value = "limit", required = false) String sort) {
 
		sort = sort == null ? "null" : sort;
		return "get user was called with page = " + page + " and " + limit;
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserRest> createUser(@Valid @RequestBody UserDetailsRequestModel request) {
		UserRest returnValue = service.createUser(request);
		return new ResponseEntity<UserRest>(returnValue, HttpStatus.OK);
	}

	@PutMapping(path = "/{userId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public UserRest updateUser(@PathVariable String userId, @Valid @RequestBody UpdateUserDetailsRequestModel request) {
		UserRest storedUserDetails = users.get(userId);
		storedUserDetails.setFirstName(request.getFirstName());
		storedUserDetails.setLastName(request.getLastName());
		users.put(userId, storedUserDetails);
		return storedUserDetails;
	}

	@DeleteMapping(path = "/{userId}")
	public ResponseEntity<Void> deletUser(@PathVariable String userID) {
		users.remove(userID);
		return ResponseEntity.noContent().build();
	}
}
