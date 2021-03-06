package com.assignment.shoppingcart.microservices.customerservice.repository;

import java.util.List;

import com.assignment.shoppingcart.microservices.customerservice.model.Customer;
import com.assignment.shoppingcart.microservices.customerservice.model.dtos.CustomerDTO;

public interface CustomerService {
	
	public List<CustomerDTO> getAllCustomers();

	public Customer getCustomersById(Long id);

}
