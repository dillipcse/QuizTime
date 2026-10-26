package com.exa.quiz.daoImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.exa.quiz.dao.EditQueDao;
import com.exa.quiz.model.QuestionBank;

@Repository
public class EditQueDaoImpl implements EditQueDao {
	@PersistenceContext
	private EntityManager em;

	@Override
	@Transactional
	public List<QuestionBank> editque(int qid) {
		return (List<QuestionBank>) em.createQuery("select q from QuestionBank q where q.qid=:qid", QuestionBank.class)
				.setParameter("qid", qid).getResultList();

	}

	@Override
	@Transactional
	public void updateque(String techId, String compId, String question, String optionA, String optionB, String optionC,
			String optionD, String qkey,int qid) {
		Query q = em
				.createQuery(
						"update QuestionBank q set q.techId=:techId,q.compId=:compId,q.question=:question,q.optionA=:optionA,q.optionB=:optionB,q.optionC=:optionC,q.optionD=:optionD,q.qkey=:qkey where q.qid=:qid",
						QuestionBank.class)
				.setParameter("techId", techId).setParameter("compId", compId).setParameter("question", question)
				.setParameter("optionA", optionA).setParameter("optionB", optionB).setParameter("optionC", optionC).setParameter("optionD", optionD).setParameter("qkey", qkey).setParameter("qid", qid);
		q.executeUpdate();

	}

}
