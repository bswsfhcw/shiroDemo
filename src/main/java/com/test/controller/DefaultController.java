package com.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DefaultController {
	
	@RequestMapping("/")
	public ModelAndView index() {
		ModelAndView model = new ModelAndView("index");
		String msg = "";
		model.addObject("message", msg);
		System.out.println("½øÈëµÇÂ¼Ò³Ãæ");
		return model;
	}
}