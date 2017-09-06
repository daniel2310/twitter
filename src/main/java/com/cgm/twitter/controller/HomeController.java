package com.cgm.twitter.controller;



import java.util.ArrayList;
import java.util.Map;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.servlet.ModelAndView;


/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
		
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home() {
		ModelAndView mav = new ModelAndView("/home");
		return mav;
	}
		
		
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView friendsMessage() {
		ModelAndView mav = new ModelAndView("/home");

		for (Map.Entry<String, ArrayList<Message>> entry : UserBuilder.messages.entrySet()) {
		    System.out.println(entry.getKey() + ":" + entry.getValue().toString());
		}
		mav.addObject("allMessages", UserBuilder.messages);
		
		return mav;

	}
/*
	@RequestMapping(value = {"/home", ""})
	public String viewStats(Map<String, Object> model) {
	    return "home";
	}
	
*/
}