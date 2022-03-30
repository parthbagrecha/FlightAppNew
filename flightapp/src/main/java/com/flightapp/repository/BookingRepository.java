package com.flightapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.flightapp.entity.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {

	@Query(value = "SELECT * FROM flightapp.booking where email = ?1", nativeQuery = true)
	List<Booking> findAllBasedOnEmail(String email);

}
