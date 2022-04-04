package com.flightapp.model;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class AdminTest {

	@Test
	void testAdmin1() {
		Admin admin = new Admin();
		admin.setUsername("Admin");
		admin.setUserEmail("Admin");
		admin.setPassword("Admin");

		assertNotNull(admin);

	}

}
