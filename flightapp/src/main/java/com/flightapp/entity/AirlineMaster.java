package com.flightapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "airline_master")
public class AirlineMaster {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "airline_id")
	private Integer airlineId;

	@Column(name = "airline_name")
	private String airlineName;

	@Column(name = "is_blocked")
	private String isBlocked = "N";

	public Integer getAirlineId() {
		return airlineId;
	}

	public void setAirlineId(Integer airlineId) {
		this.airlineId = airlineId;
	}

	public String getAirlineName() {
		return airlineName;
	}

	public void setAirlineName(String airlineName) {
		this.airlineName = airlineName;
	}

	public String getIsBlocked() {
		return isBlocked;
	}

	public void setIsBlocked(String isBlocked) {
		this.isBlocked = isBlocked;
	}

	public AirlineMaster(Integer airlineId, String airlineName, String isBlocked) {
		super();
		this.airlineId = airlineId;
		this.airlineName = airlineName;
		this.isBlocked = isBlocked;
	}

	public AirlineMaster(String airlineName, String isBlocked) {
		super();
		this.airlineName = airlineName;
		this.isBlocked = isBlocked;
	}

	public AirlineMaster() {
		super();
	}

}
