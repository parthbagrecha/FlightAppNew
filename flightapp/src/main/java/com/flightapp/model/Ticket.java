package com.flightapp.model;

public class Ticket {

	private Integer pnr;
	private PassengerDetails passenger;

	public Integer getPnr() {
		return pnr;
	}

	public void setPnr(Integer pnr) {
		this.pnr = pnr;
	}

	public PassengerDetails getPassenger() {
		return passenger;
	}

	public void setPassenger(PassengerDetails passenger) {
		this.passenger = passenger;
	}

	public Ticket(Integer pnr, PassengerDetails passenger) {
		super();
		this.pnr = pnr;
		this.passenger = passenger;
	}

	public Ticket() {
		super();
	}

}
