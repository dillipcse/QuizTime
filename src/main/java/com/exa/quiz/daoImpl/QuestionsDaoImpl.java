package com.exa.quiz.daoImpl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.exa.quiz.dao.QuestionsDao;
import com.exa.quiz.model.QuestionBank;
@Repository
public class QuestionsDaoImpl implements QuestionsDao {
	@PersistenceContext
	private EntityManager em;
	@Transactional
	@Override
	public void saveQuestions(QuestionBank questionbank) {
		em.persist(questionbank);
	}
}
