package com.spring.transaction.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.transaction.model.Address;
import com.spring.transaction.model.Customer;
import com.spring.transaction.service.CustomerManager;
import com.spring.transaction.service.CustomerManagerImpl;

public class TransactionManagerMain {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
				"spring.xml");

		CustomerManager customerManager = ctx.getBean("customerManager",
				CustomerManagerImpl.class);

		Customer cust = createDummyCustomer();
		customerManager.createCustomer(cust);

		ctx.close();
	}

	private static Customer createDummyCustomer() {
		Customer customer = new Customer();
		customer.setId(2);
		customer.setName("Ashish");
		Address address = new Address();
		address.setId(2);
		address.setCountry("India");
		// setting value more than 20 chars, so that SQLException occurs
		address.setAddress("Albany Dr, San Jose, CA 95129");
		customer.setAddress(address);
		return customer;
	}

}