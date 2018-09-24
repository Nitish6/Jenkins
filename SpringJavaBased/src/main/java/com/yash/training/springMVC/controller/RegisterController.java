package com.yash.training.springMVC.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.yash.training.springMVC.model.Login;
import com.yash.training.springMVC.model.User;
import com.yash.training.springMVC.service.RegisterService;

@Controller
public class RegisterController {

	@Autowired
	RegisterService registerService;

	@RequestMapping("/registrationForm")
	public ModelAndView registerForm() {

		ModelAndView mv = new ModelAndView("register");
		mv.addObject("user", new User());

		return mv; 
	}

	@RequestMapping("/registerUser")
	public ModelAndView registerUser(@ModelAttribute("user") User user) {

		Integer userId = registerService.addUser(user);

		ModelAndView modelView  = new ModelAndView("login","msg", "registration successful");

		modelView.addObject("login", new Login());

		return modelView; 
	}
}
