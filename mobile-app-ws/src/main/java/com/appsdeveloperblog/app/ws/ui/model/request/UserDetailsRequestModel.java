package com.appsdeveloperblog.app.ws.ui.model.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserDetailsRequestModel {
	@NotNull(message = "first name cannot be missed or empty!")
	@Size(min = 2, message = "last name must not be less than 2 characters")
	private String firstName;

	@NotNull(message = "last name cannot be missed or empty!")
	@Size(min = 2, message = "last name must not be less than 2 characters")
	private String lastName;

	@NotNull(message = "password cannot be missed or empty!")
	@Size(min = 8, max = 16, message = "Password must be equal or greater than 8 characters and less than 16 characters")
	private String password;

	@NotNull(message = "email cannot be missed or empty!")
	@Email
	private String email;

	public UserDetailsRequestModel(String firstName, String lastName, String password, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.email = email;
	}

	public UserDetailsRequestModel() {
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
