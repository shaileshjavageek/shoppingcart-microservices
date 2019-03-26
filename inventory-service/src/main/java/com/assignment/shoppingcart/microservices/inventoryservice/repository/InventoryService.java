package com.assignment.shoppingcart.microservices.inventoryservice.repository;

import java.util.List;

import com.assignment.shoppingcart.microservices.inventoryservice.model.Inventory;

public interface InventoryService {
	
	public Inventory findProductById(Long productId);

	public List<Inventory> getAllProducts();

	public boolean updateInventory(Long id, Integer quantity);

}
