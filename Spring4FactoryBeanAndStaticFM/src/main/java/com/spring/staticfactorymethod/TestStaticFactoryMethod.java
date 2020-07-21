package com.spring.staticfactorymethod;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.factorybean.EmployeeDTO;

public class TestStaticFactoryMethod {
	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");

		EmployeeDTO manager = (EmployeeDTO) context.getBean("manager-static");
		System.out.println(manager);

		EmployeeDTO director = (EmployeeDTO) context.getBean("director-static");
		System.out.println(director);
	}
}