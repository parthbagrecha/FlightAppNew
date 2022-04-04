package com.flightapp.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.math.BigInteger;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.flightapp.entity.User;
import com.flightapp.model.Admin;
import com.flightapp.model.AuthenticateResponse;
import com.flightapp.service.AdminService;
import com.flightapp.service.UserService;

@ExtendWith(MockitoExtension.class)
class UserControllerTest {

	@InjectMocks
	UserController userController;

	@Mock
	UserService userService;

	@Mock
	AdminService adminService;

	@Test
	void testAddUser() throws Exception {
		User user = new User("User", "User", "User", BigInteger.valueOf(9999999999L));

		when(userService.createUser(user)).thenReturn(null);

		String result = userController.addUser(user);

		assertNotNull(result);
		assertEquals("New user created with mail : User", result);
	}

	@Test
	void testGetUser() {
		User user = new User("User", "User", "User", BigInteger.valueOf(9999999999L));

		when(userService.getUser("token")).thenReturn(user);

		User result = userController.getUser("token");

		assertNotNull(result);
	}

	@Test
	void testUserLogin() {
		User user = new User("User", "User", "User", BigInteger.valueOf(9999999999L));
		AuthenticateResponse auth = new AuthenticateResponse();
		ResponseEntity<AuthenticateResponse> resp = new ResponseEntity<AuthenticateResponse>(auth, HttpStatus.OK);

		when(userService.userLogin(user)).thenReturn(resp);

		ResponseEntity<AuthenticateResponse> result = userController.userLogin(user);

		assertNotNull(result);
	}

	@Test
	void testAdminLogin() {
		Admin admin = new Admin("Admin", "Admin", "Admin");
		AuthenticateResponse auth = new AuthenticateResponse();
		ResponseEntity<AuthenticateResponse> resp = new ResponseEntity<AuthenticateResponse>(auth, HttpStatus.OK);

		when(adminService.adminLogin(admin)).thenReturn(resp);

		ResponseEntity<AuthenticateResponse> result = userController.adminLogin(admin);

		assertNotNull(result);
	}

	@Test
	void testGetValidity() {
		User user = new User("User", "User", "User", BigInteger.valueOf(9999999999L));
		AuthenticateResponse auth = new AuthenticateResponse();
		ResponseEntity<AuthenticateResponse> resp = new ResponseEntity<AuthenticateResponse>(auth, HttpStatus.OK);

		when(userService.validate("token")).thenReturn(resp);

		ResponseEntity<AuthenticateResponse> result = userController.getValidity("token");

		assertNotNull(result);
	}

	@Test
	void testGetAdminValidity() {
		Admin admin = new Admin("Admin", "Admin", "Admin");
		AuthenticateResponse auth = new AuthenticateResponse();
		ResponseEntity<AuthenticateResponse> resp = new ResponseEntity<AuthenticateResponse>(auth, HttpStatus.OK);

		when(adminService.adminValidate("token")).thenReturn(resp);

		ResponseEntity<AuthenticateResponse> result = userController.getAdminValidity("token");

		assertNotNull(result);
	}

}
