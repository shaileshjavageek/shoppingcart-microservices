package com.assignment.shoppingcart.microservices.cartservice.proxy;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@FeignClient(name = "zuul-gateway-server")
@RibbonClient(name = "inventory-service")
public interface InventoryServiceProxy {

	@GetMapping("/inventory-service/inventory/{id}/{quantity}")
	public boolean updateInvntory(@PathVariable("id") Long id, @PathVariable("quantity") Integer quantity);

}
