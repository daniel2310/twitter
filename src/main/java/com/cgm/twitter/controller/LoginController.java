package com.cgm.twitter.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

	@RequestMapping(value = { "/login", "" })
	public String viewStats(Map<String, Object> model) {
		return "login";
	}

	@RequestMapping(value = "/success", method = RequestMethod.GET)
	public ModelAndView showRegister(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("login");
		mav.addObject("user", new User());
		return mav;
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String submit(Model model, HttpServletRequest request, @ModelAttribute("login") User user) {

		for (User newUser : UserBuilder.users) {
			if (user != null && user.getName() != null && user.getPassword() != null) {
				if (user.getName().equals(newUser.getName()) && user.getPassword().equals(newUser.getPassword())) {
					model.addAttribute("msg", "welcome" + user.getName());
					request.getSession().setAttribute("username", user.getName());
					return "success";
				}
				model.addAttribute("error", "Invalid Username or Password");
				}
			}
		
		return "login";
	}
}
