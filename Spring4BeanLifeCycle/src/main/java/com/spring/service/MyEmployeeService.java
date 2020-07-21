package com.spring.service;

import com.spring.bean.Employee;

/**
 * Since we don’t want our services to have direct spring framework dependency,
 * let’s create another form of Employee Service class where we will have
 * post-init and pre-destroy methods and we will configure them in the spring
 * bean configuration file.
 * 
 * @author Administrator
 *
 */
public class MyEmployeeService {

	private Employee employee;

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public MyEmployeeService() {
		System.out.println("MyEmployeeService no-args constructor called");
	}

	// pre-destroy method
	public void destroy() throws Exception {
		System.out.println("MyEmployeeService Closing resources");
	}

	// post-init method
	public void init() throws Exception {
		System.out.println("MyEmployeeService initializing to dummy value");
		if (employee.getName() == null) {
			employee.setName("Ashish");
		}
	}
}