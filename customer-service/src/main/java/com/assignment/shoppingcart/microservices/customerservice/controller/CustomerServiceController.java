package com.assignment.shoppingcart.microservices.customerservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.shoppingcart.microservices.customerservice.exception.CustomerNotFoundException;
import com.assignment.shoppingcart.microservices.customerservice.model.Customer;
import com.assignment.shoppingcart.microservices.customerservice.model.dtos.CustomerDTO;
import com.assignment.shoppingcart.microservices.customerservice.repository.CustomerService;

@RestController
@RequestMapping("customer")
public class CustomerServiceController {

	@Autowired
	private CustomerService customerService;	
	
	@GetMapping("/{id}")
	public Customer getCustomerDetails(@PathVariable("id") Long id ) {		
		Customer customer = customerService.getCustomersById(id);
		if(customer == null) {
			throw new CustomerNotFoundException("id -> "+id);
		}
		return customer;
	}
	
	@GetMapping
	public List<CustomerDTO> getCustomers() {		
		List<CustomerDTO> customers = customerService.getAllCustomers();
		if(customers.isEmpty()) {
			throw new CustomerNotFoundException("Customer not found.");
		}
		return customers;
	}
	
	
}
