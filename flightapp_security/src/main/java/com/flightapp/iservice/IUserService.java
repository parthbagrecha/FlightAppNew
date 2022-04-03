package com.flightapp.iservice;

import org.springframework.http.ResponseEntity;

import com.flightapp.entity.User;
import com.flightapp.model.AuthenticateResponse;

public interface IUserService {

	public ResponseEntity<?> createUser(User newUser) throws Exception;

	public ResponseEntity<AuthenticateResponse> userLogin(User loginDetails);

	public ResponseEntity<AuthenticateResponse> validate(String authToken);

	public User getUser(String token);

}
