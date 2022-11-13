package com.ef.demo.auth.controller;

public class UserSigninRequest {
    private String email;
    
    private String password;
    
    protected UserSigninRequest() {
    	
    }

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserSigninRequest(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
    
}
