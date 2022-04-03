package com.flightapp.exception;

public class InvalidTokenException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public InvalidTokenException() {
		super("Token Expired or Invalid , Login again");
	}
}