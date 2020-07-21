package com.spring.service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Below is a simple class that will be configured as spring bean and for
 * post-init and pre-destroy methods, we are using @PostConstruct and @PreDestroy
 * annotations.
 * 
 * @author Administrator
 *
 */
public class MyService {

	@PostConstruct
	public void init() {
		System.out.println("MyService init method called");
	}

	public MyService() {
		System.out.println("MyService no-args constructor called");
	}

	@PreDestroy
	public void destory() {
		System.out.println("MyService destroy method called");
	}
}