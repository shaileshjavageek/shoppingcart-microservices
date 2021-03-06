package com.assignment.shoppingcart.microservices.inventoryservice.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.shoppingcart.microservices.inventoryservice.exception.InventoryNotFoundforProduct;
import com.assignment.shoppingcart.microservices.inventoryservice.model.Inventory;
import com.assignment.shoppingcart.microservices.inventoryservice.model.dtos.InventoryDTO;
import com.assignment.shoppingcart.microservices.inventoryservice.model.dtos.ProductDTO;
import com.assignment.shoppingcart.microservices.inventoryservice.proxy.ProductServiceProxy;
import com.assignment.shoppingcart.microservices.inventoryservice.repository.InventoryService;

@RestController
@RequestMapping("inventory")
public class InventoryServiceController {

	private Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ProductServiceProxy productServiceProxy;
	
	@Autowired(required = true)
	private InventoryService inventoryService;

	@GetMapping("/{productId}")
	public InventoryDTO getInventoryById(@PathVariable("productId") Long productId) {
		Inventory inventoryObj = inventoryService.findProductById(productId);
		LOGGER.info("{}", inventoryObj);
		if (inventoryObj == null) {
			throw new InventoryNotFoundforProduct("Product id -> "+productId);
		}
		InventoryDTO dto = new InventoryDTO();
		dto.setId(inventoryObj.getId());
		dto.setPrice(inventoryObj.getPrice());
		dto.setQuantity(inventoryObj.getQuantity());
		ProductDTO productDTO = productServiceProxy.getProductById(inventoryObj.getId());
		dto.setProductId(productDTO);
		return dto;
	}
	
	
	@GetMapping
	public List<InventoryDTO> getInventories() {
		List<Inventory> inventories = inventoryService.getAllProducts();
		LOGGER.info("{}", inventories);
		
		if (inventories.isEmpty()) {
			throw new InventoryNotFoundforProduct("Inventory not found");
		}
		List<InventoryDTO> inventoryList = new ArrayList<>();
		for (Inventory inv : inventories) {
			InventoryDTO dto = new InventoryDTO();
			dto.setId(inv.getId());
			dto.setQuantity(inv.getQuantity());
			dto.setPrice(inv.getPrice());
			ProductDTO productDTO = productServiceProxy.getProductById(inv.getId());
			dto.setProductId(productDTO);
			inventoryList.add(dto);
		}
		return inventoryList;
	}
	
	@GetMapping("/{id}/{quantity}")
	public boolean updateInvntory(@PathVariable("id") Long id, @PathVariable("quantity") Integer quantity) {
		boolean status = inventoryService.updateInventory(id, quantity);
		return status;
	}
	
	
	
}
