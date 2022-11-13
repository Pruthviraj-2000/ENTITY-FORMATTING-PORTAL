package com.ef.demo.auth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ef.demo.auth.controller.UserSigninRequest;
import com.ef.demo.auth.controller.UserSigninResponse;
import com.ef.demo.auth.controller.UserSignupRequest;
import com.ef.demo.auth.controller.UserSignupResponse;
import com.ef.demo.auth.jwt.JwtTokenGenerator;
import com.ef.demo.auth.repository.UserRepository;
import com.ef.demo.errorhandler.BadRequestException;
import com.ef.demo.model.User;

@Service
public class UserService {
	@Autowired
    UserRepository userRepository;
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
    PasswordEncoder passwordEncoder;
    
	@Autowired
    JwtTokenGenerator jwtTokenGenerator;
	
	public UserSignupResponse signup(UserSignupRequest userSignupRequest) {
		try {
			String firstname = userSignupRequest.getFirstname();
			String lastname = userSignupRequest.getLastname();
			String email = userSignupRequest.getEmail();
	        String password = userSignupRequest.getPassword();
	        
	        
	        User user =  userRepository.findByEmail(email);
	        if(user != null) {
	        	throw new BadRequestException("Username is already exist");
	        }
	        
	        User _user = new User(firstname,lastname,email, passwordEncoder.encode(password));
	        _user = userRepository.save(_user);
	        
	        String token = jwtTokenGenerator.createToken(_user.getEmail(), _user.getRoleAsList());
	        
			return new UserSignupResponse(email, token);
		} catch (AuthenticationException e) {
            throw new BadCredentialsException("Invalid username/password");
        }
	}
	public UserSigninResponse signin(UserSigninRequest userSigninRequest) {
		try {
			String email = userSigninRequest.getEmail();
	        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, userSigninRequest.getPassword()));
	        String token = jwtTokenGenerator.createToken(email, this.userRepository.findByEmail(email).getRoleAsList());
	        
			return new UserSigninResponse(email, token);
		} catch (AuthenticationException e) {
            throw new BadCredentialsException("Invalid username/password");
        }
	}
}
