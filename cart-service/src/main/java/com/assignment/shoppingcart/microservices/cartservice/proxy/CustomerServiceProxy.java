package com.assignment.shoppingcart.microservices.cartservice.proxy;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.assignment.shoppingcart.microservices.cartservice.model.dtos.CustomerDTO;

@FeignClient(name = "zuul-gateway-server")
@RibbonClient(name = "customer-service")
public interface CustomerServiceProxy {
	
	@GetMapping("/customer-service/customer/{id}")
	public CustomerDTO getCustomerDetails(@PathVariable("id") Long id );

}
