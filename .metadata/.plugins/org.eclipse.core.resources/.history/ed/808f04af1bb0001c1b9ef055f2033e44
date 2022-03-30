package com.flightapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.flightapp.entity.User;
import com.flightapp.iservice.IUserService;

@RestController
@RequestMapping("/api/v1.0/user")
public class UserController {

	@Autowired
	IUserService userService;

	@RequestMapping(value = "/createUser", method = RequestMethod.POST)
	public String addUser(@RequestBody User newUser) {
		try {
			userService.createUser(newUser);
			return "New user created with id : "+newUser.getUserId();
		} catch (Exception e) {
			e.printStackTrace();
			return "Something went wrong, please check the data entered";
		}
	}

	@RequestMapping(value = "/searchUser/{userId}", method = RequestMethod.GET)
	public ResponseEntity<?> searchUserByID(@PathVariable("userId") Integer userId) {

		return userService.findUserById(userId);
	}

}
