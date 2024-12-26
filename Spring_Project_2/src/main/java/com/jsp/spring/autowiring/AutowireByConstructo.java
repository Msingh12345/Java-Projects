package com.jsp.spring.autowiring;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

public class AutowireByConstructo {
	public static void main( String[] args ){
		BeanFactory bf=new XmlBeanFactory(new FileSystemResource("autowire-constructor.xml"));
		Student s=bf.getBean(Student.class);
		System.out.println(s);
		System.out.println(s.getAddress());
		
		}
}
