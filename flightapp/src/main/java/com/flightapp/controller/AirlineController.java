package com.flightapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flightapp.entity.AirlineMaster;
import com.flightapp.exception.InvalidTokenException;
import com.flightapp.feignclients.AuthService;
import com.flightapp.iservice.IAirlineService;

@RestController
@RequestMapping("/api/v1.0/flight/airline")
public class AirlineController {

	@Autowired
	IAirlineService airlineService;

	@Autowired
	AuthService authService;

	@PostMapping(value = "register")
	public String registerAirline(@RequestHeader("Authorization") String token,
			@RequestBody AirlineMaster airlineMaster) {
		try {
			if (authService.getAdminValidity(token).getBody().isValid()) {
				Integer id = airlineService.registerAirline(airlineMaster);
				return "Airline with id " + id + " added";
			} else {
				throw new InvalidTokenException();
			}
		} catch (Exception e) {
			e.printStackTrace();
			return e.getMessage();
		}
	}

	@PostMapping(value = "/{status}/{airlineId}")
	public String toggleBlock(@RequestHeader("Authorization") String token, @PathVariable("status") String status,
			@PathVariable("airlineId") Integer airlineId) {
		try {
			if (authService.getAdminValidity(token).getBody().isValid()) {
				return airlineService.toggleBlock(status, airlineId);
			} else {
				throw new InvalidTokenException();
			}
		} catch (Exception e) {
			e.printStackTrace();
			return e.getMessage();
		}
	}

}
