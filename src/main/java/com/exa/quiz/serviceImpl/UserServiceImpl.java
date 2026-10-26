package com.exa.quiz.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.exa.quiz.dao.UserDao;
import com.exa.quiz.model.User;
import com.exa.quiz.service.UserService;
@Service
//@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class UserServiceImpl implements UserService{
	@Autowired
    private UserDao userDao;
	@Override
	@Transactional
	public void saveregister(User user) {
		System.out.println("seerviceimp");
	userDao.saveregister(user);
		
	}
	@Override
	public List<User> getUseremail(String email) {
		return userDao.getUseremail(email);
	}

}
