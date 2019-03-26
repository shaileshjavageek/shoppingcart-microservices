package com.assignment.shoppingcart.microservices.productservice.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.assignment.shoppingcart.microservices.productservice.model.Product;
import com.assignment.shoppingcart.microservices.productservice.model.dtos.ProductDTO;

@Service
@Repository
public class ProductServiceImpl implements ProductService{
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Product findProductById(Long id) {
		return entityManager.find(Product.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ProductDTO> findAllProduct() {
		String queryString = "FROM Product as p ORDER BY p.id";
		List<ProductDTO> products = (List<ProductDTO>)entityManager.createQuery(queryString).getResultList();
		return products;
	}
	
	

}
