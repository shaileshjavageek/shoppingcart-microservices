package com.assignment.shoppingcart.microservices.cartservice.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.assignment.shoppingcart.microservices.cartservice.model.Cart;

@Service
@Repository
public class CartServiceImpl implements CartService{
	
	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Transactional (rollbackOn = Exception.class)
	@Override
	public List<Cart> getCustomerCartDetails(Long id) {
		String query = "FROM Cart c WHERE c.customerId=?1";
		List<Cart> items = (List<Cart>)entityManager.createQuery(query).setParameter(1, id).getResultList();
		return items;
	}

	@Transactional (rollbackOn = Exception.class)
	@Override
	public boolean updateCart(Long id) {
		String query = "UPDATE TABLE Cart c SET c.isCheckedout=?1 WHERE c.id=?2";
		int status = (Integer)entityManager.createQuery(query).setParameter(1, true).setParameter(2, id).executeUpdate();
		return status>0?true:false;
	}
	
}
