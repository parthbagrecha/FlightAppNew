package com.flightapp.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.flightapp.entity.Booking;
import com.flightapp.feignclients.AuthService;
import com.flightapp.model.AuthenticateResponse;
import com.flightapp.model.BookingInputModel;
import com.flightapp.model.PassengerDetails;
import com.flightapp.model.Ticket;
import com.flightapp.model.UserModel;
import com.flightapp.service.BookingService;

@ExtendWith(MockitoExtension.class)
class BookingControllerTest {

	@InjectMocks
	BookingController bookingController;

	@Mock
	BookingService bookingService;

	@Mock
	AuthService authService;

	@Test
	void testCreateBooking() throws Exception {
		PassengerDetails passenger = new PassengerDetails("Test", "M", 35, "35A", "X");
		List<PassengerDetails> passengerDetails = new ArrayList<PassengerDetails>();
		passengerDetails.add(passenger);
		BookingInputModel bookingInput = new BookingInputModel(1100, 1, passengerDetails);

		AuthenticateResponse tokenValid = new AuthenticateResponse("Test", true, "token successfully validated");
		ResponseEntity<AuthenticateResponse> authResponse = new ResponseEntity<AuthenticateResponse>(tokenValid,
				HttpStatus.OK);

		Ticket ticket = new Ticket(11110000, passenger);
		List<Ticket> tickets = new ArrayList<Ticket>();
		tickets.add(ticket);

		UserModel user = new UserModel("Test", "Test", "Test", BigInteger.valueOf(9999999999L));
		when(authService.getValidity("token")).thenReturn(authResponse);
		when(authService.getUser("token")).thenReturn(user);
		when(bookingService.createBooking(bookingInput, "Test", "Test")).thenReturn(tickets);
		List<Ticket> result = bookingController.createBooking("token", bookingInput);

		assertNotNull(result);
		assertEquals(11110000, result.get(0).getPnr());
	}

	@Test
	void testGetTicket() throws Exception {
		AuthenticateResponse tokenValid = new AuthenticateResponse("Test", true, "token successfully validated");
		ResponseEntity<AuthenticateResponse> authResponse = new ResponseEntity<AuthenticateResponse>(tokenValid,
				HttpStatus.OK);

		Ticket ticket = new Ticket(11110000, null);

		when(authService.getValidity("token")).thenReturn(authResponse);
		when(bookingService.getTicket(11110000)).thenReturn(ticket);
		Ticket result = bookingController.getTicket("token", 11110000);

		assertNotNull(result);
		assertEquals(11110000, result.getPnr());
	}

	@Test
	void testGetHistory() throws Exception {
		AuthenticateResponse tokenValid = new AuthenticateResponse("Test", true, "token successfully validated");
		ResponseEntity<AuthenticateResponse> authResponse = new ResponseEntity<AuthenticateResponse>(tokenValid,
				HttpStatus.OK);

		Booking booking = new Booking(1100, "Test", "Test", "Test", "M", 35, "35A", "X");
		List<Booking> bookings = new ArrayList<Booking>();
		bookings.add(booking);

		when(authService.getValidity("token")).thenReturn(authResponse);
		when(bookingService.getHistory("Test")).thenReturn(bookings);

		List<Booking> result = bookingController.getHistory("token", "Test");

		assertNotNull(result);
		assertEquals(1100, result.get(0).getInventoryId());
	}

	@Test
	void testCancelBooking() throws Exception {
		AuthenticateResponse tokenValid = new AuthenticateResponse("Test", true, "token successfully validated");
		ResponseEntity<AuthenticateResponse> authResponse = new ResponseEntity<AuthenticateResponse>(tokenValid,
				HttpStatus.OK);

		when(authService.getValidity("token")).thenReturn(authResponse);
		when(bookingService.cancelBooking(11110000)).thenReturn("Booking with pnr 11110000 deleted.");
		when(bookingService.cancelBooking(11110001)).thenReturn("Booking with pnr 11110000 doesn't exist.");

		String result1 = bookingController.cancelBooking("token", 11110000);
		String result2 = bookingController.cancelBooking("token", 11110001);

		assertEquals("Booking with pnr 11110000 deleted.", result1);
		assertEquals("Booking with pnr 11110000 doesn't exist.", result2);
	}

}
