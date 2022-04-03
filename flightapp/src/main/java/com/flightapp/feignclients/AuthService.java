package com.flightapp.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import com.flightapp.model.AuthenticateResponse;
import com.flightapp.model.UserModel;

@FeignClient(name = "${authservice.client.name}", url = "${authservice.client.url}")
public interface AuthService {

	@GetMapping(value = "/api/v1.0/user/validate")
	public ResponseEntity<AuthenticateResponse> getValidity(@RequestHeader("Authorization") final String token);

	@GetMapping(value = "/api/v1.0/user/adminvalidate")
	public ResponseEntity<AuthenticateResponse> getAdminValidity(@RequestHeader("Authorization") final String token);
	
	@GetMapping(value = "/api/v1.0/user/getUser")
	public UserModel getUser(@RequestHeader("Authorization") final String token);

}
