package com.spring.resource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpringResourceLoading {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");

		CustomResourceLoader customResourceLoader = (CustomResourceLoader) context
				.getBean("customResourceLoader");

		customResourceLoader.showResourceData();

		CustomResourceLoaderXML customResourceLoaderXML = (CustomResourceLoaderXML) context
				.getBean("customResourceLoaderXML");

		customResourceLoaderXML.showResourceData();
	}
}
