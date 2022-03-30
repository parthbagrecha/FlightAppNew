package com.flightapp.iservice;

import java.util.List;

import com.flightapp.entity.AirlineInventory;
import com.flightapp.model.FlightModel;

public interface IFlightService {
	
	public Iterable<AirlineInventory> viewAllFlight();
	
	public List<AirlineInventory> viewFlight(FlightModel flightModel) throws Exception;

}
