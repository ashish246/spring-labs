package com.spring.validation.model;

/**
 * Is a standard java bean and we will use our custom Validator implementation
 * to validate the form with Employee bean
 * 
 * @author Administrator
 *
 */
public class Employee {

	private int id;
	private String name;
	private String role;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}