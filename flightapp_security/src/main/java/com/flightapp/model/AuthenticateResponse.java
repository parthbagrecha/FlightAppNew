package com.flightapp.model;

public class AuthenticateResponse {

	private String username;
	private boolean valid;
	private String token;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public AuthenticateResponse(String username, boolean valid, String token) {
		super();
		this.username = username;
		this.valid = valid;
		this.token = token;
	}

	public AuthenticateResponse() {
		super();
	}

}
