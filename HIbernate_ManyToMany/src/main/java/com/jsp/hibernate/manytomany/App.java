package com.jsp.hibernate.manytomany;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
	public static void main(String[] args) {

		Student s1=new Student();
		s1.setStudentId(101);
		s1.setStudentName("Tom");

		Student s2=new Student();
		s2.setStudentId(102);
		s2.setStudentName("Tony");

		Course c1=new Course();
		c1.setCourseId(1);
		c1.setCourseName("JFS");
		c1.setCourseFee(35999);

		Course c2=new Course();
		c2.setCourseId(2);
		c2.setCourseName("PFS");
		c2.setCourseFee(34999);

//		List<Course> l=new ArrayList<Course>();
//		l.add(c1);
//		l.add(c2);
//
//		s1.setCourse(l);
//		s2.setCourse(l);

		List<Student> l2=new ArrayList();
		l2.add(s1);
		l2.add(s2);

		c1.setStudent(l2);
		c2.setStudent(l2);


		Configuration cfg=new Configuration().configure()
				.addAnnotatedClass(Student.class)
				.addAnnotatedClass(Course.class);
		SessionFactory sf=cfg.buildSessionFactory();
		Session session= sf.openSession();

		Transaction tran=session.beginTransaction();

		session.save(s1);
		session.save(s2);
		session.save(c1);
		session.save(c2);

		tran.commit();
		session.close();
		sf.close();
	}
}
