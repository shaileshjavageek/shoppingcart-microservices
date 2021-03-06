package com.assignment.shoppingcart.microservices.orderservice.controller;

import org.apache.catalina.loader.ResourceEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.shoppingcart.microservices.orderservice.exception.EmptyCartException;
import com.assignment.shoppingcart.microservices.orderservice.proxy.CartServiceProxy;

@RestController
@RequestMapping("order")
public class OrderServiceController {

	@Autowired
	private CartServiceProxy cartServiceProxy;
	
	@GetMapping("/{id}")
	public ResponseEntity<Void> checkoutCustomerOrder(@PathVariable("id") Long id) {
		
		boolean orderStatus = cartServiceProxy.checkoutCart(id);
		if(orderStatus == false) {
			throw new EmptyCartException("id -> "+id);
		}		
		return new ResponseEntity<Void>( HttpStatus.OK );
	}
	
	
}
