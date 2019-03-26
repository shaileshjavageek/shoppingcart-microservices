package com.assignment.shoppingcart.microservices.productservice.repository;

import java.util.List;

import com.assignment.shoppingcart.microservices.productservice.model.Product;
import com.assignment.shoppingcart.microservices.productservice.model.dtos.ProductDTO;

public interface ProductService {

	Product findProductById(Long id);

	List<ProductDTO> findAllProduct();
	
	

}
