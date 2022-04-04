package com.flightapp.model;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
 class AirlineInventoryModelTest {

//	new AirlineInventoryModel(110001, "Air India", "Mumbai", "Delhi",
//	ldt, ldt, "Weekdays", 20, 130, 9900, 30, "X")

	@Test
	void testAirlineInventoryModel1() {
		LocalDateTime ldt = LocalDateTime.now();
		AirlineInventoryModel aim = new AirlineInventoryModel();
		aim.setAirlineId(110001);
		aim.setInstrument("AC130");
		aim.setFromPlace("Mumbai");
		aim.setToPlace("Delhi");
		aim.setStartDateTime(ldt);
		aim.setEndDateTime(ldt);
		aim.setScheduleDays("Weekends");
		aim.setBusinessClassSeats(20);
		aim.setNonBusinessClassSeats(130);
		aim.setCost(9900);
		aim.setRows(30);
		aim.setMeal("X");

		assertNotNull(aim);

	}

}
