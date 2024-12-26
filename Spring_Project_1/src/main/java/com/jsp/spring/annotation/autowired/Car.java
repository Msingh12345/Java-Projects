package com.jsp.spring.annotation.autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Car {
	// Field injection
	@Autowired
	private Engine engine;

	// Constructor injection
	//@Autowired
	public Car(Engine engine) {
		super();
		this.engine = engine;
	}

	// Setter injection
	//@Autowired
	public void setEngine(Engine engine) {
		this.engine = engine;
	}
	public Engine getEngine() {
		return engine;
	}

	


}
