package com.mall.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CartResponseDto {
	private String id;
	private String name;
	private String jwt;

	public CartResponseDto(String jwt) {
		this.jwt = jwt;
	}
	public CartResponseDto(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public CartResponseDto() {
		
	}
	
	

}
