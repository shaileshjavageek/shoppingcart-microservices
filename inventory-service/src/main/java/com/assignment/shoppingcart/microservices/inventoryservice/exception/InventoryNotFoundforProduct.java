package com.assignment.shoppingcart.microservices.inventoryservice.exception;

public class InventoryNotFoundforProduct extends RuntimeException{

	private static final long serialVersionUID = 6377034454128215086L;
	
	public InventoryNotFoundforProduct(String message) {
		super(message);
	}
	

}
