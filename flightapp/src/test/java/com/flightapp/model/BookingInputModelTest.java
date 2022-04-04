package com.flightapp.model;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class BookingInputModelTest {

	@Test
	void testBookingInputModel1() {
		BookingInputModel booking = new BookingInputModel();
		booking.setInventoryId(110001);
		booking.setNoOfSeats(3);
		PassengerDetails passenger = new PassengerDetails();
		List<PassengerDetails> passengers = new ArrayList<>();
		passengers.add(passenger);
		booking.setPassengerDetails(passengers);
		
		assertNotNull(booking);
	}

}
