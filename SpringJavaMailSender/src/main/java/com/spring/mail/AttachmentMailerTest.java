package com.spring.mail;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AttachmentMailerTest {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext(
				"spring.xml");

		AttachmentMailer mm = (AttachmentMailer) context
				.getBean("attachmentMail");

		mm.sendMail("Yong Mook Kim", "This is text content");
	}
}
