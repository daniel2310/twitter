package com.cgm.twitter;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class LogoutController {
	
	@RequestMapping(value = {"/logout", ""})
	public String logout(Locale locale, HttpServletRequest request, Model model) {
		request.getSession().removeAttribute("username");
		return "home";

	}
}
