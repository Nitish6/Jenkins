package com.training.springMVC.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.yash.training.springMVC.dao.UserDao;
import com.yash.training.springMVC.model.Login;
import com.yash.training.springMVC.model.User;
import com.yash.training.springMVC.service.LoginService;

@RunWith(MockitoJUnitRunner.class)
public class LoginServiceTest {

	@InjectMocks
	private LoginService loginService;

	@Mock
	private UserDao userDao;

	private User user = new User();

	private Login login = new Login();

	@Test
	public void shouldReturnUserIfValidUser() {

		login.setPassword("12345");
		login.setUsername("nitish");

		user.setUserId(1);
		user.setUsername("nitish");
		user.setPassword("12345");

		when(userDao.validateUser("nitish", "12345")).thenReturn(user);

		User actualUser = loginService.validateUser(login);

		verify(userDao).validateUser("nitish", "12345");

		assertEquals((Integer) 1, actualUser.getUserId());
		assertEquals("nitish", actualUser.getUsername());
		assertEquals("12345", actualUser.getPassword());

	}

	@Test
	public void shouldReturnNullIfUserInvalid() {

		login.setPassword("12345");
		login.setUsername("nitish");

		when(userDao.validateUser("nitish", "12345")).thenReturn(user);

		User actualUser = loginService.validateUser(login);

		verify(userDao).validateUser("nitish", "12345");

		Assert.assertNull(actualUser.getUserId());
		Assert.assertNull(actualUser.getUsername());
		Assert.assertNull(actualUser.getPassword());

	}
}
