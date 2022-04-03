package com.flightapp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flightapp.entity.AirlineInventory;
import com.flightapp.feignclients.AuthService;
import com.flightapp.iservice.IFlightService;
import com.flightapp.model.FlightModel;

@RestController
@RequestMapping("/api/v1.0/flight/search")
public class FlightController {

	@Autowired
	AuthService authService;

	@Autowired
	IFlightService flightService;

	@GetMapping("/allFlight")
	public Iterable<AirlineInventory> viewAllFlight() {
		return flightService.viewAllFlight();
	}

	@GetMapping("/viewFlight")
	public List<AirlineInventory> viewFlight(@RequestBody FlightModel flightModel) {
		try {
			List<AirlineInventory> result = flightService.viewFlight(flightModel);
			if (!result.isEmpty()) {
				return result;
			} else {
				throw new Exception("No flights available.");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<>();
		}
	}

}
