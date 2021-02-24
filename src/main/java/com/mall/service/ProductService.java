package com.mall.service;

import java.util.List;
import java.util.Optional;

import com.mall.entities.Product;
import org.springframework.stereotype.Service;

import com.mall.dto.ProductRequestDto;
import com.mall.dto.ProductResponseDto;

@Service
public interface ProductService {

	public ProductResponseDto saveProduct(String id,ProductRequestDto productDto);
	public List<ProductResponseDto> allProducts();
	public ProductRequestDto deleteProductById(String id);
	public ProductResponseDto getProductById(String id); 
	public ProductRequestDto updateProductById(String id,ProductRequestDto productDto);
	public List<ProductResponseDto> getProductByCartId(String id) ;
	public List<ProductResponseDto> getProductGreaterThan(double price);
	public List<ProductResponseDto> findByCartIdPriceGreaterThan(double price,String id);





}
