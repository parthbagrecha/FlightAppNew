package com.flightapp.iservice;

import org.springframework.http.ResponseEntity;

import com.flightapp.entity.User;
import com.flightapp.model.AuthenticateResponse;

public interface IUserService {
	
	public ResponseEntity<?> createUser(User newUser) throws Exception;
	
//	public ResponseEntity<?> findUserById(Integer userId);

	ResponseEntity<AuthenticateResponse> userLogin(User loginDetails) throws Exception;

	ResponseEntity<AuthenticateResponse> validate(String authToken);

}
