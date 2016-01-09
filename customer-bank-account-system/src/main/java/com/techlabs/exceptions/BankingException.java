package com.techlabs.exceptions;

@SuppressWarnings("serial")
public class BankingException extends RuntimeException {
	private String message;

	public BankingException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return this.message;
	}

}
