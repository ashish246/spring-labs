package com.spring.postprocessor;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestCustomPostProcessor {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");

		context.close();
	}
}
