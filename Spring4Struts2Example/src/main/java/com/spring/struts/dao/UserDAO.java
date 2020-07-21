package com.spring.struts.dao;

import com.spring.struts.model.User;

public class UserDAO {
	public boolean checkLogin(User user) {
		return user.getUsername().equals("admin")
				&& user.getPassword().equals("ashish");
	}
}