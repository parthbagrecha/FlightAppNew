package com.flightapp.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.flightapp.admin.entity.AirlineMaster;
import com.flightapp.admin.iservice.IAirlineService;

@RestController
@RequestMapping("/api/v1.0/flight/airline")
public class AirlineController {

	@Autowired
	IAirlineService airlineService;

	@RequestMapping(value = "register", method = RequestMethod.POST)
	public String registerAirline(@RequestBody AirlineMaster airlineMaster) {
		Integer id = airlineService.registerAirline(airlineMaster);
		return "Airline with id "+ id +" added";
	}

	@RequestMapping(value = "toggleBlock", method = RequestMethod.POST)
	public String toggleBlock() {
		airlineService.toggleBlock();
		return null;
	}

}
