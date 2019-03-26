package com.assignment.shoppingcart.microservices.customerservice.exception;


public class CustomerNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 3375736524678850456L;
	
	public CustomerNotFoundException(String message) {
		super(message);
	}

}
