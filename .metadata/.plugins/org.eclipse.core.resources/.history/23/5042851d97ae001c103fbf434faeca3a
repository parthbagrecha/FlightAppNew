package com.flightapp.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.flightapp.admin.entity.AirlineInventory;
import com.flightapp.admin.iservice.IInventoryService;

@RestController
@RequestMapping("/api/v1.0/flight/inventory")
public class InventoryController {
	
	@Autowired
	IInventoryService inventoryService;
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addInventory(@RequestBody AirlineInventory airlineInventory) {
		try {
			Integer id = inventoryService.addInventory(airlineInventory);
			return "Inventory added with id "+id+".";
		} catch (Exception e) {
			e.printStackTrace();
			return e.getMessage();
		}
	}

}
