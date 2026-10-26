package com.exa.quiz.serviceImpl;

//import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/*import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;*/

import com.exa.quiz.dao.QuestionsDao;
import com.exa.quiz.model.QuestionBank;

import com.exa.quiz.service.QuestionsService;

@Service
//@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class QuestionsServiceImpl implements QuestionsService {

	@Autowired
	private QuestionsDao questionsDao;
	 
	@Override
	public void saveQuestions(QuestionBank questionbank) {
		questionsDao.saveQuestions(questionbank);
	} 
}