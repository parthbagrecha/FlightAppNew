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
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import com.flightapp.entity.User;
import com.flightapp.model.Admin;
import com.flightapp.model.AuthenticateResponse;
import com.flightapp.respository.UserRepository;

@ExtendWith(MockitoExtension.class)
class AdminServiceTest {

	@InjectMocks
	AdminService adminService;

	@Mock
	UserRepository userRepository;

	@Mock
	private JwtUtil jwtutil;

	@Test
	void testAdminLogin() {
		Admin adminLoginDetails = new Admin("Admin", "Admin", "Admin");
		User admin = new User("Admin", "Admin", "Admin", BigInteger.valueOf(9999999999L));

		when(userRepository.findById("Admin")).thenReturn(Optional.of(admin));
		when(jwtutil.generateToken(admin)).thenReturn("token");

		ResponseEntity<AuthenticateResponse> result = adminService.adminLogin(adminLoginDetails);

		assertNotNull(result);
		assertEquals("Admin", result.getBody().getUsername());
		assertEquals("token", result.getBody().getToken());
	}

	@Test
	void testAdminValidate() {

		User admin = new User("Admin", "Admin", "Admin", BigInteger.valueOf(9999999999L));

		when(jwtutil.extractUsername("345abc")).thenReturn("Admin");
		when(jwtutil.validateToken("345abc")).thenReturn(true);
		when(userRepository.findByName("Admin")).thenReturn(Optional.of(admin));

		ResponseEntity<AuthenticateResponse> result = adminService.adminValidate("token12345abc");

		assertNotNull(result);
		assertEquals("Admin", result.getBody().getUsername());

	}

}
