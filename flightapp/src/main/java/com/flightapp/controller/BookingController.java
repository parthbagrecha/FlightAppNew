package com.flightapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flightapp.entity.Booking;
import com.flightapp.iservice.IBookingService;
import com.flightapp.model.BooikingInputModel;
import com.flightapp.model.Ticket;

@RestController
@RequestMapping("/api/v1.0/flight/booking")
public class BookingController {

	@Autowired
	IBookingService bookingService;

	@PostMapping("/createBooking")
	public List<Ticket> createBooking(@RequestBody BooikingInputModel bookingInput) {
		try {
			return bookingService.createBooking(bookingInput);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@GetMapping("/getTicket/{pnr}")
	public Ticket getTicket(@PathVariable("pnr") Integer pnr) {
		try {
			return bookingService.getTicket(pnr);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@GetMapping("/history/{email}")
	public List<Booking> getHistory(@PathVariable("email") String email) {
		try {
			return bookingService.getHistory(email);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@PostMapping("cancel/{pnr}")
	public String cancelBooking(@PathVariable("pnr") Integer pnr) {
		try {
			return bookingService.cancelBooking(pnr);
		} catch (Exception e) {
			return e.getMessage();
		}
	}

}