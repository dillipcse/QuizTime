package com.exa.quiz.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exa.quiz.dao.QuestionsDao;
import com.exa.quiz.dao.SaveResultDao;
import com.exa.quiz.model.Admin;
import com.exa.quiz.model.Quiz;
import com.exa.quiz.model.Recruiter;
import com.exa.quiz.model.Result;
import com.exa.quiz.service.SaveResultService;

@SuppressWarnings("unused")
@Service
public class SaveResultServiceImpl implements SaveResultService {
	@Autowired
	private SaveResultDao saveresultDao;

	@Override
	public void saveresult(Quiz quiz) {
		saveresultDao.saveresult(quiz);

	}

	@Override
	public List<Quiz> getQuizKeys(String sessionId) {

		return saveresultDao.getQuizKeys(sessionId);
	}

	@Override
	public void insertresult(Result result) {
		saveresultDao.insertresult(result);
	}

	@Override
	public List<Admin> getadmin() {

		return saveresultDao.getadmin();
	}

	@Override
	public List<Recruiter> getrec() {
		return saveresultDao.getrec();
	}
}
