package com.flightapp.admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flightapp.admin.entity.AirlineMaster;
import com.flightapp.admin.iservice.IAirlineService;
import com.flightapp.admin.repository.AirlineRepository;

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
	public String toggleBlock() {
		// TODO Auto-generated method stub
		return null;
	}

}
