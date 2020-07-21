package com.spring.security.dao;

import java.util.Collection;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * Since we will be using DAO based authentication also, we need to implement
 * UserDetailsService interface and provide the implementation for
 * loadUserByUsername() method.
 * 
 * Ideally we should be using some resource to validate the user, but for
 * simplicity I am just doing basic validation.
 * 
 * @author Administrator
 *
 */
public class AppUserDetailsServiceDAO implements UserDetailsService {

	protected final Log logger = LogFactory.getLog(getClass());

	@Override
	public UserDetails loadUserByUsername(final String username)
			throws UsernameNotFoundException {

		logger.info("loadUserByUsername username=" + username);

		if (!username.equals("ashish")) {
			throw new UsernameNotFoundException(username + " not found");
		}

		// creating dummy user details, should do JDBC operations
		return new UserDetails() {

			private static final long serialVersionUID = 2059202961588104658L;

			@Override
			public boolean isEnabled() {
				return true;
			}

			@Override
			public boolean isCredentialsNonExpired() {
				return true;
			}

			@Override
			public boolean isAccountNonLocked() {
				return true;
			}

			@Override
			public boolean isAccountNonExpired() {
				return true;
			}

			@Override
			public String getUsername() {
				return username;
			}

			@Override
			public String getPassword() {
				return "ashish123";
			}

			@Override
			public Collection<? extends GrantedAuthority> getAuthorities() {
				List<SimpleGrantedAuthority> auths = new java.util.ArrayList<SimpleGrantedAuthority>();
				auths.add(new SimpleGrantedAuthority("admin"));
				return auths;
			}
		};
	}

}