package com.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.spring.dao.UserDAO;

@Configuration
@ComponentScan("com.spring")
public class ApplicationContextConfig {

	@Bean(name = "userDAO")
	public UserDAO getUserDAO() {
		return new UserDAO();
	}
}