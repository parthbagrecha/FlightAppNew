package com.flightapp.iservice;

import java.util.List;

import com.flightapp.entity.Booking;
import com.flightapp.model.BooikingInputModel;
import com.flightapp.model.Ticket;

public interface IBookingService {
	
	public List<Ticket> createBooking(BooikingInputModel bookingInput) throws Exception;
	
	public Ticket getTicket(Integer pnr) throws Exception;

	public List<Booking> getHistory(String email) throws Exception;

	public String cancelBooking(Integer pnr) throws Exception;

}
