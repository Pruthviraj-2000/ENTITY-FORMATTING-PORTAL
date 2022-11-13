package com.ef.demo.auth.controller;

public class UserSigninResponse {
	private String email;
	private String token;
	
	protected UserSigninResponse() {
		
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public UserSigninResponse(String email, String token) {
		super();
		this.email = email;
		this.token = token;
	}
	
	
}
