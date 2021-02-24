package com.mall.converters;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mall.dto.ProductRequestDto;
import com.mall.dto.ProductResponseDto;
import com.mall.entities.Cart;
import com.mall.entities.Product;
import com.mall.repositories.CartRepository;

@Component
public class ProductConverter {
	@Autowired
	CartRepository repo;
	
	
	Cart cart = new Cart();
	
	public ProductResponseDto productToDto(Product product) {
		ProductResponseDto productResponseDto = new ProductResponseDto();
		productResponseDto.setName(product.getName());
		productResponseDto.setId(product.getId());
		productResponseDto.setPrice(product.getPrice());
		
		return productResponseDto;
	}
	public List<ProductResponseDto>productToDto(List<Product>product){
		return product.stream().map(x -> productToDto(x)).collect(Collectors.toList());

	}
	public Product dtoToProduct(ProductRequestDto productDto) {
		Product product = new Product();
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date today = new Date();
		
		product.setName(productDto.getName());
		product.setPrice(productDto.getPrice());
		product.setDateOfPurchase(dateFormat.format(today));
		
		return product;
	}
	public List<Product>dtoToProduct(List<ProductRequestDto>productDto){
		return productDto.stream().map(x -> dtoToProduct( x)).collect(Collectors.toList());
	}
}
