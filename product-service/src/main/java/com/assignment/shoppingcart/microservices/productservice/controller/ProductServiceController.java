package com.assignment.shoppingcart.microservices.productservice.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.shoppingcart.microservices.productservice.exception.ProductNotFoundException;
import com.assignment.shoppingcart.microservices.productservice.model.Product;
import com.assignment.shoppingcart.microservices.productservice.model.dtos.ProductDTO;
import com.assignment.shoppingcart.microservices.productservice.repository.ProductService;
import com.assignment.shoppingcart.microservices.productservice.repository.ProductServiceRepository;

@RestController
@RequestMapping("product")
public class ProductServiceController {
	
	private Logger LOG = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ProductService productService;
	
	@GetMapping("/{id}")
	public Product getProductById(@PathVariable("id") Long id) {
		Product product = productService.findProductById(id);
		
		if(product == null) {
			throw new ProductNotFoundException("id -> "+id);
		}
		LOG.info("{}" , product);
		return product;
	}
	
	
	@GetMapping
	public List<ProductDTO> getProducts() {
		List<ProductDTO> products = productService.findAllProduct();
		
		if(products.isEmpty()) {
			throw new ProductNotFoundException("Products not available.");
		}
		LOG.info("{}" , products.toArray());
		return products;
	}
	
	
}
