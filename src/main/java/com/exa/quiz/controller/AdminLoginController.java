package com.exa.quiz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.exa.quiz.model.Admin;
import com.exa.quiz.service.AdminService;
import com.exa.quiz.validators.AdminLoginValidator;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/adminlogin")
public class AdminLoginController {
	
	 @Autowired private 
	 AdminLoginValidator adminLoginValidator;
	 
	@Autowired
	private AdminService adminService;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView showAdminLogin(Map model, HttpSession session) {
		if (session.getAttribute("adminEmail") == null) {
			Admin admin = new Admin();
			model.put("admin", admin);
			return new ModelAndView("/adminlogin");
		} else {
			return new ModelAndView("redirect:adminview.htm");
		}
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView processAdminLogin(@Valid Admin admin, BindingResult result, @SuppressWarnings("rawtypes") Map model,
			HttpSession session) {
		adminLoginValidator.validate(admin, result);
		if (result.hasErrors()) { 
			return new ModelAndView("/adminlogin"); 
			}
		@SuppressWarnings("rawtypes")
		List adminlist = adminService.getAdminByAdminEmail(admin.getAdminEmail());
		Admin admin1 = null;
		String email = null;
		if (adminlist != null && adminlist.size() > 0) {
			admin1 = new Admin();
			admin1 = (Admin) adminlist.get(0);
			email = admin1.getAdminEmail();
			session.setAttribute("adminName", admin1.getAdminName());
			if (email.equals(admin.getAdminEmail())) {
				session.setAttribute("adminEmail", admin.getAdminEmail());
				return new ModelAndView("redirect:/adminview.htm");
			}
		}
		return new ModelAndView("redirect:/adminlogin.htm");
	}
}
