package com.exa.quiz.validators;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import com.exa.quiz.model.Admin;
import com.exa.quiz.service.AdminService;


@Component("adminLoginValidator")
public class AdminLoginValidator {
	@Autowired
	private AdminService adminService;
	
	public boolean supports(Class<?> klass) {
		   return Admin.class.isAssignableFrom(klass);
	  }
	
	public void validate(Object target, Errors errors){
		Admin admin = (Admin) target;
		if ((admin.getAdminEmail() != null) && (admin.getAdminEmail().length() > 0)){
			admin.setAdminEmail(admin.getAdminEmail().trim());
			List adminlist = adminService.validateLoginAdmin(admin.getAdminEmail(),admin.getPassword());
			System.out.println(adminlist);
			System.out.println(adminlist.size());
			if ((adminlist != null) && (adminlist.size() > 0)) {
			  }else {
				errors.rejectValue("adminEmail","notMatchEmailAndPassword.admin.adminEmail","The email address that you've entered doesn't match any account.");
				errors.rejectValue("password","notMatchEmailAndPassword.admin.password","Password you entered is incorrect.");
			  }
		 }
    }
 }
