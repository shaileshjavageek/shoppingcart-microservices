package com.assignment.shoppingcart.microservices.productservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assignment.shoppingcart.microservices.productservice.model.Product;

public interface ProductServiceRepository extends JpaRepository<Product, Long>{

}
