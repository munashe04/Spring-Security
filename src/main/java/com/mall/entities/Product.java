package com.mall.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity

@Table(name = "Product")
public class Product {
	@Id
	@GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "ID", columnDefinition = "VARCHAR(40)")
    private String id;
	private String name;
	private double price;
	private String dateOfPurchase;
	@ManyToOne
	@JoinColumn(name = "cartNumber")
	private Cart cart;
	
	@JsonBackReference
	public Cart getCart() {
		return cart;
	}
	
	/*public void setCart(Optional<Product> cart2) {
		this.cart = cart2;
	}*/
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public String getDateOfPurchase() {
		return dateOfPurchase;
	}
	public void setDateOfPurchase(String dateOfPurchase) {
		this.dateOfPurchase = dateOfPurchase;
	}
	public Product(String id, String name, double price, String dateOfPurchase,Cart cart) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.dateOfPurchase = dateOfPurchase;
		this.cart = cart;
	}
	public Product() {
		
	}
	
	
}
