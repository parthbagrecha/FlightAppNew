package com.flightapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.flightapp.iservice.IInventoryService;
import com.flightapp.model.AirlineInventoryModel;

@RestController
@RequestMapping("/api/v1.0/flight/inventory")
public class InventoryController {
	
	@Autowired
	IInventoryService inventoryService;
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addInventory(@RequestBody AirlineInventoryModel airlineInventoryModel) {
		try {
			Integer id = inventoryService.addInventory(airlineInventoryModel);
			return "Inventory added with id "+id+".";
		} catch (Exception e) {
			e.printStackTrace();
			return e.getMessage();
		}
	}

}