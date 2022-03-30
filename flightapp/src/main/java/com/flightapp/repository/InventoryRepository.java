package com.flightapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.flightapp.entity.AirlineInventory;

@Repository
public interface InventoryRepository extends JpaRepository<AirlineInventory, Integer> {

	@Query(value = "SELECT * FROM airline_inventory where from_place = ?1 and start_date_time between ?2 and ?3", nativeQuery = true)
	public List<AirlineInventory> getInventoryByDateTime(String fromPlace, String dateTime1, String dateTime2);

	@Query(value = "SELECT * FROM airline_inventory where from_place = ?1 and to_place = ?2", nativeQuery = true)
	public List<AirlineInventory> getInventoryByLocation(String fromPlace, String toPlace);

}
