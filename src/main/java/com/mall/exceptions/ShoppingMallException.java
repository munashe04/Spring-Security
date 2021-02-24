package com.mall.exceptions;

import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;

public class ShoppingMallException {
	private final String message;
	private  int httpStatus;
	private final ZonedDateTime timestamp;

	
	public ShoppingMallException(String message, int httpStatus, ZonedDateTime timestamp) {
		super();
		this.message = message;
		this.httpStatus = httpStatus;
		this.timestamp = timestamp;
	}

	public String getMessage() {
		return message;
	}

	public int getHttpStatus() {
		return httpStatus;
	}

	public ZonedDateTime getTimestamp() {
		return timestamp;
	}
	
}
