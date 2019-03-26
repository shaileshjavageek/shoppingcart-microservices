package com.assignment.shoppingcart.microservices.orderservice.proxy;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "zuul-gateway-server")
@RibbonClient (name = "cart-service")
public interface CartServiceProxy {
	
	@GetMapping("/cart-service/cart/{id}")
	public boolean checkoutCart(@PathVariable("id") Long id);

}
