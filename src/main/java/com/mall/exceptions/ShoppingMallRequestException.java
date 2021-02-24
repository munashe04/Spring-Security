package com.mall.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ShoppingMallRequestException extends RuntimeException {;


	public ShoppingMallRequestException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public ShoppingMallRequestException(String message) {
		super(message);
		
	}
	
	

}
