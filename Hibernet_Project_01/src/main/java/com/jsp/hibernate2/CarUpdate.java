package com.jsp.hibernate2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class CarUpdate {
	public static void main(String[] args) {
		Configuration cfg=new Configuration();
		cfg.configure();
		cfg.addAnnotatedClass(Car.class);
		SessionFactory sf=cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tran=session.beginTransaction();
		
		Car c=session.get(Car.class, 1);
		c.setName("qqqqqq");
		c.setPrice(000000);
		session.saveOrUpdate(c);
		
		
		tran.commit();
		session.close();
		sf.close();
		
	}
}
