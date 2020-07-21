package com.spring.autowiring.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.spring.autowiring.model.Employee;

/**
 * Note that I have annotated both Employee variable and it’s setter method with @Autowired
 * annotation, however only one of these is sufficient for spring bean
 * autowiring.
 * 
 * @author Administrator
 *
 */
public class EmployeeAutowiredByTypeService {

	// Autowired annotation on variable/setters is equivalent to
	// autowire="byType"
	@Autowired
	private Employee employee;

	@Autowired
	public void setEmployee(Employee emp) {
		this.employee = emp;
	}

	public Employee getEmployee() {
		return this.employee;
	}
}