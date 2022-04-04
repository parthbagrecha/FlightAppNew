package com.flightapp.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.flightapp.entity.Booking;
import com.flightapp.model.Ticket;
import com.flightapp.repository.BookingRepository;

@ExtendWith(MockitoExtension.class)
class BookingServiceTest {

	@InjectMocks
	BookingService bookingService;

	@Mock
	BookingRepository bookingRepository;

//	@Test
//	void testCreateBooking() throws Exception {
//		PassengerDetails passenger = new PassengerDetails("Test", "M", 35, "35A", "X");
//		List<PassengerDetails> passengerDetails = new ArrayList<>();
//		passengerDetails.add(passenger);
//		BookingInputModel bookingInputModel = new BookingInputModel(110001, 1, passengerDetails);
//
//		Booking booking = new Booking(110001, "Test", "Test", "Test", "M", 35, "35A", "X");
//
//		Ticket ticket = new Ticket(11110001, passenger);
//		List<Ticket> tickets = new ArrayList<Ticket>();
//		tickets.add(ticket);
//
////		when(bookingRepository.save(booking)).thenReturn(booking);
//		when(bookingService.createBooking(bookingInputModel, "Test", "Test")).thenReturn(tickets);
//
//		List<Ticket> result = bookingService.createBooking(bookingInputModel, "Test", "Test");
//		assertNotNull(result);
//	}

	@Test
	void testGetTicket() throws Exception {
		Booking booking = new Booking(110001, "Test", "Test", "Test", "M", 35, "35A", "X");

		when(bookingRepository.getById(11110001)).thenReturn(booking);

		Ticket result = bookingService.getTicket(11110001);

		assertNotNull(result);
		assertEquals(11110001, result.getPnr());
	}

	@Test
	void testGetHistory() throws Exception {
		Booking booking = new Booking(110001, "Test", "Test", "Test", "M", 35, "35A", "X");
		List<Booking> bookings = new ArrayList<Booking>();
		bookings.add(booking);

		when(bookingRepository.findAllBasedOnEmail("Test")).thenReturn(bookings);

		List<Booking> result = bookingService.getHistory("Test");

		assertNotNull(result);
		assertEquals(bookings, result);
	}

	@Test
	void testCancelBooking() throws Exception {
		doNothing().when(bookingRepository).deleteById(11110001);

		String result = bookingService.cancelBooking(11110001);

		assertEquals("Booking with pnr 11110001 deleted.", result);
	}

}
