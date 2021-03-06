package com.spring.beans.main;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(value = "com.spring.beans.main")
public class MyConfiguration {

	@Bean
	public MyService getService() {
		return new MyService();
	}
}