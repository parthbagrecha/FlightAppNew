package com.flightapp.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
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
import com.flightapp.iservice.IFlightService;
import com.flightapp.model.FlightModel;

@ExtendWith(MockitoExtension.class)
class FlightControllerTest {

	@InjectMocks
	FlightController flightController;

	@Mock
	IFlightService flightService;

	@Test
	void testViewAllFlight() {
		LocalDateTime ldt = LocalDateTime.now();
		AirlineInventory ai = new AirlineInventory(1100, "Air India", "Mumbai", "Delhi", ldt, ldt, "Weekdays", "AC130",
				20, 130, 9900, 30, "X");
		List<AirlineInventory> list = new ArrayList<AirlineInventory>();
		list.add(ai);
		when(flightService.viewAllFlight()).thenReturn(list);
		Iterable<AirlineInventory> result = flightController.viewAllFlight();
		assertNotNull(result);
	}

	@Test
	void testViewFlight() throws Exception {
		LocalDateTime ldt = LocalDateTime.now();
		AirlineInventory ai = new AirlineInventory(1100, "Air India", "Mumbai", "Delhi", ldt, ldt, "Weekdays", "AC130",
				20, 130, 9900, 30, "X");
		List<AirlineInventory> list = new ArrayList<AirlineInventory>();
		list.add(ai);
		FlightModel fm = new FlightModel(ldt, "Mumbai", "Delhi");
		when(flightService.viewFlight(fm)).thenReturn(list);
		List<AirlineInventory> result = flightController.viewFlight(fm);
		assertNotNull(result);
		assertEquals(fm.getFromPlace(), result.get(0).getFromPlace());
		assertEquals(fm.getToPlace(), result.get(0).getToPlace());
	}

}
