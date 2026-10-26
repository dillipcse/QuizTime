package com.exa.quiz.daoImpl;

import java.util.List;

import javax.jdo.annotations.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.exa.quiz.dao.AdminDao;
import com.exa.quiz.model.Admin;
import com.exa.quiz.model.Recruiter;

@Repository("adminDao")
public class AdminDaoImpl implements AdminDao {

	@PersistenceContext
	private EntityManager em;
	@SuppressWarnings("unchecked")
	@Override
	public List<Admin> validateLoginAdmin(String adminEmail, String password) {
		return em.createQuery("select a from Admin a where a.adminEmail=:adminEmail and a.password=:password", Admin.class)
				.setParameter("adminEmail", adminEmail).setParameter("password", password).getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Admin> getAdminByAdminEmail(String adminEmail) {
		return (List<Admin>) em.createQuery(
				"select a from Admin a where a.adminEmail=:adminEmail", Admin.class).setParameter(
				"adminEmail", adminEmail).getResultList();
	}

	@Override
	public void saveRecruiter(Recruiter recruiter) {
		em.persist(recruiter);	
	}

}
