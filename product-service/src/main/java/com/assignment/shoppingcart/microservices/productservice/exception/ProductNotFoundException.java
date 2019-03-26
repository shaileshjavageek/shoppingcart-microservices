package com.assignment.shoppingcart.microservices.productservice.exception;

public class ProductNotFoundException extends RuntimeException{
	
	private static final long serialVersionUID = 7139788924786888330L;
	
	public ProductNotFoundException(String message) {
		super (message);
	}
	

}
