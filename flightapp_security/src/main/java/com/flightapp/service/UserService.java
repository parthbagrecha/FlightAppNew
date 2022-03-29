package com.flightapp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.flightapp.entity.User;
import com.flightapp.exceptions.RecordAlreadyPresentException;
import com.flightapp.exceptions.RecordNotFoundException;
import com.flightapp.iservice.IUserService;
import com.flightapp.respository.UserRepository;

@Service
public class UserService implements IUserService {

	@Autowired
	UserRepository userRepository;

	@Override
	public ResponseEntity<?> createUser(User newUser) {
//		Optional<User> findUserById = userRepository.findById(newUser.getUserId());
//		try {
//			if (!findUserById.isPresent()) {
			userRepository.save(newUser);
			return new ResponseEntity<User>(newUser, HttpStatus.OK);
//			} else
//				throw new RecordAlreadyPresentException("User with Id: " + newUser.getUserId() + " already exists!!");
//		} catch (Exception e) {
//			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//		}
	}

	@Override
	public ResponseEntity<?> findUserById(Integer userId) {
		Optional<User> findById = userRepository.findById(userId);
		try {
			if (findById.isPresent()) {
				User findUser = findById.get();
				return new ResponseEntity<User>(findUser, HttpStatus.OK);
			} else
				throw new RecordNotFoundException("No record found with ID " + userId);
		} catch (RecordNotFoundException e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}

}
