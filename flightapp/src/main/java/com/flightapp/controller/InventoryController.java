package com.flightapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flightapp.exception.InvalidTokenException;
import com.flightapp.feignclients.AuthService;
import com.flightapp.iservice.IInventoryService;
import com.flightapp.model.AirlineInventoryModel;

@RestController
@RequestMapping("/api/v1.0/flight/inventory")
public class InventoryController {

	@Autowired
	AuthService authService;

	@Autowired
	IInventoryService inventoryService;

	@PostMapping(value = "/add")
	public String addInventory(@RequestHeader("Authorization") String token,
			@RequestBody AirlineInventoryModel airlineInventoryModel) {
		try {
			if (authService.getAdminValidity(token).getBody().isValid()) {
				Integer id = inventoryService.addInventory(airlineInventoryModel);
				return "Inventory added with id " + id + ".";
			} else {
				throw new InvalidTokenException();
			}
		} catch (Exception e) {
			e.printStackTrace();
			return e.getMessage();
		}
	}

}
