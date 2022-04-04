package com.flightapp.model;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class PassengerDetailsTest {

	@Test
	void testPassengerDetails1() {
		PassengerDetails passenger = new PassengerDetails();
		passenger.setpName("Test");
		passenger.setpGender("M");
		passenger.setpAge(35);
		passenger.setSeatNo("35A");
		passenger.setMeal("V");

		assertNotNull(passenger);
	}

}
