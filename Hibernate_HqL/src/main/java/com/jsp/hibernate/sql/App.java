package com.jsp.hibernate.sql;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.jsp.hibernate.hql.Product;

public class App {
	public static void main(String[] args) {

		Configuration cfg=new Configuration().configure()
				.addAnnotatedClass(Product.class);
		SessionFactory sf=cfg.buildSessionFactory();
		Session session= sf.openSession();

		Transaction tran=session.beginTransaction();
		
		// fetching data using sql
		Query<Product>query=session.createNativeQuery("select * from Product where productId=:id"
				,Product.class);
		query.setParameter("id", 101);
		List<Product>products=query.list();
		for(Product product:products) {
			System.out.println(product);
		}
		
		//Update data usin place holder
//		Query<Product>query1=session.createNativeQuery("update Product set "
//				+ "productPrice=?1 where productId=?2",Product.class);
////		Query<Product>query1=session.createQuery("update Product  set "
////				+ "productPrice =: price where productId =: id");
//		query1.setParameter(1, 6999);
//		query1.setParameter(2, 102);
//		int rowsUpdated=query1.executeUpdate();        
//		if(rowsUpdated>0) {
//			System.out.println(rowsUpdated+"  data is updated");
//		}else {
//			System.out.println("data is not updated");
//		}
		
		//Delete data usin sql
		Query<Product>query2=session.createNativeQuery("delete from Product "
				+ "where productId=?1",Product.class);
		query2.setParameter(1, 103);
		int rowsUpdated2=query2.executeUpdate();        
		if(rowsUpdated2>0) {
			System.out.println(rowsUpdated2+"  data is deleted");
		}else {
			System.out.println("data is not deleted");
		}
		
		
		tran.commit();
		session.close();
		sf.close();
	}
}
