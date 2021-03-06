package com.assignment.shoppingcart.microservices.customerservice.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.assignment.shoppingcart.microservices.customerservice.model.Customer;
import com.assignment.shoppingcart.microservices.customerservice.model.dtos.CustomerDTO;

@Service
@Repository
public class CustomerServiceImpl implements CustomerService{
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional(rollbackOn = Exception.class)
	public List<CustomerDTO> getAllCustomers() {
		String queryString = "FROM Customer as c ORDER BY c.id";
		List<CustomerDTO> customers = (List<CustomerDTO>)entityManager.createQuery(queryString).getResultList();
		return customers;
	}

	@Override
	@Transactional(rollbackOn = Exception.class)
	public Customer getCustomersById(Long id) {
		return entityManager.find( Customer.class, id );
	}

}
