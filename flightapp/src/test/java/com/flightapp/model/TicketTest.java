package com.flightapp.model;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class TicketTest {

	@Test
	void testTicket1() {
		PassengerDetails passenger = new PassengerDetails();
		Ticket ticket = new Ticket(11110000, passenger);

		assertNotNull(ticket);
	}

	@Test
	void testTicket2() {
		Ticket ticket = new Ticket();

		assertNotNull(ticket);
	}

	@Test
	void testTicket3() {
		Ticket ticket = new Ticket();
		PassengerDetails passenger = new PassengerDetails();

		ticket.setPnr(11110001);
		ticket.setPassenger(passenger);

		assertNotNull(ticket);
	}

}
