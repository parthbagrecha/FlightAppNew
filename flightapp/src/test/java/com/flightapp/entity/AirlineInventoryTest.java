package com.flightapp.entity;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class AirlineInventoryTest {

	@Test
	void testAirlineInventory1() {
		LocalDateTime ldt = LocalDateTime.now();
		AirlineInventory airlineInventory = new AirlineInventory(110001, 1001, "Air India", "Mumbai", "Delhi", ldt, ldt,
				"Weekends", "AC130", 20, 130, 9900, 30, "X");

		assertNotNull(airlineInventory);
	}

	@Test
	void testAirlineInventory2() {
		LocalDateTime ldt = LocalDateTime.now();
		AirlineInventory airlineInventory = new AirlineInventory(1001, "Air India", "Mumbai", "Delhi", ldt, ldt,
				"Weekends", "AC130", 20, 130, 9900, 30, "X");

		assertNotNull(airlineInventory);
	}

	@Test
	void testAirlineInventory3() {
		LocalDateTime ldt = LocalDateTime.now();
		AirlineInventory airlineInventory = new AirlineInventory();
		airlineInventory.setInventoryId(110001);
		airlineInventory.setAirlineId(1001);
		airlineInventory.setAirlineName("Air India");
		airlineInventory.setFromPlace("Mumbai");
		airlineInventory.setToPlace("Delhi");
		airlineInventory.setStartDateTime(ldt);
		airlineInventory.setEndDateTime(ldt);
		airlineInventory.setScheduleDays("Weekdays");
		airlineInventory.setInstrument("AC130");
		airlineInventory.setBusinessClassSeats(20);
		airlineInventory.setNonBusinessClassSeats(130);
		airlineInventory.setCost(9900);
		airlineInventory.setRows(30);
		airlineInventory.setMeal("V");

		assertNotNull(airlineInventory);
	}

}
