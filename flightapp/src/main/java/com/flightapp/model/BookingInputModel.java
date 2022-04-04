package com.flightapp.model;

import java.util.List;

public class BookingInputModel {

	private Integer inventoryId;
	private Integer noOfSeats;
	private List<PassengerDetails> passengerDetails;

	public Integer getInventoryId() {
		return inventoryId;
	}

	public void setInventoryId(Integer inventoryId) {
		this.inventoryId = inventoryId;
	}

	public Integer getNoOfSeats() {
		return noOfSeats;
	}

	public void setNoOfSeats(Integer noOfSeats) {
		this.noOfSeats = noOfSeats;
	}

	public List<PassengerDetails> getPassengerDetails() {
		return passengerDetails;
	}

	public void setPassengerDetails(List<PassengerDetails> passengerDetails) {
		this.passengerDetails = passengerDetails;
	}

	public BookingInputModel() {
		super();
	}

	public BookingInputModel(Integer inventoryId, Integer noOfSeats, List<PassengerDetails> passengerDetails) {
		super();
		this.inventoryId = inventoryId;
		this.noOfSeats = noOfSeats;
		this.passengerDetails = passengerDetails;
	}

}
