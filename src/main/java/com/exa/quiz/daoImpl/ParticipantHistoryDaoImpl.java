package com.exa.quiz.daoImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.exa.quiz.dao.ParticipantHistoryDao;
import com.exa.quiz.model.QuestionBank;
import com.exa.quiz.model.Result;
import com.exa.quiz.model.User;

@Repository("participantHistoryDao")
public class ParticipantHistoryDaoImpl implements ParticipantHistoryDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<QuestionBank> getTotalNumberOfQuestionBank() {
		return (List<QuestionBank>) em.createQuery("select q from QuestionBank q", QuestionBank.class).getResultList();
	}
/*
	@Override
	public List<Result> gethistory(String date, String sessionId, long mobile) {
		System.out.println("hfgghgfhgh");
		System.out.println((List<Result>) em
				.createQuery(
						"select r from Result r where r.date=:date and r.sessionId=:sessionId and r.mobile=:mobile",
						Result.class)
				.setParameter("date", date).setParameter("sessionId", sessionId).setParameter("mobile", mobile)
				.getResultList());
		return (List<Result>) em
				.createQuery(
						"select r from Result r where r.date=:date and r.sessionId=:sessionId and r.mobile=:mobile",
						Result.class)
				.setParameter("date", date).setParameter("sessionId", sessionId).setParameter("mobile", mobile)
				.getResultList();
	}*/

	@Override
	public List<Result> gethistorybydate(String fromdate, String todate) {

		return (List<Result>) em
				.createQuery("select r from Result r where r.date between :fromdate and :todate", Result.class)
				.setParameter("fromdate", fromdate).setParameter("todate", todate).getResultList();
	} 
}
