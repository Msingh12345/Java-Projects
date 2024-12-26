package com.jsp.hibernate.level2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class App {
	public static void main(String[] args) {
		Configuration cfg=new Configuration().configure()
				.addAnnotatedClass(Product.class);
		SessionFactory sf=cfg.buildSessionFactory();
		Session session= sf.openSession();

		Transaction tran=session.beginTransaction();
        
		Product p1=session.get(Product.class,101);
		System.out.println(p1);
		Product p2=session.get(Product.class, 101);
		System.out.println(p2);
		
		tran.commit();
		session.close();
		sf.close();
	}
}
