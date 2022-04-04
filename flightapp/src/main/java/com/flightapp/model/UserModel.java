package com.flightapp.model;

import java.math.BigInteger;

public class UserModel {

	private String userEmail;

	private String userName;

	private String userPassword;

	private BigInteger userPhone;

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public BigInteger getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(BigInteger userPhone) {
		this.userPhone = userPhone;
	}

	public UserModel(String userEmail, String userName, String userPassword, BigInteger userPhone) {
		super();
		this.userEmail = userEmail;
		this.userName = userName;
		this.userPassword = userPassword;
		this.userPhone = userPhone;
	}

	public UserModel() {
		super();
	}

}
