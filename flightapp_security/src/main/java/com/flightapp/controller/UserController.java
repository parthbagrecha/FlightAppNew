package com.flightapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flightapp.entity.User;
import com.flightapp.iservice.IAdminService;
import com.flightapp.iservice.IUserService;
import com.flightapp.model.Admin;
import com.flightapp.model.AuthenticateResponse;

@RestController
@RequestMapping("/api/v1.0/user")
public class UserController {

	@Autowired
	IUserService userService;

	@Autowired
	IAdminService adminService;

	@PostMapping(value = "/createUser")
	public String addUser(@RequestBody User newUser) {
		try {
			userService.createUser(newUser);
			return "New user created with mail : " + newUser.getUserEmail();
		} catch (Exception e) {
			e.printStackTrace();
			return e.getMessage();
		}
	}

	@GetMapping(value = "/getUser")
	public User getUser(@RequestHeader("Authorization") final String token) {
		return userService.getUser(token);
	}

	@PostMapping(value = "/login")
	public ResponseEntity<AuthenticateResponse> userLogin(@RequestBody User userlogincredentials) {
		return userService.userLogin(userlogincredentials);
	}

	@GetMapping(value = "/validate")
	public ResponseEntity<AuthenticateResponse> getValidity(@RequestHeader("Authorization") final String token) {
		return userService.validate(token);
	}

	@PostMapping(value = "/adminlogin")
	public ResponseEntity<AuthenticateResponse> adminLogin(@RequestBody Admin adminlogincredentials) {
		return adminService.adminLogin(adminlogincredentials);
	}

	@GetMapping(value = "/adminvalidate")
	public ResponseEntity<AuthenticateResponse> getAdminValidity(@RequestHeader("Authorization") final String token) {
		return adminService.adminValidate(token);
	}

}
