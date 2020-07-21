package com.spring.transaction.service;

import org.springframework.transaction.annotation.Transactional;

import com.spring.transaction.dao.CustomerDAO;
import com.spring.transaction.model.Customer;

public class CustomerManagerImpl implements CustomerManager {

	private CustomerDAO customerDAO;

	public void setCustomerDAO(CustomerDAO customerDAO) {
		this.customerDAO = customerDAO;
	}

	@Transactional
	public void createCustomer(Customer cust) {
		customerDAO.create(cust);
	}

}