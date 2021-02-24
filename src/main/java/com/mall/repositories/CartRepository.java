package com.mall.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mall.entities.Cart;

import java.util.Optional;


@Repository
public interface CartRepository extends JpaRepository<Cart,String> {

    Optional<Cart> findByName(String name);

}
