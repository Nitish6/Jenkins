package com.training.springMVC.controller;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import com.yash.training.springMVC.controller.HomeController;

public class HomeControllerTest {

	HomeController homeController = new HomeController();
	
	@Test
	public void shouldReturnModelAndViewObject(){
		
		ModelAndView actual = homeController.displayName();
		
		Assert.assertEquals("login", actual.getViewName());

	}
}
