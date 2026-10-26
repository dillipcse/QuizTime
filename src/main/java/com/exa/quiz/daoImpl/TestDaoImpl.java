package com.exa.quiz.daoImpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.eclipse.persistence.sessions.Session;
import org.eclipse.persistence.sessions.factories.SessionFactory;
import org.springframework.stereotype.Repository;
import com.exa.quiz.dao.TestDao;
import com.exa.quiz.form.AddQuestionForm;
import com.exa.quiz.model.QuestionBank;

@SuppressWarnings("unused")
@Repository("testDao")
public class TestDaoImpl implements TestDao {
	@PersistenceContext
	private EntityManager em;
	@Override
	public List<QuestionBank> getquestionkeys(String techId) {

		return (List<QuestionBank>) em
				.createQuery("select q.qkey from QuestionBank q   where q.techId=:techId ", QuestionBank.class)
				.setMaxResults(10).setParameter("techId", techId).getResultList();
	}

	@Override
	public List<QuestionBank> getallkeys() {

		return em.createQuery("Select q from QuestionBank q ", QuestionBank.class).setMaxResults(10).getResultList();
		// Select q.qkey from QuestionBank q
	}

	@Override
	public List<QuestionBank> getquestions(String techId, String compId) {
		return (List<QuestionBank>) em
				.createQuery("select q from QuestionBank q  where q.techId=:techId and q.compId=:compId order by function('RAND')", QuestionBank.class)
				.setMaxResults(10).setParameter("techId", techId).setParameter("compId", compId).getResultList();
	}

}
