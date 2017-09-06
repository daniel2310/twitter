package com.cgm.twitter.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


@RestController
public class UsersController {
	 
	
	//find user
	@RequestMapping(value = "/users",  method = RequestMethod.GET)
	public ModelAndView viewStats(Map<String, Object> model) {
	    return new ModelAndView("users");
	}
	
	@RequestMapping(value = "/finduser/{user}", method = RequestMethod.GET)
	public @ResponseBody Friends findUser(@PathVariable("user") String finding) {
					
		for (int count = 0; count < UserBuilder.users.size(); count++) {
			if (UserBuilder.users.get(count).getName().equals(finding))
				return new Friends("User: " + UserBuilder.users.get(count).getName() + " found!");
		} 
			return new Friends("User not found");
		}
	
	
	//add user
	
	@RequestMapping(value = {"/adduser", ""})
	public @ResponseBody ModelAndView addNewUser() {
		ModelAndView model = new ModelAndView("/adduser");
	    return model;
	}
		
	@RequestMapping(value = "/adduser", method = RequestMethod.POST)
	public @ResponseBody User submit(Model model, @RequestBody User userToAdd) {
		UserBuilder.users.add(userToAdd);
		return userToAdd;
	}
	
	
	
	
}


		
		




