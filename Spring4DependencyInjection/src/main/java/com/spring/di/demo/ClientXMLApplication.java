package com.spring.di.demo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.di.consumer.MyXMLApplication;

/**
 * ClassPathXmlApplicationContext is used to get the ApplicationContext object
 * by providing the configuration files location. It has multiple overloaded
 * constructors and we can provide multiple config files also.
 * 
 * @author Administrator
 *
 */
public class ClientXMLApplication {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		MyXMLApplication app = context.getBean(MyXMLApplication.class);

		app.processMessage("Hi Ashish", "ashish@abc.com");

		// close the context
		context.close();
	}

}