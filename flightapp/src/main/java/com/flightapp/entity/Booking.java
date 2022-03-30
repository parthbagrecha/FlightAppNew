package com.flightapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "booking")
public class Booking {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pnr")
	private Integer pnr;

	@Column(name = "inventory_id")
	private Integer inventoryId;

	@Column(name = "name")
	private String name;

	@Column(name = "email")
	private String email;

	@Column(name = "p_name")
	private String passengerName;

	@Column(name = "p_gender")
	private String passengerGender;

	@Column(name = "p_age")
	private Integer passengerAge;

	@Column(name = "seat_no")
	private String seatNo;

	@Column(name = "meal")
	private String meal;

	public Integer getPnr() {
		return pnr;
	}

	public void setPnr(Integer pnr) {
		this.pnr = pnr;
	}

	public Integer getInventoryId() {
		return inventoryId;
	}

	public void setInventoryId(Integer inventoryId) {
		this.inventoryId = inventoryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassengerName() {
		return passengerName;
	}

	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}

	public String getPassengerGender() {
		return passengerGender;
	}

	public void setPassengerGender(String passengerGender) {
		this.passengerGender = passengerGender;
	}

	public Integer getPassengerAge() {
		return passengerAge;
	}

	public void setPassengerAge(Integer passengerAge) {
		this.passengerAge = passengerAge;
	}

	public String getSeatNo() {
		return seatNo;
	}

	public void setSeatNo(String seatNo) {
		this.seatNo = seatNo;
	}

	public String getMeal() {
		return meal;
	}

	public void setMeal(String meal) {
		this.meal = meal;
	}

	public Booking(Integer inventoryId, String name, String email, String passengerName, String passengerGender,
			Integer passengerAge, String seatNo, String meal) {
		super();
		this.inventoryId = inventoryId;
		this.name = name;
		this.email = email;
		this.passengerName = passengerName;
		this.passengerGender = passengerGender;
		this.passengerAge = passengerAge;
		this.seatNo = seatNo;
		this.meal = meal;
	}

	public Booking() {
		super();
	}

}