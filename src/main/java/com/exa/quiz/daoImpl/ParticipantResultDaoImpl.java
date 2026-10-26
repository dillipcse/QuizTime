package com.exa.quiz.daoImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.exa.quiz.dao.ParticipantResultDao;
import com.exa.quiz.model.QuestionBank;
import com.exa.quiz.model.Quiz;
import com.exa.quiz.model.Result;
import com.exa.quiz.model.User;

@Repository("participantResultDao")
public class ParticipantResultDaoImpl implements ParticipantResultDao {
	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Result> getUser(String date) {
		System.out.println("datedao");
		return (List<Result>) em.createQuery(
				"select u from Result u where u.date=:date", Result.class).setParameter("date", date).getResultList();
	}
@Override
	public List<QuestionBank> getTotalNumberOfQuestionBank() {
		return (List<QuestionBank>) em.createQuery(
				"select q from QuestionBank q", QuestionBank.class).getResultList();
	}
@Override
public List<Quiz> getquizdetails(String sessionId) {
	return (List<Quiz>) em.createQuery(
			"select q from Quiz q where q.sessionId=:sessionId", Quiz.class).setParameter("sessionId", sessionId).getResultList();
}
@Override
public List<Result> getUserById(String sessionId) {
	
	return (List<Result>) em.createQuery(
			"select q from Result q where q.sessionId=:sessionId", Result.class).setParameter("sessionId", sessionId).getResultList();
}

	
}
