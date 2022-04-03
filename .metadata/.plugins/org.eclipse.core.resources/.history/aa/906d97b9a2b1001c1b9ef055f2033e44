package com.flightapp.iservice;

import org.springframework.http.ResponseEntity;

import com.flightapp.model.Admin;
import com.flightapp.model.AuthenticateResponse;

public interface IAdminService {

	public ResponseEntity<AuthenticateResponse> adminLogin(Admin adminLoginDetails);

	public ResponseEntity<AuthenticateResponse> adminValidate(String authToken);
}
