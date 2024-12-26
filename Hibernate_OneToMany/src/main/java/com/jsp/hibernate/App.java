package com.jsp.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
	public static void main(String[] args) {
		
		Company c=new Company();
		c.setCompantId(1);
		c.setCompanyName("Amazon");
		
		Employee e1=new Employee();
		e1.setEmployeeId(101);
		e1.setEmployeeName("Tom");
	    e1.setEmployeeSalary(30000);
	    
		Employee e2=new Employee();
		e2.setEmployeeId(102);
		e2.setEmployeeName("Tony");
	    e2.setEmployeeSalary(40000);
	    
	    
	    // can skip for bidirectional in OneToMany
//	    List<Employee> l=new ArrayList();
//	    l.add(e1);
//	    l.add(e2);
	  
	    // for ManyToOne
//	    c.setEmployee(l);
	    
	    // both combine ManyToMany
	    
	    // for ManuToOne
	    e1.setCompany(c);
	    e2.setCompany(c);
	    
	    
	    
		
		Configuration cfg=new Configuration();
		cfg.configure();
		cfg.addAnnotatedClass(Company.class);
		cfg.addAnnotatedClass(Employee.class);
		SessionFactory sf=cfg.buildSessionFactory();
		Session session =sf.openSession();

		Transaction tran=session.beginTransaction();
			session.save(e1);
			session.save(e2);
			session.save(c);

		tran.commit();
		session.close();
		sf.close();
	}
}
