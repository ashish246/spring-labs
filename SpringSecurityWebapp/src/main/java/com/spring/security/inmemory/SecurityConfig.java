package com.spring.security.inmemory;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.spring.security.dao.AppUserDetailsServiceDAO;

/**
 * We can implement WebSecurityConfigurer interface or we can extend the base
 * implementation class WebSecurityConfigurerAdapter and override the methods.
 * 
 * @author Administrator
 *
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	/*
	 * The code shows how to plugin JDBC authentication. We need to configure it
	 * by providing DataSource. Since we are using custom tables, we are also
	 * required to provide the select queries to get the user details and it’s
	 * roles.
	 * 
	 * Configuring in-memory and DAO based authentication is easy, they are
	 * commented in above code. You can uncomment them to use them, make sure to
	 * have only one configuration at a time.
	 */
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {

		// in-memory authentication
		//auth.inMemoryAuthentication().withUser("ashish").password("ashish123").roles("USER");

		// using custom UserDetailsService DAO
		auth.userDetailsService(new AppUserDetailsServiceDAO());

		// using JDBC
		/*Context ctx = new InitialContext();
		DataSource ds = (DataSource) ctx
				.lookup("java:/comp/env/jdbc/test_local");

		final String findUserQuery = "select username,password,enabled "
				+ "from Employees " + "where username = ?";
		final String findRoles = "select username,role " + "from Roles "
				+ "where username = ?";

		auth.jdbcAuthentication().dataSource(ds)
				.usersByUsernameQuery(findUserQuery)
				.authoritiesByUsernameQuery(findRoles);*/
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring()
		// Spring Security should completely ignore URLs ending with .html
				.antMatchers("/*.html");
	}

}