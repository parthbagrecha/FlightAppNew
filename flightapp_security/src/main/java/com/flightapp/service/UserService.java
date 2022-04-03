package com.flightapp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.flightapp.entity.User;
import com.flightapp.iservice.IUserService;
import com.flightapp.model.AuthenticateResponse;
import com.flightapp.respository.UserRepository;

@Service
public class UserService implements IUserService {

	@Autowired
	private JwtUtil jwtutil;

	@Autowired
	UserRepository userRepository;

	@Override
	public ResponseEntity<?> createUser(User newUser) throws Exception {
		Optional<User> user = userRepository.findById(newUser.getUserEmail());
		if (user.isEmpty()) {
			try {
				userRepository.save(newUser);
				return new ResponseEntity<>("User Added Successfully", HttpStatus.CREATED);
			} catch (Exception ex) {
				throw new Exception("User with email already Exists");
			}
		} else {
			throw new Exception("User with email already Exists");
		}
	}

	@Override
	public User getUser(String token) {
		String token1 = token.substring(7);
		Optional<User> user = userRepository.findByName(jwtutil.extractUsername(token1));
		if (user.isPresent()) {
			return user.get();
		}
		else {
			return null;
		}
	}

	@Override
	public ResponseEntity<AuthenticateResponse> userLogin(User loginDetails) {
		final Optional<User> userDetails = userRepository.findById(loginDetails.getUserEmail());
		String uid = "";
		String generateToken = "";
		User user = userDetails.get();
		if (user.getUserPassword().equals(loginDetails.getUserPassword())) {
			uid = loginDetails.getUserEmail();
			generateToken = jwtutil.generateToken(user);

			return new ResponseEntity<>(new AuthenticateResponse(uid, true, generateToken), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(
					new AuthenticateResponse(loginDetails.getUserEmail(), false, "In Correct Password"),
					HttpStatus.FORBIDDEN);
		}
	}

	@Override
	public ResponseEntity<AuthenticateResponse> validate(String authToken) {
		String token1 = authToken.substring(7);
		AuthenticateResponse res = new AuthenticateResponse();
		if (Boolean.TRUE.equals(jwtutil.validateToken(token1))) {
			res.setUsername(jwtutil.extractUsername(token1));
			res.setValid(true);
			Optional<User> user1 = userRepository.findByName(jwtutil.extractUsername(token1));
			if (user1.isPresent()) {
				res.setUsername(user1.get().getUserEmail());
				res.setValid(true);
				res.setToken("token successfully validated");

			}
		} else {
			res.setValid(false);
			res.setToken("Invalid Token Received");

		}
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

}
