package com.exa.quiz.daoImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.exa.quiz.dao.SaveResultDao;
import com.exa.quiz.model.Admin;
import com.exa.quiz.model.Quiz;
import com.exa.quiz.model.Recruiter;
import com.exa.quiz.model.Result;

@Repository
public class SaveResultDaoImpl implements SaveResultDao {
	@PersistenceContext
	private EntityManager em;

	@Transactional
	@Override
	public void saveresult(Quiz quiz) {
		em.persist(quiz);
	}

	@Override
	public List<Quiz> getQuizKeys(String sessionId) {

		return em.createQuery("Select q.ukey from Quiz q where q.sessionId=:sessionId, ", Quiz.class)
				.setParameter("sessionId", sessionId).getResultList();
	}

	@Transactional
	@Override
	public void insertresult(Result result) {
		em.persist(result);

	}

	@Override
	public List<Admin> getadmin() {
		
		return em.createQuery("Select q from Admin q", Admin.class)
			.getResultList();
	}
	@Override
	public List<Recruiter> getrec() {
		
		return em.createQuery("Select q.rec_mail from Recruiter q", Recruiter.class)
			.getResultList();
	}
}
