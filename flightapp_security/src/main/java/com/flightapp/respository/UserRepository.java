package com.flightapp.respository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.flightapp.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

	@Query(value = "SELECT * FROM user_details where user_name = ?1", nativeQuery = true)
	Optional<User> findByName(String extractUsername);

}
