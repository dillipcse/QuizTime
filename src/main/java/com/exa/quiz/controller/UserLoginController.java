package com.exa.quiz.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.exa.quiz.form.UserForm;
import com.exa.quiz.model.User;
import com.exa.quiz.service.UserService;
import com.exa.quiz.validators.UserLoginValidators;

@Controller
@RequestMapping("/register")
public class UserLoginController {
	@Autowired
	private UserService userService;
	@Autowired
	UserLoginValidators userLoginValidators;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView showregisterpage(User user1, HttpSession session) {
		return new ModelAndView("/register", "userForm", new UserForm());
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView insertuser(@Valid UserForm userForm, BindingResult result, HttpServletRequest request,
			HttpSession session) {
		String date = "yyyy-MM-dd";
		
		//String date ="dd/MM/yyyy";
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat dateFormat = new SimpleDateFormat(date);
		//System.out.println("Today Date = " + dateFormat.format(calendar.getTime()));
		String todaydate = dateFormat.format(calendar.getTime());


		userLoginValidators.validate(userForm, result);
		if (result.hasErrors()) {
			return new ModelAndView("/register");
		}
		User user = new User();
		UserForm uForm = (UserForm) userForm;
		@SuppressWarnings("rawtypes")
		List userList = userService.getUseremail(uForm.getEmail());
		if (userList != null && userList.size() > 0) {
			user = (User) userList.get(0);
			String email = user.getEmail();
			if (email.equals(user.getEmail())) {
				return new ModelAndView("redirect:/register.htm");
			}
		}
		user.setName(uForm.getName());
		user.setEmail(uForm.getEmail());
		user.setMobile(uForm.getMobile());
		user.setDate(dateFormat.format(calendar.getTime()));
		// System.out.println(uForm.getName());
		userService.saveregister(user);
		// System.out.println("saved");
		session.setAttribute("name", uForm.getName());
		session.setAttribute("userid", uForm.getEmail());
		session.setAttribute("mobile", uForm.getMobile());
		session.setAttribute("date", todaydate);
		return new ModelAndView("/instructions");
	}
}
