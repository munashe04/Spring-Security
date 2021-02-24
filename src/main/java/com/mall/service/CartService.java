package com.mall.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;


import com.mall.dto.CartRequestDto;
import com.mall.dto.CartResponseDto;
import com.mall.entities.Cart;

@Service
public interface CartService extends UserDetailsService {
	
	public CartResponseDto saveCart(CartRequestDto cartDto);
	public List<CartResponseDto> allCarts();
	public CartResponseDto deleteCartById(String id);
	public CartResponseDto getCartById(String id); 
	public CartResponseDto updateCartById(String id,CartRequestDto cartDto);
	//public CartResponseDto findByName(String name);

} 
