package com.assignment.shoppingcart.microservices.customerservice.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "customer")
public class Customer implements Serializable{

	private static final long serialVersionUID = 3943741931634429527L;
	
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	@Column (name = "id")
	private Long id;
	
	@Column (name = "customer_name")
	private String customerName;
	
	@Column (name = "email_id")
	private String emailId;
	
	@Column (name = "phone_number")
	private String phoneNumber;
	
	public Customer() {	}

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
