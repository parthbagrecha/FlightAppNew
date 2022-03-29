package com.flightapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flightapp.entity.AirlineMaster;
import com.flightapp.iservice.IAirlineService;
import com.flightapp.repository.AirlineRepository;

@Service
public class AirlineService implements IAirlineService {

	@Autowired
	AirlineRepository airlineRepository;

	@Override
	public Integer registerAirline(AirlineMaster airlineMaster) {
		airlineMaster = airlineRepository.save(airlineMaster);
		return airlineMaster.getAirlineId();
	}

	@Override
	public String toggleBlock(String status, Integer airlineId) throws Exception {
		if (airlineRepository.existsById(airlineId)) {
			if (status.equalsIgnoreCase("block")) {
				airlineRepository.updateAirlineMaster(airlineId, "Y");
				return "Airline with the id " + airlineId + " has been blocked.";
			}
			else if (status.equalsIgnoreCase("unblock")) {
				airlineRepository.updateAirlineMaster(airlineId, "N");
				return "Airline with the id " + airlineId + " has been unblocked.";
			}
			else {
				throw new Exception("Please check the request and try again");
			}
		}
		else {
			return "Airline with the id "+airlineId+" doesn't exist.";
		}
	}

}
