package com.cgm.twitter.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cgm.twitter.domain.User;
import com.cgm.twitter.repository.UserDAO;

@Controller
public class FriendsController {
	@Autowired
	UserDAO userDAO;

	@RequestMapping(value = "/friends", method = RequestMethod.GET)
	public ModelAndView showFriends(Model model, HttpServletRequest request) {
		User loggedUser = userDAO.findById((Long) request.getSession().getAttribute("user_id"));
		model.addAttribute("friends", loggedUser.getFriends());
		return new ModelAndView("friends", model.asMap());
	}

	@RequestMapping(value = "/addfriend", method = RequestMethod.GET)
	public ModelAndView myFriends(Model model) {
		model.addAttribute("addfriend", new User());
		return new ModelAndView("addfriend", model.asMap());
	}

	@RequestMapping(value = "/removefriend", method = RequestMethod.GET)
	public ModelAndView removeFriend(Model model) {
		model.addAttribute("removefriend", new User());
		return new ModelAndView("removefriend", model.asMap());
	}

	@RequestMapping(value = "/removefriend", method = RequestMethod.POST)
	public ModelAndView removeFriend(Model model, @ModelAttribute("removefriend") User user,
			HttpServletRequest request) {
		Long idToAdd = (Long) request.getSession().getAttribute("user_id");
		User currentUser = userDAO.findById(idToAdd);
		User removedFriend = userDAO.findByName(user.getName());
		if (removedFriend != null) {
			currentUser.removeFriend(removedFriend);
		}
		userDAO.update(currentUser);
		return new ModelAndView("redirect:/friends", model.asMap());
	}

	@RequestMapping(value = "/addfriend", method = RequestMethod.POST)
	public ModelAndView addFriend(Model model, @ModelAttribute("addfriend") User user, HttpServletRequest request) {
		Long idToAdd = (Long) request.getSession().getAttribute("user_id");
		System.out.println("orice");
		System.out.println("idToAdd " + idToAdd);
		User currentUser = userDAO.findById(idToAdd);
		System.out.println("orice2");
		User newFriend = userDAO.findByName(user.getName());
		System.out.println("orice3");
		System.out.println("newFriend name " + newFriend.getName());
		if (newFriend != null) {
			currentUser.addFriend(newFriend);
		}
		userDAO.update(currentUser);
		return new ModelAndView("redirect:/friends", model.asMap());

	}

}
