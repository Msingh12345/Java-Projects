package com.jsp.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
public static void main(String[] args) {
	
	Person person=new Person();
	person.setPersonId(104);
	person.setPersonName("Peter");
	
	Aadhar aadhar=new Aadhar();
	aadhar.setAadharId(3);
	aadhar.setAadharNo(45678909876l);
	
	person.setAadhar(aadhar);
	aadhar.setPerson(person);
	
	Configuration cfg=new Configuration();
	cfg.configure();
	cfg.addAnnotatedClass(Person.class);
	cfg.addAnnotatedClass(Aadhar.class);
	SessionFactory sf=cfg.buildSessionFactory();
	Session session =sf.openSession();
	
	Transaction tran=session.beginTransaction();
//	session.save(person);
//	session.save(aadhar);
	
	Person p=session.get(Person.class, 104);
	System.out.println(p.getPersonId());
	System.out.println(p.getPersonName());
	System.out.println(p.getAadhar().getAadharId());
	System.out.println(p.getAadhar().getAadharNo());

	tran.commit();
	session.close();
	sf.close();
}
}
