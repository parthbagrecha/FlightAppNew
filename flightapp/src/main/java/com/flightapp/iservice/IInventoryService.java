package com.flightapp.iservice;

import com.flightapp.model.AirlineInventoryModel;

public interface IInventoryService {
	
	public Integer addInventory(AirlineInventoryModel airlineInventoryModel) throws Exception;
	
}
