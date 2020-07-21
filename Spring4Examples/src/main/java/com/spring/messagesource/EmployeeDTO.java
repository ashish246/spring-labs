package com.spring.messagesource;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;

public class EmployeeDTO implements MessageSourceAware {

	private MessageSource messageSource;

	private String message;

	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

	private Integer id;
	private String firstName;
	private String lastName;
	private String designation;

	public EmployeeDTO() {

	}

	public EmployeeDTO(String designation) {
		this.id = -1;
		this.firstName = "dummy";
		this.lastName = "dummy";
		this.designation = designation;
	}

	public void initBean() {
		System.out.println("Init Bean for : EmployeeDAOImpl");
	}

	public void destroyBean() {
		System.out.println("Init Bean for : EmployeeDAOImpl");
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", type=" + designation + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getMessage() {
		return messageSource.getMessage("msg.text", null, Locale.US);
	}

	public void setMessage(String message) {
		this.message = message;
	}
}