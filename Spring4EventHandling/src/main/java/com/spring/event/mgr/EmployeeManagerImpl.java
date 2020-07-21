package com.spring.event.mgr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Service;

import com.spring.event.EmployeeDAO;
import com.spring.event.EmployeeDTO;
import com.spring.event.EmployeeEvent;
import com.spring.event.EmployeeManager;

@Service("employeeManager")
public class EmployeeManagerImpl implements EmployeeManager,
		ApplicationEventPublisherAware {
	
	@Autowired
	private EmployeeDAO dao;

	private ApplicationEventPublisher publisher;

	// You must override this method; It will give you acces to
	// ApplicationEventPublisher
	public void setApplicationEventPublisher(ApplicationEventPublisher publisher) {
		this.publisher = publisher;
	}

	public EmployeeDTO createNewEmployee() {
		EmployeeDTO employee = dao.createNewEmployee();

		// publishing the veent here
		publisher.publishEvent(new EmployeeEvent(this, "ADD", employee));

		return employee;
	}
}