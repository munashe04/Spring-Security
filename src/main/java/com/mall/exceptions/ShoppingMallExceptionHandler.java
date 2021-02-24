package com.mall.exceptions;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ShoppingMallExceptionHandler {
	@ExceptionHandler(value = {ShoppingMallRequestException.class})
	
	
	public ResponseEntity<Object> handler(ShoppingMallRequestException exception){
		int httpStatus = 400;
		
		ShoppingMallException shoppingMallException = new ShoppingMallException(exception.getMessage(),
				httpStatus,ZonedDateTime.now(ZoneId.of("Z")));
		
		return new ResponseEntity<>(shoppingMallException,HttpStatus.BAD_REQUEST);
	}

}
