package com.assignment.shoppingcart.microservices.customerservice.model.dtos;

import java.io.Serializable;

public class CustomerDTO implements Serializable{
	
	private static final long serialVersionUID = 3943741931634429527L;
	
	private Long id;
	
	private String customerName;
	
	private String emailId;
	
	private String phoneNumber;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}
