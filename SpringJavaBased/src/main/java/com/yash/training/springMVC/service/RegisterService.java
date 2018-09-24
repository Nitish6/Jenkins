package com.yash.training.springMVC.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yash.training.springMVC.dao.UserDao;
import com.yash.training.springMVC.model.User;

@Service
public class RegisterService {

	@Autowired
	UserDao userDao;
	
	@Transactional
	public Integer addUser(User user){
		return userDao.addUser(user);
	}
}
