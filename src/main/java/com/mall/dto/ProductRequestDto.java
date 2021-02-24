package com.mall.dto;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.mall.entities.Cart;



@Component
public class ProductRequestDto {
	
public ProductRequestDto() {
	}

	private Cart cart;
	private String name;
	private double price;
	private Date dateOfPurchase;
	
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
	public Date getDateOfPurchase() {
		return dateOfPurchase;
	}
	public void setDateOfPurchase(Date dateOfPurchase) {
		this.dateOfPurchase = dateOfPurchase;
	}

}
