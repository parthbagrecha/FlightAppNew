package com.flightapp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flightapp.entity.AirlineInventory;
import com.flightapp.entity.AirlineMaster;
import com.flightapp.iservice.IInventoryService;
import com.flightapp.model.AirlineInventoryModel;
import com.flightapp.repository.AirlineRepository;
import com.flightapp.repository.InventoryRepository;

@Service
public class InventoryService implements IInventoryService {

	@Autowired
	InventoryRepository inventoryRepository;

	@Autowired
	AirlineRepository airlineRepository;

	@Override
	public Integer addInventory(AirlineInventoryModel airlineInventoryModel) throws Exception {
		try {
			Optional<AirlineMaster> airline = airlineRepository.findById(airlineInventoryModel.getAirlineId());
			if (airline.isEmpty()) {
				throw new Exception("Airline with the id doesnt exist");
			}
			if (!airlineInventoryModel.getScheduleDays().equalsIgnoreCase("weekdays")
					&& !airlineInventoryModel.getScheduleDays().equalsIgnoreCase("weekends")
					&& !airlineInventoryModel.getScheduleDays().equalsIgnoreCase("daily")) {
				throw new Exception("Flights can only be scheduled for Weekdays, Weekends or Daily"); 
			}
			AirlineInventory airlineInventory = new AirlineInventory(airline.get().getAirlineId(),
					airline.get().getAirlineName(), airlineInventoryModel.getFromPlace(),
					airlineInventoryModel.getToPlace(), airlineInventoryModel.getStartDateTime(),
					airlineInventoryModel.getEndDateTime(), airlineInventoryModel.getScheduleDays(),
					airlineInventoryModel.getInstrument(), airlineInventoryModel.getBusinessClassSeats(),
					airlineInventoryModel.getNonBusinessClassSeats(), airlineInventoryModel.getCost(),
					airlineInventoryModel.getRows(), airlineInventoryModel.getMeal());
			airlineInventory = inventoryRepository.save(airlineInventory);
			return airlineInventory.getInventoryId();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

}
