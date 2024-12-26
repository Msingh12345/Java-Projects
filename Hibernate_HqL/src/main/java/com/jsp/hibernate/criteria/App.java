package com.jsp.hibernate.criteria;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;


public class App {
	public static void main(String[] args) {


		Configuration cfg=new Configuration().configure()
				.addAnnotatedClass(Product.class);
		SessionFactory sf=cfg.buildSessionFactory();
		Session session= sf.openSession();

		Transaction tran=session.beginTransaction();
		Criteria criteria=session.createCriteria(Product.class);
		criteria.setProjection(Projections.property("productName"));
		//	criteria.add(Restrictions.eq("productId", 101));
		//	criteria.add(Restrictions.gt("productId", 102));
		//	criteria.add(Restrictions.between("productId", 101, 103));
		//	criteria.add(Restrictions.lt("productId", 102));
		//	criteria.add(Restrictions.isNotNull("productId"));
		//	criteria.add(Restrictions.in("productId", 101));

		// String,int etc for projection and Product for Restriction and normal;
		//	List<Product>products=criteria.list();

		List<String>products=criteria.list();
		for(String product:products) {
			System.out.println(product);
		}


		tran.commit();
		session.close();
		sf.close();
	}
}
