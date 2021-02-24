package com.mall.converters;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.mall.dto.CartRequestDto;
import com.mall.dto.CartResponseDto;
import com.mall.entities.Cart;

@Component
public class CartConverter {

	public CartResponseDto cartToDto(Cart cart) {
		CartResponseDto cartResponseDto = new CartResponseDto();
		cartResponseDto.setName(cart.getName());
		cartResponseDto.setId(cart.getId());
		
		return cartResponseDto;
		
	}
	public CartResponseDto cartToDto1(Cart cart) {
		CartResponseDto cartDto = new CartResponseDto(cart.getId(),cart.getName());
		cartDto.setId(cart.getId());
		cartDto.setName(cart.getName());
		return cartDto;
	}
	public List<CartResponseDto>cartToDto(List<Cart>cart){
		return cart.stream().map(x -> cartToDto(x)).collect(Collectors.toList());
	}
	public Cart dtoToEntity(CartRequestDto cartDto) {
		Cart cart= new Cart();
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date today = new Date();
	
		//cart.setId(1);
		cart.setName(cartDto.getName());
		cart.setNumberOfWheels(cartDto.getNumberOfWheels());
		cart.setColour(cartDto.getColour());
		cart.setDateIssued(dateFormat.format(today));
		
		return cart;
	}
	public Cart dtoToEntity1(CartRequestDto dto) {
		Cart cart = new Cart(dto.getId(),dto.getId());
		cart.setName(dto.getName());
		cart.setId(dto.getId());
		return cart;
	}
	public List<Cart>dtoToEntity(List<CartRequestDto>cartDto){
		return cartDto.stream().map(x -> dtoToEntity(x)).collect(Collectors.toList());
	}
}
	