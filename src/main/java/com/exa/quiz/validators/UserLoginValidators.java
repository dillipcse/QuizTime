package com.exa.quiz.validators;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

import com.exa.quiz.form.UserForm;
import com.exa.quiz.model.User;
import com.exa.quiz.service.UserService;

@Component
public class UserLoginValidators {
	@Autowired
	private UserService userService;

	public boolean supports(Class<?> clazz) {
		return User.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors errors) {
		System.out.println("Mangal");
		UserForm user = (UserForm) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name",
				"NotEmpty.user.password", "User Name must not be Empty.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email",
				"NotEmpty.user.userEmail", "User Email must not be Empty.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "mobile",
				"NotEmpty.user.password", "Mobile Number must not be Empty."); 
		if ((user.getEmail() != null) && (user.getEmail().length() > 0)) {
			user.setEmail(user.getEmail().trim());
			List userlist = userService.getUseremail(user.getEmail());
			System.out.println(userlist);
			if ((userlist != null) && (userlist.size() > 0)) {
				System.out.println("manty");
				errors.rejectValue("email", "notMatchEmailAndPassword.user.userEmail",
						"You have already attended the test.");
				
			} else {
				System.out.println("dfddd");
			}
		}
	}
}
