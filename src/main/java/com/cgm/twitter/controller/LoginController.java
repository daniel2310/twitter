package com.cgm.twitter.controller;

import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.cgm.twitter.db.repository.contract.UserDataStore;
import com.cgm.twitter.domain.User;
import com.cgm.twitter.repository.UserDAO;

@Controller
public class LoginController {
	@Autowired
	UserDAO userDAO;

	@Autowired
	UserDataStore userDataStore;

	public final static Logger logger = LoggerFactory.getLogger(LoginController.class);

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginUser(@ModelAttribute("login") User user, HttpServletRequest request, Model model) {
		logger.info("Called login User JPA service!");

		if (user.getName() == null && user.getPassword() == null) {
			model.addAttribute("error", "Please insert a valid username and password!");
		} else {
			if (user.getName() != null && user.getPassword() != null && userDAO.findByName(user.getName()) != null) {
				if (user.getPassword().equals(userDAO.findByName(user.getName()).getPassword())) {
					model.addAttribute("msg", "welcome" + user.getName());
					request.getSession().setAttribute("username", user.getName());
					request.getSession().setAttribute("user_id", userDAO.findByName(user.getName()).getUser_id());
					return "success";
				}
				model.addAttribute("error", "Invalid Username or Password");
				return "login";
			}
			model.addAttribute("error", "Invalid Username or Password");
			return "login";

		}
		return "login";
	}
}
