package com.yash.training.springMVC.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.yash.training.springMVC.model.Login;
import com.yash.training.springMVC.model.User;
import com.yash.training.springMVC.service.LoginService;

@Controller
public class LoginController {

	@Autowired
	private LoginService loginService;

	@RequestMapping("/loginForm")
	public ModelAndView loginForm() {

		ModelAndView modelView = new ModelAndView("login","msg", "please login");
		modelView.addObject("login", new Login());

		return modelView;
	}


	@RequestMapping("/loginUser")
	public ModelAndView validateUser(@ModelAttribute ("login") Login login){

		ModelAndView modelView = null;

		User loginUser = loginService.validateUser(login);
		
		if((loginUser != null)){
			modelView = new ModelAndView("userDetails");
			modelView.addObject("user", loginUser);
		}
		else{
			modelView = new ModelAndView("login","msg", "Invalid credentials");
		}

		return modelView;
	}
}
