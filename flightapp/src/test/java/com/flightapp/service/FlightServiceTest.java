package com.flightapp.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.flightapp.entity.AirlineInventory;
import com.flightapp.model.FlightModel;
import com.flightapp.repository.InventoryRepository;

@ExtendWith(MockitoExtension.class)
class FlightServiceTest {

	@InjectMocks
	FlightService flightService;

	@Mock
	InventoryRepository inventoryRepository;

	@Test
	void viewAllFlight() {
		when(inventoryRepository.findAll()).thenReturn(null);

		Iterable<AirlineInventory> result = flightService.viewAllFlight();

		assertNull(result);
	}

	@Test
	void testViewFlight() throws Exception {
		LocalDateTime ldt = LocalDateTime.now();
		FlightModel flightModel1 = new FlightModel(null, "Mumbai", "Delhi");
		FlightModel flightModel2 = new FlightModel(ldt, "Mumbai", "");

		AirlineInventory flight = new AirlineInventory(1100, "Air India", "Mumbai", "Delhi", ldt, ldt, "Weekdays",
				"AC130", 20, 130, 9900, 30, "X");
		List<AirlineInventory> flights = new ArrayList<AirlineInventory>();
		flights.add(flight);

		when(inventoryRepository.getInventoryByLocation("Mumbai", "Delhi")).thenReturn(flights);
		when(inventoryRepository.getInventoryByDateTime("Mumbai", ldt.minusHours(6L).toString(),
				ldt.plusHours(6L).toString())).thenReturn(flights);

		List<AirlineInventory> result1 = flightService.viewFlight(flightModel1);
		List<AirlineInventory> result2 = flightService.viewFlight(flightModel2);

		assertNotNull(result1);
		assertNotNull(result2);
	}

}
