package com.mall.serviceImpl;

import java.util.List;
import java.util.Optional;

import com.mall.entities.Product;
import com.mall.repositories.ProductRepository;
import com.mall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mall.converters.CartConverter;

import com.mall.dto.CartRequestDto;
import com.mall.dto.CartResponseDto;
import com.mall.entities.Cart;
import com.mall.exceptions.ShoppingMallException;
import com.mall.exceptions.ShoppingMallRequestException;
import com.mall.repositories.CartRepository;
import com.mall.service.CartService;

@Service
public class CartServiceImpl implements CartService {
	
	@Autowired
	CartRepository repo;
	
	@Autowired
	CartConverter conv;

	@Autowired
	ProductRepository productRepo;

	private final static String USER_NOT_FOUND_MSG =
			"user  not found";

	@Override
	public CartResponseDto saveCart(CartRequestDto cartDto) {
    Cart cart = repo.save(conv.dtoToEntity(cartDto));
    
    CartResponseDto dto = conv.cartToDto(cart);
    
	return dto;
	
		//return ("Cart name :     " + (cart.getName()))  + System.lineSeparator() +(" Cart id :    "+  cart.getId());
		
	}

	@Override
	public List<CartResponseDto> allCarts() {
		List<Cart>carts = repo.findAll();
		
		return conv.cartToDto(carts) ;
	}

	@Override
	public CartResponseDto deleteCartById(String id) {
		Optional<Cart> cart = repo.findById(id);
		if(cart.isPresent()) {
			repo.deleteById(id);
		}
		else {
			throw new ShoppingMallRequestException("Cart Does Not Exist");
		}
		return null;
	}

	@Override
	public CartResponseDto getCartById(String id) {

		Optional<Cart> cart = repo.findById(id);
		if(cart.isPresent()) {
			conv.cartToDto(cart.get());
		}
		return conv.cartToDto(cart.get());
	}

	@Override
	public CartResponseDto updateCartById(String id, CartRequestDto cartDto) {
		Optional<Cart> cart = repo.findById(id);
		if(cart.isPresent()) {
			Cart newCart = new Cart();
			conv.cartToDto(newCart);
			repo.save(newCart);
		}
		else {
			return null;
		}
		return null;
	}

	@Override
	public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
		return (UserDetails) repo.findByName(name)  .orElseThrow(() ->
				new UsernameNotFoundException(
						String.format(USER_NOT_FOUND_MSG, name)));
	}
	/*public CartResponseDto findByName(String name){
		Optional<Cart> cart = repo.findByName(name);
		if(cart.isPresent()) {
			conv.cartToDto(cart.get());
		}
		return conv.cartToDto(cart.get());
	}*/

	}

