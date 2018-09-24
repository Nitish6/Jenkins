package com.yash.training.springMVC.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.yash.training.springMVC.model.Login;

@Controller

public class HomeController {

	String msg = "home controller";

	@RequestMapping("/display")
	public ModelAndView displayName() {

		ModelAndView mv = new ModelAndView("login", "msg", msg);
		mv.addObject("login", new Login());
		return mv; 
	}
	

	@RequestMapping("/")
	public String displayWelcome() {

		ModelAndView mv = new ModelAndView("login", "msg", msg);
		mv.addObject("login", new Login());
		return "Homw"; 
	}

}
