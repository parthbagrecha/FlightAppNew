package com.flightapp.admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flightapp.admin.entity.AirlineInventory;
import com.flightapp.admin.iservice.IInventoryService;
import com.flightapp.admin.repository.InventoryRepository;

@Service
public class InventoryService implements IInventoryService {

	@Autowired
	InventoryRepository inventoryRepository;

	@Override
	public Integer addInventory(AirlineInventory airlineInventory) {
		try {
			airlineInventory = inventoryRepository.save(airlineInventory);
			return airlineInventory.getInventoryId();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

}
