package com.mall.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class NotFoundException extends ResponseStatusException {

	public NotFoundException(HttpStatus status, String message) {
		super(status, message);
		
	}

}
