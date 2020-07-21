package com.spring.dao;

import com.spring.model.User;

public class UserDAO {
	public boolean checkLogin(User user) {
		return user.getUsername().equals("admin")
				&& user.getPassword().equals("ashish");
	}
}