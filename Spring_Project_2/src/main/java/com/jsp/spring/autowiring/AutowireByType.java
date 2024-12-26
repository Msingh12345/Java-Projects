package com.jsp.spring.autowiring;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

public class AutowireByType {
	public static void main( String[] args ){
		BeanFactory bf=new XmlBeanFactory(new FileSystemResource("autowire-byType.xml"));
		Student s=bf.getBean(Student.class);
		System.out.println(s);
		System.out.println(s.getAddress());
		
		}
}
