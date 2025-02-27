package com.jsp.hibernate.hql;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;



public class App{
	public static void main(String[] args) {

		Configuration cfg=new Configuration().configure()
				.addAnnotatedClass(Product.class);
		SessionFactory sf=cfg.buildSessionFactory();
		Session session= sf.openSession();

		Transaction tran=session.beginTransaction();

		//		Fetching product from hql
//		Query<Product>query=session.createQuery("from Product");
//		List<Product>products=query.list();
//		for(Product product:products) {
//			System.out.println(product);
//		}
//

		// Update the data using hql
//		Query<Product>query1=session.createQuery("update Product p set p.productPrice=70000 where p.productId=101");
//		int rowsUpdated=query1.executeUpdate();        
//		if(rowsUpdated>0) {
//			System.out.println(rowsUpdated+"data is updated");
//		}else {
//			System.out.println("data is not updated");
//		}

		//		Update data usin place holder
		//		Query<Product>query1=session.createQuery("update Product p set "
		//				+ "p.productPrice=?1 where p.productId=?2");
		//		Query<Product>query1=session.createQuery("update Product p set "
		//				+ "p.productPrice =: price where p.productId =: id");
		//		query1.setParameter("price", 3999);
		//		query1.setParameter("id", 102);
		//		int rowsUpdated=query1.executeUpdate();        
		//		if(rowsUpdated>0) {
		//			System.out.println(rowsUpdated+"  data is updated");
		//		}else {
		//			System.out.println("data is not updated");
		//		}

		//		Delete data usin hql
		//		Query<Product>query2=session.createQuery("delete from Product p "
		//				+ "where p.productId=?1");
		//		query2.setParameter(1, 103);
		//		int rowsUpdated=query2.executeUpdate();        
		//		if(rowsUpdated>0) {
		//			System.out.println(rowsUpdated+"  data is deleted");
		//		}else {
		//			System.out.println("data is not deleted");
		//		}


		tran.commit();
		session.close();
		sf.close();
	}
}