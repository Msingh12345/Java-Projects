package com.jsp.spring.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	public static void main( String[] args ){
		ApplicationContext ac=new ClassPathXmlApplicationContext("spring.xml");
		Product p1=ac.getBean(Product.class);
		System.out.println(p1);
		
		Product p2=(Product)ac.getBean("product");
		System.out.println(p2);

	}
}
