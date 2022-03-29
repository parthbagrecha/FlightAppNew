package com.flightapp.admin.entity;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "airline_inventory")
public class AirlineInventory {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "inventory_id")
	private Integer inventoryId;

	@Column(name = "airline_id")
	private Integer airline_id;

	@Column(name = "airline_name")
	private String airlineName;

	@Column(name = "from_place")
	private String fromPlace;

	@Column(name = "to_place")
	private String toPlace;

	@Column(name = "start_date_time")
	private LocalDateTime startDateTime;

	@Column(name = "end_date_time")
	private LocalDateTime endDateTime;

	@Column(name = "schedule_days")
	private Integer scheduleDays;

	@Column(name = "instrument")
	private String instrument;

	@Column(name = "business_class_seats")
	private Integer businessClassSeats;

	@Column(name = "non_business_class_seats")
	private Integer nonBusinessClassSeats;

	@Column(name = "cost")
	private Integer cost;

	@Column(name = "rows")
	private Integer rows;

	@Column(name = "meal")
	private String meal;

	public Integer getInventoryId() {
		return inventoryId;
	}

	public void setInventoryId(Integer inventoryId) {
		this.inventoryId = inventoryId;
	}

	public Integer getAirline_id() {
		return airline_id;
	}

	public void setAirline_id(Integer airline_id) {
		this.airline_id = airline_id;
	}

	public String getAirlineName() {
		return airlineName;
	}

	public void setAirlineName(String airlineName) {
		this.airlineName = airlineName;
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

	public Integer getScheduleDays() {
		return scheduleDays;
	}

	public void setScheduleDays(Integer scheduleDays) {
		this.scheduleDays = scheduleDays;
	}

	public String getInstrument() {
		return instrument;
	}

	public void setInstrument(String instrument) {
		this.instrument = instrument;
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

	public Integer getCost() {
		return cost;
	}

	public void setCost(Integer cost) {
		this.cost = cost;
	}

	public Integer getRows() {
		return rows;
	}

	public void setRows(Integer rows) {
		this.rows = rows;
	}

	public String getMeal() {
		return meal;
	}

	public void setMeal(String meal) {
		this.meal = meal;
	}

}
