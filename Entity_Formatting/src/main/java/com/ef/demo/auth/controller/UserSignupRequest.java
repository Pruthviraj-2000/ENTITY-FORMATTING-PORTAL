package com.ef.demo.auth.controller;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class UserSignupRequest {
	@NotEmpty(message = "firstname is required")
	private String firstname;
	@NotEmpty(message = "lastname is required")    
	private String lastname;
	@NotEmpty(message = "email is required")
    private String email;
    
    @NotEmpty(message = "Password is required")
    @Size(min=8, message = "Password length should be 8 characters or more")
    private String password;
    
    protected UserSignupRequest() {
    	
    }

	public UserSignupRequest(String firstname,String lastname,String email, String password) {
		super();
		this.firstname=firstname;
		this.lastname=lastname;
		this.email = email;
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}
	

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}
    
    
}

