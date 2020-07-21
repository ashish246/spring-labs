package com.spring.mail;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailParseException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

/**
 * A Java class to send email with the Spring’s MailSender interface, and use
 * the String.format to replace the email message ‘%s‘ with passing variable in
 * bean configuration file.
 * 
 * @author Administrator
 *
 */
public class AttachmentMailer {

	private JavaMailSender mailSender;
	private SimpleMailMessage simpleMailMessage;

	public void setSimpleMailMessage(SimpleMailMessage simpleMailMessage) {
		this.simpleMailMessage = simpleMailMessage;
	}

	public void setMailSender(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}

	public void sendMail(String dear, String content) {

		MimeMessage message = mailSender.createMimeMessage();

		try {
			MimeMessageHelper helper = new MimeMessageHelper(message, true);

			helper.setFrom(simpleMailMessage.getFrom());
			helper.setTo(simpleMailMessage.getTo());
			helper.setSubject(simpleMailMessage.getSubject());
			helper.setText(String.format(simpleMailMessage.getText(), dear,
					content));

			FileSystemResource file = new FileSystemResource(
					"Retail Shipment Payload.txt");
			helper.addAttachment(file.getFilename(), file);

		} catch (MessagingException e) {
			throw new MailParseException(e);
		}

		mailSender.send(message);
	}
}