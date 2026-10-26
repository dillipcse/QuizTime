package com.exa.quiz.dao;

import java.util.List;

import com.exa.quiz.model.Admin;
import com.exa.quiz.model.QuestionBank;
import com.exa.quiz.model.Quiz;
import com.exa.quiz.model.Recruiter;
import com.exa.quiz.model.Result;

public interface SaveResultDao {
	public void saveresult(Quiz quiz);
	public void insertresult(Result result);
	public List<Quiz> getQuizKeys(String sessionId);
	public List<Admin> getadmin();
	public List<Recruiter> getrec();
}
