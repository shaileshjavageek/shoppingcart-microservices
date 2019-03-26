package com.assignment.shoppingcart.microservices.inventoryservice.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "inventory")
public class Inventory implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	@Column (name = "id")
	private Long id;
	
	@Column (name = "product_id")
	private Long productId;
	
	@Column (name = "quantity")
	private Integer quantity;
	
	@Column (name = "price")
	private Double price;
	
	public Inventory() {}

	public Long getId() {
		return id;
	}	

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}
		

}
