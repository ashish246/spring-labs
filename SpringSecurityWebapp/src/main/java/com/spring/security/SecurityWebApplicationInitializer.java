package com.spring.security;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

import com.spring.security.inmemory.SecurityConfig;

/**
 * @author Administrator
 *
 */
public class SecurityWebApplicationInitializer extends
		AbstractSecurityWebApplicationInitializer {

	public SecurityWebApplicationInitializer() {
		super(SecurityConfig.class);
	}
}