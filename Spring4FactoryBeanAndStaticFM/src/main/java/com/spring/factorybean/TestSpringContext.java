package com.spring.factorybean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpringContext {
	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");

		EmployeeDTO manager = (EmployeeDTO) context.getBean("manager");
		System.out.println(manager);

		EmployeeDTO director = (EmployeeDTO) context.getBean("director");
		System.out.println(director);

		// If you want to get the instance of EmployeeFactoryBean itself, then
		// you can add an “&” before the bean name.
		EmployeeFactoryBean factory = (EmployeeFactoryBean) context
				.getBean("&director");

		System.out.println(factory.getDesignation());
		System.out.println(factory.getObjectType());
		System.out.println(factory.getObject());
	}
}