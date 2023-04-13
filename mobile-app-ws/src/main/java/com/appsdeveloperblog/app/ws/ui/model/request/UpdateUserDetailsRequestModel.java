package com.appsdeveloperblog.app.ws.ui.model.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UpdateUserDetailsRequestModel {
	
	@NotNull(message = "first name cannot be missed or empty!")
	@Size(min = 2, message = "last name must not be less than 2 characters")
	private String firstName;

	@NotNull(message = "last name cannot be missed or empty!")
	@Size(min = 2, message = "last name must not be less than 2 characters")
	private String lastName;

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
}
