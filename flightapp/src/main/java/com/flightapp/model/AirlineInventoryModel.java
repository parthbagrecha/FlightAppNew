package com.flightapp.model;

import java.time.LocalDateTime;

public class AirlineInventoryModel {

	private Integer airlineId;

	private String instrument;

	private String fromPlace;

	private String toPlace;

	private LocalDateTime startDateTime;

	private LocalDateTime endDateTime;

	private String scheduleDays;

	private Integer businessClassSeats;

	private Integer nonBusinessClassSeats;

	private Integer rows;

	private Integer cost;

	private String meal;

	public Integer getAirlineId() {
		return airlineId;
	}

	public void setAirlineId(Integer airlineId) {
		this.airlineId = airlineId;
	}

	public String getInstrument() {
		return instrument;
	}

	public void setInstrument(String instrument) {
		this.instrument = instrument;
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

	public LocalDateTime getStartDateTime() {
		return startDateTime;
	}

	public void setStartDateTime(LocalDateTime startDateTime) {
		this.startDateTime = startDateTime;
	}

	public LocalDateTime getEndDateTime() {
		return endDateTime;
	}

	public void setEndDateTime(LocalDateTime endDateTime) {
		this.endDateTime = endDateTime;
	}

	public String getScheduleDays() {
		return scheduleDays;
	}

	public void setScheduleDays(String scheduleDays) {
		this.scheduleDays = scheduleDays;
	}

	public Integer getBusinessClassSeats() {
		return businessClassSeats;
	}

	public void setBusinessClassSeats(Integer businessClassSeats) {
		this.businessClassSeats = businessClassSeats;
	}

	public Integer getNonBusinessClassSeats() {
		return nonBusinessClassSeats;
	}

	public void setNonBusinessClassSeats(Integer nonBusinessClassSeats) {
		this.nonBusinessClassSeats = nonBusinessClassSeats;
	}

	public Integer getRows() {
		return rows;
	}

	public void setRows(Integer rows) {
		this.rows = rows;
	}

	public Integer getCost() {
		return cost;
	}

	public void setCost(Integer cost) {
		this.cost = cost;
	}

	public String getMeal() {
		return meal;
	}

	public void setMeal(String meal) {
		this.meal = meal;
	}

	public AirlineInventoryModel(Integer airlineId, String instrument, String fromPlace, String toPlace,
			LocalDateTime startDateTime, LocalDateTime endDateTime, String scheduleDays, Integer businessClassSeats,
			Integer nonBusinessClassSeats, Integer rows, Integer cost, String meal) {
		super();
		this.airlineId = airlineId;
		this.instrument = instrument;
		this.fromPlace = fromPlace;
		this.toPlace = toPlace;
		this.startDateTime = startDateTime;
		this.endDateTime = endDateTime;
		this.scheduleDays = scheduleDays;
		this.businessClassSeats = businessClassSeats;
		this.nonBusinessClassSeats = nonBusinessClassSeats;
		this.rows = rows;
		this.cost = cost;
		this.meal = meal;
	}

	public AirlineInventoryModel() {
		super();
	}

}
