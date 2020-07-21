package com.spring.event.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.event.EmployeeManager;

public class TestSpringEventHandling {
	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");

		EmployeeManager controller = context.getBean(EmployeeManager.class);

		controller.createNewEmployee();
	}
}