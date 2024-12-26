package com.jsp.hibernate2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class CarDelete {
public static void main(String[] args) {
	Configuration cfg=new Configuration();
	cfg.configure();
	cfg.addAnnotatedClass(Car.class);
	SessionFactory sf=cfg.buildSessionFactory();
	Session session = sf.openSession();
	Transaction tran=session.beginTransaction();
	
	Car c=new Car();
	c.setId(1);
	session.delete(c);
	
	
	tran.commit();
	session.close();
	sf.close();
}
}
