package com.flightapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flightapp.entity.Booking;
import com.flightapp.exception.RecordNotFoundException;
import com.flightapp.iservice.IBookingService;
import com.flightapp.model.BookingInputModel;
import com.flightapp.model.PassengerDetails;
import com.flightapp.model.Ticket;
import com.flightapp.repository.BookingRepository;

@Service
public class BookingService implements IBookingService {

	@Autowired
	BookingRepository bookingRepository;

	@Override
	public List<Ticket> createBooking(BookingInputModel bookingInput, String name, String email) throws Exception {
		if (bookingInput.getNoOfSeats() != bookingInput.getPassengerDetails().size()) {
			throw new Exception("Please enter correct no of Passengers");
		}

		List<Ticket> ticketList = new ArrayList<>();

		for (PassengerDetails passenger : bookingInput.getPassengerDetails()) {
			Booking booking = new Booking();
			booking.setInventoryId(bookingInput.getInventoryId());
			booking.setPassengerName(passenger.getpName());
			booking.setPassengerGender(passenger.getpGender());
			booking.setPassengerAge(passenger.getpAge());
			booking.setSeatNo(passenger.getSeatNo());
			booking.setMeal(passenger.getMeal());
			booking.setEmail(email);
			booking.setName(name);

			booking = bookingRepository.save(booking);

			Ticket ticket = new Ticket(booking.getPnr(), passenger);
			ticketList.add(ticket);
		}
		return ticketList;
	}

	@Override
	public Ticket getTicket(Integer pnr) throws Exception {
		Booking booking = bookingRepository.getById(pnr);
		if (booking == null) {
			throw new RecordNotFoundException("No ticket found with this pnr.");
		}
		PassengerDetails passenger = new PassengerDetails(booking.getPassengerName(), booking.getPassengerGender(),
				booking.getPassengerAge(), booking.getSeatNo(), booking.getMeal());
		return new Ticket(pnr, passenger);
	}

	@Override
	public List<Booking> getHistory(String email) throws Exception {
		List<Booking> bookings = bookingRepository.findAllBasedOnEmail(email);
		if (bookings.isEmpty()) {
			throw new RecordNotFoundException("No previous bookings with this email.");
		}
		return bookings;
	}

	@Override
	public String cancelBooking(Integer pnr) throws Exception {
		try {
			bookingRepository.deleteById(pnr);
			return "Booking with pnr "+pnr+" deleted.";
		} catch (Exception e) {
			throw new RecordNotFoundException("Booking with pnr "+pnr+" doesn't exist.");
		}
	}

}
