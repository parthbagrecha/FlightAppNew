package com.flightapp.entity;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class BookingTest {

	@Test
	void testBooking1() {
		Booking booking = new Booking(110001, "Test", "Test", "Test", "M", 35, "35A", "X");

		assertNotNull(booking);
	}

	@Test
	void testBooking2() {
		Booking booking = new Booking();
		booking.setPnr(11110001);
		booking.setInventoryId(110001);
		booking.setName("Test");
		booking.setEmail("Test");
		booking.setPassengerName("Test");
		booking.setPassengerGender("M");
		booking.setPassengerAge(35);
		booking.setSeatNo("35A");
		booking.setMeal("X");

		assertNotNull(booking);
	}

}
