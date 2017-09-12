package com.cgm.twitter.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.cgm.twitter.db.repository.contract.UserDataStore;
import com.cgm.twitter.domain.User;
import com.cgm.twitter.dto.ServiceResponse;
import com.cgm.twitter.repository.UserDAO;

@RestController
public class UsersController {

	@Autowired
	UserDAO userDAO;

	@Autowired
	UserDataStore userDataStore; 

	public final static Logger logger = LoggerFactory.getLogger(UsersController.class);

	@RequestMapping(value = "/adduser", method = RequestMethod.GET, produces = "application/json")
	public ModelAndView getUser() throws Exception {
		logger.info("Called get service!");
		return new ModelAndView("/adduser");
	}

	@RequestMapping(value = "/adduser", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public @ResponseBody User createUser(@RequestBody User userToAdd, Model model) {
		logger.info("Called create User JPA service!");
		logger.info("introducem in baza de date");

		userDAO.save(userToAdd);
		return userToAdd;
	}

	@RequestMapping(value = "/users", method = RequestMethod.GET, produces = "application/json")
	public ModelAndView showUsers() throws Exception {
		logger.info("Called get service!");
		// userDAO.findAll();
		return new ModelAndView("/users", "usersList", userDAO.findAll());
	}

	@RequestMapping(value = "/finduser/{user}", method = RequestMethod.GET)
	public User findUser(@PathVariable("user") String finding, Model model) {
		User userToFind = userDAO.findByName(finding);
		if (userToFind != null) {
			return userToFind;
		}
		return null;
	}
	
	@RequestMapping(value = "/adduser", method = RequestMethod.DELETE)
	public ServiceResponse deleteUser(@PathVariable Long id) {
		logger.info("Called delete USER with id (" + id + ")!");
		userDAO.delete(id);
		return new ServiceResponse();
	}
	
}
