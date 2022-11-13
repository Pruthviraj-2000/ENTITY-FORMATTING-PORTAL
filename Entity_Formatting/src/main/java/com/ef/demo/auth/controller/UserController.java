package com.ef.demo.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ef.demo.auth.jwt.JwtTokenGenerator;
import com.ef.demo.auth.repository.UserRepository;
import com.ef.demo.auth.service.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
public class UserController {	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
    PasswordEncoder passwordEncoder;
    
	@Autowired
    JwtTokenGenerator jwtTokenGenerator;
    
	@Autowired
    UserRepository userRepository;
	
	@Autowired
	UserService userService;
    
	
	@ResponseStatus(code = HttpStatus.OK)
	@RequestMapping(value = "/api/auth/signin", method = RequestMethod.POST)
    public ResponseEntity<UserSigninResponse> signin(@RequestBody UserSigninRequest userSigninRequest) {
		return new ResponseEntity<>(userService.signin(userSigninRequest), HttpStatus.OK);
    }
	
	@ResponseStatus(code = HttpStatus.OK)
	@RequestMapping(value = "/api/auth/signup", method = RequestMethod.POST)
    public ResponseEntity<UserSignupResponse> signup(@RequestBody UserSignupRequest userSignupRequest) {
		return new ResponseEntity<>(userService.signup(userSignupRequest), HttpStatus.OK);
    }
}
