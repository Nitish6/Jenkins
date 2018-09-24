package com.yash.training.springMVC.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.training.springMVC.dao.UserDao;
import com.yash.training.springMVC.model.Login;
import com.yash.training.springMVC.model.User;

@Service
public class LoginService {

	@Autowired
	UserDao userDao;

	public User validateUser(Login login){

		String userName = login.getUsername();
		String password = login.getPassword();
		
		return userDao.validateUser(userName, password);
	}
}
