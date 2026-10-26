package com.exa.quiz.daoImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.exa.quiz.dao.QuestionBankDao;
import com.exa.quiz.model.QuestionBank;

import com.exa.quiz.model.User;
@Repository
public class QuestionBankDaoImpl implements QuestionBankDao {
	@PersistenceContext
	private EntityManager em;
	@Override
	public List<QuestionBank> showGeneralMcq(String techId,String status) {
		return (List<QuestionBank>) em.createQuery(
				"select q from QuestionBank q where q.techId=:techId and q.status=:status ORDER BY q.qid DESC", QuestionBank.class).setParameter(
				"techId", techId).setParameter("status", status).getResultList();
	}
	@Override
	public List<QuestionBank> showJavaq(String techId,String status) {
		return (List<QuestionBank>) em.createQuery(
				"select q from QuestionBank q where q.techId=:techId and q.status=:status ORDER BY q.qid DESC", QuestionBank.class).setParameter(
				"techId", techId).setParameter("status", status).getResultList();
	}
	@Override
	public List<QuestionBank> showJavaScriptq(String techId,String status) {
		return (List<QuestionBank>) em.createQuery(
				"select q from QuestionBank q where q.techId=:techId and q.status=:status ORDER BY q.qid DESC", QuestionBank.class).setParameter(
				"techId", techId).setParameter("status", status).getResultList();
	}
	@Override
	public List<QuestionBank> showSapui5q(String techId,String status) {
		return (List<QuestionBank>) em.createQuery(
				"select q from QuestionBank q where q.techId=:techId and q.status=:status ORDER BY q.qid DESC", QuestionBank.class).setParameter(
				"techId", techId).setParameter("status", status).getResultList();
	}
	@Override
	public List<QuestionBank> showAptitudeq(String techId,String status) {
		return (List<QuestionBank>) em.createQuery(
				"select q from QuestionBank q where q.techId=:techId and q.status=:status ORDER BY q.qid DESC", QuestionBank.class).setParameter(
				"techId", techId).setParameter("status", status).getResultList();
	}
	@Override
	public List<QuestionBank> showtrash(String status) {
		return (List<QuestionBank>) em.createQuery(
				"select q from QuestionBank q where q.status=:status", QuestionBank.class).setParameter("status", status)
				.getResultList();
	}
}
