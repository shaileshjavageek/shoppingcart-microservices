package com.assignment.shoppingcart.microservices.cartservice.proxy;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.assignment.shoppingcart.microservices.cartservice.model.dtos.ProductDTO;


@FeignClient(name="zuul-gateway-server")
@RibbonClient(name="product-service")
public interface ProductServiceProxy {
	
	@GetMapping("/product-service/product/{id}")
	public ProductDTO getProductById(@PathVariable("id") Long id);

}
