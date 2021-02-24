package com.mall.dto;

import java.util.Date;

import com.mall.entities.Cart;


public class ProductResponseDto {
	
public ProductResponseDto() {
	}

	private String id;
	private String name;
	private double price;

	public String getId() {
		return id;
	}
	public void setId(String string) {
		this.id = string;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

	
	
}
