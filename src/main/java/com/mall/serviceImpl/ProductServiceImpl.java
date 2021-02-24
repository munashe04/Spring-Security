package com.mall.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mall.converters.ProductConverter;
import com.mall.dto.ProductRequestDto;
import com.mall.dto.ProductResponseDto;
import com.mall.entities.Cart;
import com.mall.entities.Product;
import com.mall.exceptions.ShoppingMallRequestException;
import com.mall.repositories.CartRepository;
import com.mall.repositories.ProductRepository;
import com.mall.service.ProductService;


@Service
public class ProductServiceImpl implements ProductService {

	Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

	@Autowired
	ProductConverter conv;

	@Autowired
	ProductRepository repo;

	@Autowired
	CartRepository cartRepo;


	@Override
	public ProductResponseDto saveProduct(String id, ProductRequestDto productRequestDto) {

		Optional<Cart> cart = cartRepo.findById(id);
		if (cart.isPresent()) {
			Product productToBeSaved = conv.dtoToProduct(productRequestDto);
			productToBeSaved.setCart(cart.get());

			logger.debug("The cart id to be saved for the product is " + id);
			Product productSaved = repo.save(productToBeSaved);
			ProductResponseDto dto = conv.productToDto(productSaved);

			return dto;

		} else {

		}
		return null;
	}

	@Override
	public List<ProductResponseDto> allProducts() {
		List<Product> products = repo.findAll();
		logger.debug("get all");
	//	System.out.print("List of products is " + conv.productToDto(products));
		return conv.productToDto(products);
	}

	@Override
	public ProductRequestDto deleteProductById(String id) {
		Optional<Product> product = repo.findById(id);
		if (product.isPresent()) {
			repo.deleteById(id);
		} else {
			throw new ShoppingMallRequestException("Product Does Not Exist");
		}

		return null;
	}

	@Override
	public ProductResponseDto getProductById(String id) {
		Optional<Product> product = repo.findById(id);
		if (product.isPresent()) {
			conv.productToDto(product.get());
		}

		return conv.productToDto(product.get());
	}

	@Override
	public ProductRequestDto updateProductById(String id, ProductRequestDto productDto) {
		Optional<Product> product = repo.findById(id);
		if (product.isPresent()) {
			Product newProduct = new Product();
			conv.productToDto(newProduct);
			repo.save(newProduct);
		} else {
			return null;
		}
		return productDto;

	}
		@Override
	public List<ProductResponseDto> getProductByCartId(String id) {
		Optional<Cart> cart = cartRepo.findById(id);
			List<Product> product = repo.findByCartId(id);
		if (cart.isPresent()) {

			conv.productToDto(product);
		}

		return conv.productToDto(product);

	}
	public List<ProductResponseDto> getProductGreaterThan(double price){
		List<Product> products = repo.findByPriceGreaterThan(price);
		return conv.productToDto(products);
	}
	public List<ProductResponseDto> findByCartIdPriceGreaterThan(double price,String id){
		List<Product> product = repo.findByPriceIsGreaterThanAndCart_Id(price,id);

		return conv.productToDto(product);
	}
}
