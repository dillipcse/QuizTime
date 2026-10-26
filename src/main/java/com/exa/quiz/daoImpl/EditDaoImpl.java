package com.exa.quiz.daoImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.exa.quiz.dao.EditDao;
import com.exa.quiz.model.QuestionBank;
@Repository
public class EditDaoImpl implements EditDao{
	@PersistenceContext
	private EntityManager em;

	@Override
	public List<QuestionBank> getedits(int qid) {
	
		return (List<QuestionBank>) em.createQuery(
				"select q from QuestionBank q where q.qid=:qid", QuestionBank.class).setParameter(
				"qid", qid).getResultList();
	}
}
