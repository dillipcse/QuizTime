package com.exa.quiz.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.exa.quiz.form.RecruiterForm;
import com.exa.quiz.form.UserForm;
import com.exa.quiz.model.Recruiter;
import com.exa.quiz.service.AdminService;

@Controller
@RequestMapping("/recruiter")
public class RecruiterController {
	@Autowired
	private AdminService adminService;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView recruiterview() {
		System.out.println("hello rec");
		return new ModelAndView("/addrecruiter", "recruiterForm", new Recruiter());
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView addrecruiter(@Valid RecruiterForm recruiterForm, BindingResult result,
			HttpServletRequest request, HttpSession session) {
		Recruiter recruiter = new Recruiter();
		recruiterForm = (RecruiterForm) recruiterForm;
		recruiter.setRec_name(recruiterForm.getRec_name());
		recruiter.setRec_mail(recruiterForm.getRec_mail());
		adminService.saveRecruiter(recruiter);
		ModelAndView mav =new ModelAndView();
	
		mav.addObject("m", 1);
		/*mav.addObject("d", 1);*/
		
		mav.setViewName("/adminview");
		return mav;
		//return new ModelAndView("/adminview","d",1);
	}
}
