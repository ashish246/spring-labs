package com.spring.mail;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * Time to test the code. I am sending two messages from test code. One is
 * instantiated and composed in test class itself, and another one is
 * pre-configured message from application-context.xml file.
 * 
 * @author Administrator
 *
 */
public class MailerTest {

	public static void main(String[] args) {
		// Create the application context
		ApplicationContext context = new FileSystemXmlApplicationContext(
				"src/main/resources/spring.xml");

		// Get the mailer instance
		ApplicationMailer mailer = (ApplicationMailer) context
				.getBean("mailService");

		// Send a composed mail
		mailer.sendMail("ashishtripathi.itbhu@gmail.com", "Test Subject",
				"Testing body");

		// Send a pre-configured mail
		mailer.sendPreConfiguredMail("Exception occurred everywhere.. where are you ????");
	}
}
