package com.flightapp.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.flightapp.entity.AirlineMaster;

@Repository
public interface AirlineRepository extends JpaRepository<AirlineMaster, Integer> {
	
	@Modifying
	@Transactional
	@Query(value = "UPDATE airline_master\r\n" + 
			"SET\r\n" + 
			"`is_blocked` = ?2\r\n" + 
			"WHERE \r\n" + 
			"airline_id = ?1", nativeQuery=true)
	public void updateAirlineMaster(Integer airlineId, String status); 

}
