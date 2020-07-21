package com.spring.utilconstants;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpringUtilConstants {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");

		EmployeeTypeWrapper employeeTypeWrapper = (EmployeeTypeWrapper) context
				.getBean("employeeTypeWrapper");

		System.out.println(employeeTypeWrapper.getManager());
		System.out.println(employeeTypeWrapper.getDirector());

		context.close();
	}
}
