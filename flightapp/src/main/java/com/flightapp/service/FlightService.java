package com.flightapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flightapp.entity.AirlineInventory;
import com.flightapp.iservice.IFlightService;
import com.flightapp.model.FlightModel;
import com.flightapp.repository.InventoryRepository;

@Service
public class FlightService implements IFlightService {

	@Autowired
	InventoryRepository inventoryRepository;

	@Override
	public Iterable<AirlineInventory> viewAllFlight() {
		return inventoryRepository.findAll();
	}

	@Override
	public List<AirlineInventory> viewFlight(FlightModel flightModel) throws Exception {
		if (flightModel.getFromPlace() == null
				&& (flightModel.getDateTime() == null || flightModel.getToPlace() == null)) {
			throw new Exception("Please Enter From-Place and either To-Place or Date-Time");
		}
		if (!flightModel.getToPlace().trim().isEmpty()) {
			return inventoryRepository.getInventoryByLocation(flightModel.getFromPlace(), flightModel.getToPlace());
		} else {
			String localdateTime1 = flightModel.getDateTime().minusHours(6L).toString();
			String localdateTime2 = flightModel.getDateTime().plusHours(6L).toString();
			return inventoryRepository.getInventoryByDateTime(flightModel.getFromPlace(), localdateTime1,
					localdateTime2);
		}
	}

}
