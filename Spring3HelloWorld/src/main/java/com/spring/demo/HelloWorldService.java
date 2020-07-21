package com.spring.demo;

import org.springframework.stereotype.Service;

/**
 * We use the @Service(
 * "helloWorldService”) stereotype annotation so as to declare that this class represents a Spring service by the name "
 * helloWorldService”. The Spring container will instantiate all services at
 * start up.
 * 
 * Alternatively, we can declare the Spring bean directly to the
 * "applicationContext.xml" file by omitting the @Service(
 * "helloWorldService”) stereotype annotation from the bean class, removing the context:component-scan element from the "
 * applicationContext.xml" file
 * 
 * @author Administrator
 *
 */
//@Service("helloWorldService")
public class HelloWorldService {

	private String name;

	public void setName(String name) {
		this.name = name;
	}

	public String sayHello() {
		return "Hello from HelloWorld Service! " + name;
	}

}