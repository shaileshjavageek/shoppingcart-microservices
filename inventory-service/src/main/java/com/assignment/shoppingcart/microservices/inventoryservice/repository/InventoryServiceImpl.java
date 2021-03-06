package com.assignment.shoppingcart.microservices.inventoryservice.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.assignment.shoppingcart.microservices.inventoryservice.model.Inventory;

@Service
@Repository
public class InventoryServiceImpl implements InventoryService{
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Transactional
	@Override
	public Inventory findProductById(Long productId) {
		String queryString = "FROM Inventory inv WHERE inv.productId = ?1";
		return (Inventory) entityManager.createQuery(queryString).setParameter(1,productId).getSingleResult();
	}

	@SuppressWarnings("unchecked")
	@Transactional
	@Override
	public List<Inventory> getAllProducts() {
		String queryString = "FROM Inventory inventory";
		return (List<Inventory>) entityManager.createQuery(queryString).getResultList();
	}

	@Transactional
	@Override
	public boolean updateInventory(Long id, Integer quantity) {
		String queryString = "FROM Inventory inv WHERE inv.productId = ?1";
		Inventory inventory = (Inventory) entityManager.createQuery(queryString).setParameter(1,id).getSingleResult();
		
		String query = "UPDATE Inventory inv SET inv.quantity=?1 WHERE inv.productId = ?2";
		int status = entityManager.createQuery(query).setParameter(1, (inventory.getQuantity() - quantity)).setParameter(2, id).executeUpdate();
		return status>0?true:false;
	}

}
