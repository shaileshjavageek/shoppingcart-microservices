package com.assignment.shoppingcart.microservices.cartservice.repository;

import java.util.List;

import com.assignment.shoppingcart.microservices.cartservice.model.Cart;

public interface CartService {

	List<Cart> getCustomerCartDetails(Long id);

	boolean updateCart(Long id);

}
