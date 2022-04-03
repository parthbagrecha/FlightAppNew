package com.flightapp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.flightapp.entity.User;
import com.flightapp.iservice.IAdminService;
import com.flightapp.model.Admin;
import com.flightapp.model.AuthenticateResponse;
import com.flightapp.respository.UserRepository;

@Service
public class AdminService implements IAdminService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	private JwtUtil jwtutil;

	@Override
	public ResponseEntity<AuthenticateResponse> adminLogin(Admin adminLoginDetails) {
		if (adminLoginDetails.getUsername().equals("Admin")) {
			String uid = "";
			String generateToken = "";
			Optional<User> admin = userRepository.findById(adminLoginDetails.getUserEmail());
			if (adminLoginDetails.getPassword().equals(admin.get().getUserPassword())) {
				uid = adminLoginDetails.getUserEmail();
				generateToken = jwtutil.generateToken(admin.get());
				return new ResponseEntity<>(new AuthenticateResponse(uid, true, generateToken), HttpStatus.OK);
			} else {
				return new ResponseEntity<>(
						new AuthenticateResponse(adminLoginDetails.getUserEmail(), false, "In Correct Password"),
						HttpStatus.FORBIDDEN);
			}
		} else {
			return new ResponseEntity<>(
					new AuthenticateResponse(adminLoginDetails.getUserEmail(), false, "No admins with such Username"),
					HttpStatus.FORBIDDEN);
		}

	}

	@Override
	public ResponseEntity<AuthenticateResponse> adminValidate(String authToken) {
		String token1 = authToken.substring(7);
		AuthenticateResponse res = new AuthenticateResponse();
		if (jwtutil.extractUsername(token1).equalsIgnoreCase("admin")) {
			if (Boolean.TRUE.equals(jwtutil.validateToken(token1))) {
				res.setUsername(jwtutil.extractUsername(token1));
				res.setValid(true);
				Optional<User> adminUser = userRepository.findByName(jwtutil.extractUsername(token1));
				if (adminUser.isPresent()) {
					res.setUsername(adminUser.get().getUserName());
					res.setValid(true);
					res.setToken("token successfully validated");

				} else {
					res.setValid(false);
					res.setToken("Invalid Token Received");
				}
			} else {
				res.setValid(false);
				res.setToken("Invalid Token Received");
			}
		} else {
			res.setValid(false);
			res.setToken("Invalid Token Received");
		}

		return new ResponseEntity<>(res, HttpStatus.OK);
	}

}
