package com.assignment.shoppingcart.microservices.cartservice.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.shoppingcart.microservices.cartservice.model.Cart;
import com.assignment.shoppingcart.microservices.cartservice.model.dtos.CartDTO;
import com.assignment.shoppingcart.microservices.cartservice.model.dtos.CustomerDTO;
import com.assignment.shoppingcart.microservices.cartservice.model.dtos.ProductDTO;
import com.assignment.shoppingcart.microservices.cartservice.proxy.CustomerServiceProxy;
import com.assignment.shoppingcart.microservices.cartservice.proxy.InventoryServiceProxy;
import com.assignment.shoppingcart.microservices.cartservice.proxy.ProductServiceProxy;
import com.assignment.shoppingcart.microservices.cartservice.repository.CartService;

@RestController
@RequestMapping("/cart")
public class CartServiceController {
	
	@Autowired
	private CartService cartService;
	
	@Autowired
	private ProductServiceProxy productServiceProxy; 
	
	@Autowired
	private CustomerServiceProxy customerServiceProxy;
	
	@Autowired
	private InventoryServiceProxy inventoryServiceProxy;

	@GetMapping("/{id}")
	public List<CartDTO> getCustomerCartDetails (@PathVariable("id") Long id) throws Exception{
		List<Cart> items = cartService.getCustomerCartDetails(id);
		if(items.isEmpty()) {
			throw new Exception("Empty cart.");
		}
		
		List<CartDTO> cartList = new ArrayList<>();
		for(Cart cart : items) {
			CartDTO cartDTO = new CartDTO();
			CustomerDTO customer = customerServiceProxy.getCustomerDetails(id);
			cartDTO.setCustomer(customer);
			ProductDTO productDTO = new ProductDTO();
			productDTO  = productServiceProxy.getProductById(cart.getProductId());
			cartDTO.setProducts(productDTO);
			cartDTO.setQuantity(cart.getQuantity());
			cartDTO.setCheckedOut(cart.isCheckedout());
			cartList.add(cartDTO);
		}
		return cartList;
	}
	
	@GetMapping("/id")
	public boolean checkoutCart(@PathVariable("id") Long id) {
		List<Cart> items = cartService.getCustomerCartDetails(id);
		for(Cart item : items) {
			inventoryServiceProxy.updateInvntory(item.getProductId(), item.getQuantity());
			cartService.updateCart(item.getId());
		}
		return true;
	}
	
		
	
}
