package com.flightapp.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.flightapp.entity.AirlineMaster;
import com.flightapp.feignclients.AuthService;
import com.flightapp.model.AuthenticateResponse;
import com.flightapp.service.AirlineService;

@ExtendWith(MockitoExtension.class)
class AirlineControllerTest {
	
	@Autowired
	AirlineController airlineController;
	
	@Mock
	AirlineService airlineService;
	
	@Mock
	AuthService authService;
	
	@Test
	void testRegisterAirline() {
		AirlineMaster airlineMaster = new AirlineMaster();
		airlineMaster.setAirlineId(1100);
		airlineMaster.setAirlineName("Air India");
		airlineMaster.setIsBlocked("N");
		AuthenticateResponse tokenValid = new AuthenticateResponse("Admin", true, "token successfully validated");
		ResponseEntity<AuthenticateResponse> authResponse = new ResponseEntity<AuthenticateResponse>(tokenValid, HttpStatus.OK);
		String response = airlineController.registerAirline("token", airlineMaster);
		when(authService.getAdminValidity("token")).thenReturn(authResponse);
		when(airlineService.registerAirline(airlineMaster)).thenReturn(airlineMaster.getAirlineId());
		
		assertEquals("Airline with id " + airlineMaster.getAirlineId() + " added", response);
	}
	
	@Test
	void testBlock() throws Exception {
//		AuthenticateResponse tokenValid = new AuthenticateResponse("Admin", true, "token successfully validated");
//		ResponseEntity<AuthenticateResponse> authResponse = new ResponseEntity<AuthenticateResponse>(tokenValid, HttpStatus.OK);
		String response = airlineController.toggleBlock("token", "block", 1100);
//		when(authService.getAdminValidity("token")).thenReturn(authResponse);
		when(airlineService.toggleBlock("block", 1100)).thenReturn("Airline with the id " +1100+ " has been blocked.");
		
		assertEquals("Airline with the id " + 1100 + " has been blocked.", response);
		
	}
	
	@Test
	void testUnblock() {
		AuthenticateResponse tokenValid = new AuthenticateResponse("Admin", true, "token successfully validated");
		ResponseEntity<AuthenticateResponse> authResponse = new ResponseEntity<AuthenticateResponse>(tokenValid, HttpStatus.OK);
		
	}


}