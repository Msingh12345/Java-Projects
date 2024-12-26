package com.jsp.hibernate.criteria;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class CriteriaBuilderApp {
	public static void main(String[] args) {



		Configuration cfg=new Configuration().configure()
				.addAnnotatedClass(Product.class);
		SessionFactory sf=cfg.buildSessionFactory();
		Session session= sf.openSession();

		Transaction tran=session.beginTransaction();


		//Fetch all the data
		CriteriaBuilder  cb=session.getCriteriaBuilder();
		CriteriaQuery<Product> cq=cb.createQuery(Product.class);
		Root<Product> root=cq.from(Product.class);
		cq.select(root);
		// only brand(all)
		//cq.select(root.get("productBrand"));
		Query<Product> query=session.createQuery(cq);
		List<Product>products=query.list();
		for(Product product:products) {
			System.out.println(product);
		}



		// Fetch(one data)
		//		CriteriaBuilder  cb=session.getCriteriaBuilder();
		//		CriteriaQuery<String> cq=cb.createQuery(String.class);
		//		Root<Product> root=cq.from(Product.class);

		//		cq.select(root.get("productBrand"));
		//		cq.where(cb.equal(root.get("productId"),101));

		//		Query<String> query=session.createQuery(cq);
		//		List<String>products=query.list();
		//		for(String product:products) {
		//			System.out.println(product);
		//		}

		//		Update
		//		CriteriaBuilder  cb=session.getCriteriaBuilder();
		//		CriteriaUpdate<Product> cu=cb.createCriteriaUpdate(Product.class);
		//		Root<Product> root=cu.from(Product.class);
		//		cu.set(root.get("productPrice"),111111);
		//		cu.where(cb.equal(root.get("productId"),101));
		//
		//		Query<Product>query=session.createQuery(cu);
		//		int rowsUpdated=query.executeUpdate();
		//		if(rowsUpdated>0) {
		//			System.out.println(rowsUpdated+" data updated");
		//		}else {
		//			System.out.println("Data not updated");
		//		}



		//		Delete
		//		CriteriaBuilder  cb=session.getCriteriaBuilder();
		//		CriteriaDelete<Product> cd=cb.createCriteriaDelete(Product.class);
		//		Root<Product> root=cd.from(Product.class);
		//		cd.where(cb.equal(root.get("productPrice"),3999));
		//
		//		Query<Product>query=session.createQuery(cd);
		//		int rowsDeleted=query.executeUpdate();
		//		if(rowsDeleted>0) {
		//			System.out.println(rowsDeleted+" data deleted");
		//		}else {
		//			System.out.println("Data not deleted");
		//		}

		tran.commit();
		session.close();
		sf.close();
	}
}


