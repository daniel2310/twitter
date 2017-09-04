package com.cgm.twitter;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FriendsController {

	/*
	 * @RequestMapping(value = "/friends", method = RequestMethod.GET) public
	 * ModelAndView showFriends(HttpServletRequest request, HttpServletResponse
	 * response) { ModelAndView mav = new ModelAndView("friends");
	 * mav.addObject("user", new User()); return mav; }
	 */

	@RequestMapping(value = "/friends", method = RequestMethod.GET)
	public String showFriends(ModelMap model, HttpServletRequest request) {
			
			model.addAttribute("friends", UserBuilder.friends.get(request.getSession().getAttribute("username")));
			
			return "friends";
			
		}
}
