package com.cgm.twitter.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class RestMessageController {

	@RequestMapping(value = "/message", method = RequestMethod.PUT, consumes = "application/json", produces = "application/json")

	public @ResponseBody Message addMessage(@RequestBody Message message, HttpServletRequest request) {
		UserBuilder.messages.get(request.getSession().getAttribute("username").toString()).add(message);
		return message;
	}

	@RequestMapping(value = "/readmessages", method = RequestMethod.GET)
	public @ResponseBody ModelAndView getMessage(HttpServletRequest request) {
		ModelAndView model = new ModelAndView("/readmessages");
		model.addObject("messageList",
				UserBuilder.messages.get(request.getSession().getAttribute("username").toString()));
		return model;

	}

	@RequestMapping(value = "/sendmessages", method = RequestMethod.GET)
	public @ResponseBody ModelAndView sendMessage(HttpServletRequest request) {
		ModelAndView model = new ModelAndView("/sendmessages");
		return model;

	}

	@RequestMapping(value = "/allmessages", method = RequestMethod.GET)
	public @ResponseBody ModelAndView showAllMessages(HttpServletRequest request) {
		ModelAndView model = new ModelAndView("/home");

		for (Map.Entry<String, ArrayList<Message>> entry : UserBuilder.messages.entrySet()) {
			System.out.println(entry.getKey() + ":" + entry.getValue());
		}
		model.addObject("allMessages", UserBuilder.messages);
		return model;
	}

}
