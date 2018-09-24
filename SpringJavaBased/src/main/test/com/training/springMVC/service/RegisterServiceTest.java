package com.training.springMVC.service;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.yash.training.springMVC.dao.UserDao;
import com.yash.training.springMVC.model.User;
import com.yash.training.springMVC.service.RegisterService;

@RunWith(MockitoJUnitRunner.class)
public class RegisterServiceTest {

	@InjectMocks
	private RegisterService registerService;

	@Mock
	private UserDao userDao;

	@Test
	public void shouldAddUser(){

		User user = new User();
		user.setUsername("nitish");
		user.setPassword("12345");
		user.setFirstname("nitish");
		user.setLastname("aggarwal");
		user.setPhone("11111");
		user.setEmail("ewew");
		user.setUserId(1);

		Mockito.when(userDao.addUser(user)).thenReturn(1);

		Integer actualUserId = registerService.addUser(user);

		Mockito.verify(userDao).addUser(user);

		Assert.assertEquals((Integer)1, actualUserId);

	}
}
