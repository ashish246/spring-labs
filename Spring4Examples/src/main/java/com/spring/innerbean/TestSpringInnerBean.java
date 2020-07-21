package com.spring.innerbean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpringInnerBean {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "applicationContext.xml" });

		Customer cust = (Customer) context.getBean("CustomerBean");
		System.out.println(cust);

	}
}
