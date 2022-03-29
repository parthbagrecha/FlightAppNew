package com.flightapp.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
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
		try {
			Integer id = airlineService.registerAirline(airlineMaster);
			return "Airline with id " + id + " added";
		} catch (Exception e) {
			e.printStackTrace();
			return e.getMessage();
		}
	}

	@RequestMapping(value = "/{status}/{airlineId}", method = RequestMethod.POST)
	public String toggleBlock(@PathVariable("status") String status, @PathVariable("airlineId") Integer airlineId)
			throws Exception {
		try {
			String result = airlineService.toggleBlock(status, airlineId);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return e.getMessage();
		}
	}

}
