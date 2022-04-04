package com.flightapp.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.flightapp.entity.AirlineMaster;
import com.flightapp.repository.AirlineRepository;

@ExtendWith(MockitoExtension.class)
class AirlineServiceTest {

	@Mock
	AirlineRepository airlineRepository;

	@InjectMocks
	AirlineService airlineService;

	@Test
	void testRegisterAirline() {
		AirlineMaster airlineMaster = new AirlineMaster(1100, "Air India", "N");
		when(airlineRepository.save(airlineMaster)).thenReturn(airlineMaster);
		Integer result = airlineService.registerAirline(airlineMaster);
		assertNotNull(airlineMaster);
		assertEquals(1100, result);
	}

	@Test
	void testToggleBlock() throws Exception {
		when(airlineRepository.existsById(1100)).thenReturn(true);
		String response = airlineService.toggleBlock("block", 1100);
		assertNotNull(response);
		assertEquals("Airline with the id 1100 has been blocked.", response);
	}

	@Test
	void testToggleUnblock() throws Exception {
		when(airlineRepository.existsById(1100)).thenReturn(true);
		String response = airlineService.toggleBlock("unblock", 1100);
		assertThat(response).isNotNull();
		assertEquals("Airline with the id 1100 has been unblocked.", response);
	}

}
