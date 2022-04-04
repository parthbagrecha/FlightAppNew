package com.flightapp.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.flightapp.entity.AirlineMaster;
import com.flightapp.feignclients.AuthService;
import com.flightapp.model.AuthenticateResponse;
import com.flightapp.service.AirlineService;

@ExtendWith(MockitoExtension.class)
class AirlineControllerTest {

	@InjectMocks
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
		ResponseEntity<AuthenticateResponse> authResponse = new ResponseEntity<AuthenticateResponse>(tokenValid,
				HttpStatus.OK);
		when(authService.getAdminValidity("token")).thenReturn(authResponse);
		when(airlineService.registerAirline(airlineMaster)).thenReturn(1100);
		String response = airlineController.registerAirline("token", airlineMaster);
		assertThat(response).isNotNull();
		assertEquals("Airline with id 1100 added", response);
	}

	@Test
	void testBlock() throws Exception {
		AirlineMaster airlineMaster = new AirlineMaster();
		airlineMaster.setAirlineId(1100);
		AuthenticateResponse tokenValid = new AuthenticateResponse("Admin", true, "token successfully validated");
		ResponseEntity<AuthenticateResponse> authResponse = new ResponseEntity<AuthenticateResponse>(tokenValid,
				HttpStatus.OK);
		when(authService.getAdminValidity("token")).thenReturn(authResponse);
		when(airlineService.toggleBlock("block", 1100)).thenReturn("Airline with the id 1100 has been blocked.");
		String response = airlineController.toggleBlock("token", "block", airlineMaster.getAirlineId());
		assertThat(response).isNotNull();
		assertEquals("Airline with the id 1100 has been blocked.", response);

	}

	@Test
	void testUnblock() throws Exception {
		AirlineMaster airlineMaster = new AirlineMaster();
		airlineMaster.setAirlineId(1100);
		AuthenticateResponse tokenValid = new AuthenticateResponse("Admin", true, "token successfully validated");
		ResponseEntity<AuthenticateResponse> authResponse = new ResponseEntity<AuthenticateResponse>(tokenValid,
				HttpStatus.OK);
		when(authService.getAdminValidity("token")).thenReturn(authResponse);
		when(airlineService.toggleBlock("unblock", 1100)).thenReturn("Airline with the id 1100 has been unblocked.");
		String response = airlineController.toggleBlock("token", "unblock", airlineMaster.getAirlineId());
		assertThat(response).isNotNull();
		assertEquals("Airline with the id 1100 has been unblocked.", response);
	}

}
