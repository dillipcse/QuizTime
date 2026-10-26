package com.exa.quiz.dao;

import java.util.List;

import com.exa.quiz.model.User;

public interface UserDao {
	public List<User> getUseremail(String email);

	public void saveregister(User user);
}
