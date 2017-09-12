package com.cgm.twitter.controller;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.cgm.twitter.db.repository.contract.UserDataStore;
import com.cgm.twitter.domain.Message;
import com.cgm.twitter.repository.MessagesDAO;
import com.cgm.twitter.repository.UserDAO;

@RestController
public class RestMessageController {

	@SuppressWarnings("rawtypes")
	@Autowired
	MessagesDAO messageDAO;

	@Autowired
	UserDAO userDAO;

	@Autowired
	UserDataStore userDataStore;

	public final static Logger logger = LoggerFactory.getLogger(RestMessageController.class);

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/message", method = RequestMethod.PUT, consumes = "application/json", produces = "application/json")
	public @ResponseBody Message addMessage(@RequestBody Message messageToAdd, HttpServletRequest request,
			Model model) {

		logger.info("Called send message JPA service!");
		// test username=?
		String username = request.getSession().getAttribute("username").toString();
		logger.info("username: " + request.getSession().getAttribute("username").toString());

		if (messageToAdd.getContent().length() > 3) {
			messageToAdd.setUser(userDAO.findByName(username));
			messageDAO.update(messageToAdd);
		}
		return messageToAdd;
	}

	@RequestMapping(value = "/readmessages", method = RequestMethod.GET)
	public @ResponseBody ModelAndView getMessage(HttpServletRequest request) {
		ModelAndView model = new ModelAndView("/readmessages");
		model.addObject("messageList", messageDAO.findAll());
		return model;

	}

	@RequestMapping(value = "/sendmessages", method = RequestMethod.GET)
	public @ResponseBody ModelAndView sendMessage(HttpServletRequest request) {

		ModelAndView model = new ModelAndView("/sendmessages");
		return model;
	}
}
