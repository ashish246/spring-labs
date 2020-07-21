package com.spring.staticfactorymethod;

import com.spring.factorybean.EmployeeDTO;

public class EmployeeFactory {

	public static EmployeeDTO createEmployeeOfType(String type) {
		if ("manager".equals(type) || "director".equals(type)) {
			EmployeeDTO employee = new EmployeeDTO();

			employee.setId(-1);
			employee.setFirstName("dummy");
			employee.setLastName("dummy");
			// Set designation here
			employee.setDesignation(type);

			return employee;
		} else {
			throw new IllegalArgumentException("Unknown product");
		}
	}
}