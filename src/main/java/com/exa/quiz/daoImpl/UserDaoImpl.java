package com.exa.quiz.daoImpl;



import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.exa.quiz.dao.UserDao;
import com.exa.quiz.model.User;

@Repository("userDao")
public class UserDaoImpl implements UserDao {
	@PersistenceContext
	private EntityManager em;
	@Override
	public List<User> getUseremail(String email) {

		return (List<User>) em.createQuery(
				"select u from User u where u.email=:email", User.class).setParameter(
				"email", email).getResultList();
	}

	@Override
	public void saveregister(User user) {
		em.persist(user);
		System.out.println("success");

	}

}
