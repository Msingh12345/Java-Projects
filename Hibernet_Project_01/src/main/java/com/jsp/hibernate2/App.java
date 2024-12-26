package com.jsp.hibernate2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
	public static void main(String[] args) {
		Car car=new Car();
		car.setId(2);
		car.setName("civic");
		car.setBrand("Honda-hero");
		car.setPrice(200000);
		Configuration cfg=new Configuration();
		cfg.configure();
		cfg.addAnnotatedClass(Car.class);
		SessionFactory sf=cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tran=session.beginTransaction();
		session.save(car);

		tran.commit();
		session.close();
		sf.close();


	}
}
