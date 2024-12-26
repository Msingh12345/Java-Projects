package com.jsp.spring.annotation.autowired;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
	public static void main(String[] args) {
		ApplicationContext ac=new AnnotationConfigApplicationContext(AppConfig.class);;
		Car c=ac.getBean(Car.class);
		System.out.println(c);
		System.out.println(c.getEngine());
	}
}
