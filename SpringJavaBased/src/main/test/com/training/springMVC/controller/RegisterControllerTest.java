package com.training.springMVC.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.web.servlet.ModelAndView;

import com.yash.training.springMVC.controller.RegisterController;
import com.yash.training.springMVC.model.User;
import com.yash.training.springMVC.service.RegisterService;


@RunWith(MockitoJUnitRunner.class)
public class RegisterControllerTest {

	@InjectMocks
	private RegisterController registerController;

	@Mock
	private RegisterService registerService;

	private User user = new User();

	@Test
	public void shouldReturnModelAndViewObjectForRegistration(){

		ModelAndView actual = registerController.registerForm();

		assertEquals("register", actual.getViewName());
	}

	@Test
	public void shouldRegisterUser(){

		user.setFirstname("ew");
		user.setUsername("ww");
		user.setLastname("ee");
		user.setPassword("ew");

		Mockito.when(registerService.addUser(user)).thenReturn(1);

		ModelAndView actual = registerController.registerUser(user);
		System.out.println(actual.getModel());
		Mockito.verify(registerService).addUser(user);

		assertEquals("login", actual.getViewName());
		assertEquals("registration successful", actual.getModel().get("msg"));
	}
}
