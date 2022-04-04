package com.flightapp.model;

public class Admin {

	private String userName;
	private String password;
	private String userEmail;

	public String getUsername() {
		return userName;
	}

	public void setUsername(String username) {
		this.userName = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public Admin(String userName, String password, String userEmail) {
		super();
		this.userName = userName;
		this.password = password;
		this.userEmail = userEmail;
	}

	public Admin() {
		super();
	}

}
