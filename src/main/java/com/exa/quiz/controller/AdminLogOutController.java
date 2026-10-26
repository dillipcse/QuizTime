package com.exa.quiz.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/adminlogout")
public class AdminLogOutController {
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView adminLogOut(Map model, HttpSession session){
		System.out.println("padma");
		session.invalidate();
		return new ModelAndView("redirect:index.jsp");
	}
}
