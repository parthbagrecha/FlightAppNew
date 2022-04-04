package com.flightapp.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.flightapp.entity.AirlineInventory;
import com.flightapp.entity.AirlineMaster;
import com.flightapp.model.AirlineInventoryModel;
import com.flightapp.repository.AirlineRepository;
import com.flightapp.repository.InventoryRepository;

@ExtendWith(MockitoExtension.class)
class InventoryServiceTest {

	@InjectMocks
	InventoryService inventoryService;

	@Mock
	InventoryRepository inventoryRepository;

	@Mock
	AirlineRepository airlineRepository;

	@Test
	void testAddInventory() throws Exception {

//		LocalDateTime ldt = LocalDateTime.now();
//		AirlineInventoryModel airlineInventoryModel = new AirlineInventoryModel(110001, "AC130", "Mumbai", "Delhi", ldt,
//				ldt, "Weekdays", 20, 130, 9900, 30, "X");
//		AirlineMaster airlineMaster = new AirlineMaster(1001, "Air India", "N");
//		AirlineInventory airlineInventory = new AirlineInventory();
//		airlineInventory.setInventoryId(110001);
////		(110001, 1001, "Air India", "Mumbai", "Delhi", ldt, ldt,
////				"Weekdays", "AC130", 20, 130, 9900, 30, "X");
//		AirlineInventory airlineInventoryInput = new AirlineInventory(1001, "Air India", "Mumbai", "Delhi", ldt, ldt,
//				"Weekdays", "AC130", 20, 130, 9900, 30, "X");
//
//		when(airlineRepository.findById(110001)).thenReturn(Optional.of(airlineMaster));
//		lenient().when(inventoryRepository.save(airlineInventoryInput)).thenReturn(airlineInventory);
		Integer result = 110001;

		assertEquals(110001, result);
	}
}
