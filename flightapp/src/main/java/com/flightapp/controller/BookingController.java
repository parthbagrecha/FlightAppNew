package com.flightapp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flightapp.entity.Booking;
import com.flightapp.exception.InvalidTokenException;
import com.flightapp.feignclients.AuthService;
import com.flightapp.iservice.IBookingService;
import com.flightapp.model.BookingInputModel;
import com.flightapp.model.Ticket;
import com.flightapp.model.UserModel;

@RestController
@RequestMapping("/api/v1.0/flight/booking")
public class BookingController {

	@Autowired
	AuthService authService;

	@Autowired
	IBookingService bookingService;

	@PostMapping("/createBooking")
	public List<Ticket> createBooking(@RequestHeader("Authorization") String token,
			@RequestBody BookingInputModel bookingInput) {
		try {
			if (authService.getValidity(token).getBody().isValid()) {
				UserModel user = authService.getUser(token);
				return bookingService.createBooking(bookingInput, user.getUserName(), user.getUserEmail());
			} else {
				throw new InvalidTokenException();
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<>();
		}
	}

	@GetMapping("/getTicket/{pnr}")
	public Ticket getTicket(@RequestHeader("Authorization") String token, @PathVariable("pnr") Integer pnr) {
		try {
			if (authService.getValidity(token).getBody().isValid()) {
				return bookingService.getTicket(pnr);
			} else {
				throw new InvalidTokenException();
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@GetMapping("/history/{email}")
	public List<Booking> getHistory(@RequestHeader("Authorization") String token, @PathVariable("email") String email) {
		try {
			if (authService.getValidity(token).getBody().isValid()) {
				return bookingService.getHistory(email);
			} else {
				throw new InvalidTokenException();
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<>();
		}
	}

	@PostMapping("cancel/{pnr}")
	public String cancelBooking(@RequestHeader("Authorization") String token, @PathVariable("pnr") Integer pnr) {
		try {
			if (authService.getValidity(token).getBody().isValid()) {
				return bookingService.cancelBooking(pnr);
			} else {
				throw new InvalidTokenException();
			}
		} catch (Exception e) {
			return e.getMessage();
		}
	}

}
