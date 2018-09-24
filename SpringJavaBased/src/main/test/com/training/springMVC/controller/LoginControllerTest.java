package com.training.springMVC.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.web.servlet.ModelAndView;

import com.yash.training.springMVC.controller.LoginController;
import com.yash.training.springMVC.model.Login;
import com.yash.training.springMVC.model.User;
import com.yash.training.springMVC.service.LoginService;

@RunWith(MockitoJUnitRunner.class)
public class LoginControllerTest {

	@InjectMocks
	private LoginController loginController;

	@Mock
	private LoginService loginService;

	private Login login = new Login();

	private User user = new User();

	@Test
	public void shouldReturnModelAndViewObjectForLogin(){

		ModelAndView actual = loginController.loginForm();

		assertEquals("login", actual.getViewName());
	}

	@Test
	public void shouldReturnUserIfValidCredentials(){

		login.setUsername("ww");
		login.setPassword("ew");

		user.setFirstname("ew");
		user.setUsername("ww");
		user.setPassword("ew");

		Mockito.when(loginService.validateUser(login)).thenReturn(user);
		ModelAndView actual = loginController.validateUser(login);

		Mockito.verify(loginService).validateUser(login);

		assertEquals("userDetails", actual.getViewName());
	}

	@Test
	public void shouldReturnToLoginIfInValidCredentials(){

		login.setUsername("ww");
		login.setPassword("ew");

		Mockito.when(loginService.validateUser(login)).thenReturn(null);
		
		ModelAndView actual = loginController.validateUser(login);

		Mockito.verify(loginService).validateUser(login);

		assertEquals("login", actual.getViewName());
	}

}
