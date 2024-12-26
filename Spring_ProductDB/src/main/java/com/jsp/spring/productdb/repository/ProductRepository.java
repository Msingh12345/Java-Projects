package com.jsp.spring.productdb.repository;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import com.jsp.spring.productdb.entity.Product;

@Repository
public class ProductRepository {		 
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("mysql-config");

     
	public void addProduct(Product product) {
	     EntityManager em = emf.createEntityManager();
	     EntityTransaction et = em.getTransaction();
	     et.begin();
		
		em.persist(product);
		et.commit();
		em.close();
		
	}
	
	public List<Product> findAll() {
		EntityManager em = emf.createEntityManager();
	    EntityTransaction et = em.getTransaction();
	    et.begin();
			
	    Query query = em.createQuery("FROM Product");
	    List<Product> products = query.getResultList();

		et.commit();
		em.close();
		
		return products;
		
	}
	public Product findProductById(int productId) {
		EntityManager em = emf.createEntityManager();
	    EntityTransaction et = em.getTransaction();
	    et.begin();
	    Product product = em.find(Product.class, productId);
		em.find(Product.class, product);
		et.commit();
		em.close();
		
		return product;
		
	}
	
	public void updateProduct(Product product) {		
		EntityManager em = emf.createEntityManager();
	    EntityTransaction et = em.getTransaction();
	    et.begin();
		
		em.merge(product);
		et.commit();
		em.close();
		
	}
	
	public void deleteProductById(int productId) {
		EntityManager em = emf.createEntityManager();
	    EntityTransaction et = em.getTransaction();
	     et.begin();
	     Product product = em.find(Product.class, productId);
		
		em.remove(product);
		et.commit();
		em.close();
		
	}

}