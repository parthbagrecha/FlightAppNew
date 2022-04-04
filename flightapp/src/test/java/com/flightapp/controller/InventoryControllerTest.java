package com.flightapp.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.flightapp.feignclients.AuthService;
import com.flightapp.model.AirlineInventoryModel;
import com.flightapp.model.AuthenticateResponse;
import com.flightapp.service.InventoryService;

@ExtendWith(MockitoExtension.class)
class InventoryControllerTest {

	@InjectMocks
	InventoryController inventoryController;

	@Mock
	AuthService authService;

	@Mock
	InventoryService inventoryService;

	@Test
	void testAddInventory() throws Exception {
		AuthenticateResponse tokenValid = new AuthenticateResponse("Test", true, "token successfully validated");
		ResponseEntity<AuthenticateResponse> authResponse = new ResponseEntity<AuthenticateResponse>(tokenValid,
				HttpStatus.OK);

		LocalDateTime ldt = LocalDateTime.now();
		AirlineInventoryModel airlineInventoryModel = new AirlineInventoryModel(110001, "Air India", "Mumbai", "Delhi",
				ldt, ldt, "Weekdays", 20, 130, 9900, 30, "X");

		when(authService.getAdminValidity("token")).thenReturn(authResponse);
		when(inventoryService.addInventory(airlineInventoryModel)).thenReturn(110001);
		String result = inventoryController.addInventory("token", airlineInventoryModel);

		assertEquals("Inventory added with id 110001.", result);
	}

}
