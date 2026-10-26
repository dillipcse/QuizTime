package com.exa.quiz.daoImpl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.exa.quiz.dao.DeleteDao;
import com.exa.quiz.model.QuestionBank;


@Repository("deleteDao")
public class DeleteDaoImpl implements DeleteDao {
	@PersistenceContext
	private EntityManager em;

	@Override
	@Transactional
	public void deleteque(int qid) {
		Query q = em.createQuery("delete from QuestionBank q WHERE q.qid=:qid", QuestionBank.class).setParameter("qid",
				qid);
		q.executeUpdate();
	}

	@Override
	@Transactional
	public void updatestatus(String question, String status) {
		System.out.println("padma");
		Query q = em.createQuery("update QuestionBank q set q.status=:status where q.question=:question",
				QuestionBank.class).setParameter("question", question).setParameter("status", status);
		q.executeUpdate();

	}

	@Override
	@Transactional
	public void updateStatusToActive(String question, String status) {
		System.out.println("padma123");
		Query q = em.createQuery("update QuestionBank q set q.status=:status where q.question=:question",
				QuestionBank.class).setParameter("question", question).setParameter("status", status);
		q.executeUpdate();
		
	}

	
}
