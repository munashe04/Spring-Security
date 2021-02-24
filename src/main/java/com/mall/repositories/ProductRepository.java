package com.mall.repositories;

import com.mall.dto.ProductResponseDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mall.entities.Product;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product,String>{
    List<Product> findByCartId(String cart_number);
    List<Product>findByPriceGreaterThan(double price);

    //List<Product> findByCartIdPriceGreaterThan(String cart_number,double price);
    //List<Product> findByPriceGreaterThanAndId(double price,String cart_number);
    List<Product>findByPriceIsGreaterThanAndCart_Id(double price,String id);


}
