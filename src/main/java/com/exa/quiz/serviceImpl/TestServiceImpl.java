package com.exa.quiz.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exa.quiz.dao.TestDao;
import com.exa.quiz.form.AddQuestionForm;
import com.exa.quiz.model.QuestionBank;
import com.exa.quiz.service.TestService;

@Service
public class TestServiceImpl implements TestService {
	@Autowired
	private TestDao testDao;

	@Override
	public List<QuestionBank> getquestionkeys(String techId) {

		return testDao.getquestionkeys(techId);
	}

	@Override
	public List<QuestionBank> getallkeys() {

		return testDao.getallkeys();
	}

	@Override
	public List<QuestionBank> getquestions(String techId, String levelId) {

		return testDao.getquestions(techId, levelId);
	}
}
