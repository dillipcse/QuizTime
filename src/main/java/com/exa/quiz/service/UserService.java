package com.exa.quiz.service;

import java.util.List;

import com.exa.quiz.model.User;

public interface UserService {
	public List<User> getUseremail(String email);

	public void saveregister(User user);
}
