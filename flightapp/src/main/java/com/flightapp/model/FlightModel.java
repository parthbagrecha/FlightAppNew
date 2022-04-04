package com.flightapp.model;

import java.time.LocalDateTime;

public class FlightModel {

	private LocalDateTime dateTime;
	private String fromPlace;
	private String toPlace;

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	public String getFromPlace() {
		return fromPlace;
	}

	public void setFromPlace(String fromPlace) {
		this.fromPlace = fromPlace;
	}

	public String getToPlace() {
		return toPlace;
	}

	public void setToPlace(String toPlace) {
		this.toPlace = toPlace;
	}

	public FlightModel() {
		super();
	}

	public FlightModel(LocalDateTime dateTime, String fromPlace, String toPlace) {
		super();
		this.dateTime = dateTime;
		this.fromPlace = fromPlace;
		this.toPlace = toPlace;
	}

}
