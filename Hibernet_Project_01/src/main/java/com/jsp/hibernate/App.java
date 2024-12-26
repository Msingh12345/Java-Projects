package com.jsp.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;



public class App {
     public static void main(String[] args) {
		Bike bike=new Bike();
		bike.setBikeId(101);
		bike.setBikeBrand("Tvs");
		bike.setBikeModel("90");
		bike.setBikePrice(70000);
		
		Bike bike2=new Bike();
		bike2.setBikeId(102);
		bike2.setBikeBrand("yamaha");
		bike2.setBikeModel("Xth-87A");
		bike2.setBikePrice(700000);
		
		Configuration   conn=new Configuration();
		conn.configure();
		conn.addAnnotatedClass(Bike.class);
		SessionFactory sf=conn.buildSessionFactory();
		Session session =sf.openSession();
		Transaction trn=session.beginTransaction();
//		session.save(bike);
		session.save(bike2);
		trn.commit();
		session.clear();
		sf.close();
		
		
	}
}
