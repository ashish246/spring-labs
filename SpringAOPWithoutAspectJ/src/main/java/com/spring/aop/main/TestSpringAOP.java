package com.spring.aop.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.aop.service.CustomerService;

public class TestSpringAOP {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext(
				new String[] { "Spring-Customer.xml" });

		CustomerService cust = (CustomerService) appContext
				.getBean("customerServiceProxy");

		System.out.println("*************************");
		cust.printName();
		System.out.println("*************************");
		cust.printURL();
		System.out.println("*************************");
		try {
			cust.printThrowException();
		} catch (Exception e) {
		}
	}
}