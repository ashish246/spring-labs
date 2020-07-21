package com.spring.struts.action;

import com.opensymphony.xwork2.ActionSupport;
import com.spring.struts.dao.UserDAO;
import com.spring.struts.model.User;

public class LoginAction extends ActionSupport {
	
	private UserDAO userDAO;
	private User user;

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public User getUser() {
		return user;
	}

	public String execute() {
		if (userDAO.checkLogin(user)) {
			return SUCCESS;
		}

		return ERROR;
	}
}