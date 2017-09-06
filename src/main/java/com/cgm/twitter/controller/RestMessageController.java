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
	
	@RestController
	public class MessageController {
		@RequestMapping(value = "/message", method = RequestMethod.PUT, 
				consumes = "application/json", produces = "application/json")
		public @ResponseBody Message message(@RequestBody Message message, HttpServletRequest request) {
			UserBuilder.messages.get(request.getSession().getAttribute("username").toString()).add(message);
			return message;
		}

	}

	@RequestMapping(value = "/readmessages", method = RequestMethod.GET)
	public @ResponseBody ModelAndView getMessage(HttpServletRequest request) {
		ModelAndView model = new ModelAndView("/readmessages");
		model.addObject("messageList", UserBuilder.messages.get(request.getSession().getAttribute("username").toString()));
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

	
	/*
	 * @RequestMapping(value = "/message", method = RequestMethod.PUT)
	 * public @ResponseBody ServiceResponse createMessage(HttpServletRequest
	 * request, @ModelAttribute("message") Message message) {
	 * 
	 * if (message.getContent().length() < 2) { new
	 * Message(request.getSession().getAttribute("username").toString(),
	 * message.getContent()); } else { return new
	 * ServiceResponse("Please insert a longer message"); } return new
	 * ServiceResponse("Message posted: " + message.getContent()); }
	 * 
	 * @RequestMapping(value = "/message", method = RequestMethod.GET)
	 * public @ResponseBody ModelAndView getMessage() { ModelAndView model = new
	 * ModelAndView("/message"); model.addObject("messageList",
	 * UserBuilder.messages);
	 * 
	 * return model;
	 * 
	 * }
	 * 
	 */
}
