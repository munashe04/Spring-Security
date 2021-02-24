package com.mall.controller;

import java.util.List;

import com.mall.util.JwtUtil;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import com.mall.dto.CartRequestDto;
import com.mall.dto.CartResponseDto;
import com.mall.entities.Cart;
import com.mall.service.CartService;


@RestController
@NoArgsConstructor
@RequestMapping("ShoppingMall/Cart")
public class CartController {
@Autowired
	AuthenticationManager authenticationManager;
	@Autowired
	private CartRequestDto cartRequestDto;
	@Autowired
	private JwtUtil jwtTokenUtil;

	 @Autowired
	 CartService serv;
	 @PostMapping
	 public ResponseEntity<?> createToken(@RequestBody CartRequestDto cartRequestDto) throws Exception{
		 serv.saveCart(cartRequestDto);
		 try {
			 authenticationManager.authenticate(
					 new UsernamePasswordAuthenticationToken(cartRequestDto.getName(),cartRequestDto.getPassword()));
		 }catch (BadCredentialsException e){
		 	throw new Exception("Incorrect credentials");
		 }
		  CartRequestDto cartResponseDto = (CartRequestDto) serv.loadUserByUsername(cartRequestDto.getName());
		 final String jwt = jwtTokenUtil.generateToken(cartRequestDto);
		 return ResponseEntity.ok(new CartResponseDto(jwt));

	 }

	/* @PostMapping
	 public CartResponseDto saveCart( @RequestBody CartRequestDto cartDto) {
		return serv.saveCart(cartDto);
	 }*/
	 
	@GetMapping
	 public List<CartResponseDto> getAll() {
		return serv.allCarts();
	 }
	 
	 @GetMapping(path ="{id}")
	 public CartResponseDto getById(@PathVariable ("id") String id){
		 return serv.getCartById(id);
	 }
	 @PutMapping(path ="{id}")
	 public CartResponseDto updateById(@PathVariable ("id") String id,@RequestBody CartRequestDto cartDto) {
		 System.out.println("Controller");
		return serv.updateCartById(id,cartDto);
	 }
	 @DeleteMapping(path ="{id}")
			 public CartResponseDto deleteById(@PathVariable ("id") String id){
				return serv.deleteCartById(id);
			 }
	

}