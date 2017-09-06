package com.cgm.twitter.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SuccessController {
	@RequestMapping(value = {"/success", ""})
	public String viewStats(Map<String, Object> model) {
	    return "success";
	}
}
