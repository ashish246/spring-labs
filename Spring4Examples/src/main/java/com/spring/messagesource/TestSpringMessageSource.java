package com.spring.messagesource;

import java.util.Locale;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpringMessageSource {
	public static void main(String[] args) throws Exception {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");

		String message = context.getMessage("msg.text", null, Locale.US);

		System.out.println(message);

		EmployeeDTO emp = (EmployeeDTO) context.getBean("messageTest");
		// EmployeeDTO emp = (EmployeeDTO) context.getBean(EmployeeDTO.class);

		System.out.println("From Bean: " + emp.getMessage());

		context.close();
	}
}