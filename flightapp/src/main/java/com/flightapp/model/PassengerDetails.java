package com.flightapp.model;

public class PassengerDetails {

	private String pName;
	private String pGender;
	private Integer pAge;
	private String seatNo;
	private String meal;

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public String getpGender() {
		return pGender;
	}

	public void setpGender(String pGender) {
		this.pGender = pGender;
	}

	public Integer getpAge() {
		return pAge;
	}

	public void setpAge(Integer pAge) {
		this.pAge = pAge;
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

	public PassengerDetails(String pName, String pGender, Integer pAge, String seatNo, String meal) {
		super();
		this.pName = pName;
		this.pGender = pGender;
		this.pAge = pAge;
		this.seatNo = seatNo;
		this.meal = meal;
	}

	public PassengerDetails() {
		super();
	}

}
