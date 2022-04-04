package com.flightapp.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.math.BigInteger;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import com.flightapp.entity.User;
import com.flightapp.model.AuthenticateResponse;
import com.flightapp.respository.UserRepository;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

	@InjectMocks
	UserService userService;

	@Mock
	UserRepository userRepository;

	@Mock
	private JwtUtil jwtutil;

	@Test
	void testCreateUser() throws Exception {
		User newUser = new User();
		newUser.setUserName("User");
		newUser.setUserPassword("User");
		newUser.setUserEmail("User");
		newUser.setUserPhone(BigInteger.valueOf(9999999999L));

		when(userRepository.findById("User")).thenReturn(Optional.empty());
		when(userRepository.save(newUser)).thenReturn(null);

		ResponseEntity<?> result = userService.createUser(newUser);

		assertNotNull(result);
		assertEquals("User Added Successfully", result.getBody());
	}

	@Test
	void testGetUser() {
		User user = new User("User", "User", "User", BigInteger.valueOf(9999999999L));

		when(jwtutil.extractUsername("3abc")).thenReturn("User");
		when(userRepository.findByName("User")).thenReturn(Optional.of(user));

		User result = userService.getUser("token123abc");

		assertNotNull(result);

	}

	@Test
	void testUserLogin() {
		User user = new User("User", "User", "User", BigInteger.valueOf(9999999999L));

		when(userRepository.findById("User")).thenReturn(Optional.of(user));
		when(jwtutil.generateToken(user)).thenReturn("token");

		ResponseEntity<AuthenticateResponse> result = userService.userLogin(user);

		assertNotNull(result);
		assertEquals("User", result.getBody().getUsername());
	}

	@Test
	void testValidate() {
		User user = new User("User", "User", "User", BigInteger.valueOf(9999999999L));

		Mockito.when(jwtutil.validateToken("3abc")).thenReturn(true);
		when(jwtutil.extractUsername("3abc")).thenReturn("User");
		when(userRepository.findByName(jwtutil.extractUsername("3abc"))).thenReturn(Optional.of(user));

		ResponseEntity<AuthenticateResponse> result = userService.validate("token123abc");

		assertNotNull(result);
		assertEquals("User", result.getBody().getUsername());
	}

}
