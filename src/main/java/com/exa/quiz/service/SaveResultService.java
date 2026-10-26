package com.exa.quiz.service;

import java.util.List;

import com.exa.quiz.model.Admin;
import com.exa.quiz.model.Quiz;
import com.exa.quiz.model.Recruiter;
import com.exa.quiz.model.Result;

public interface SaveResultService {
	public void saveresult(Quiz quiz);
	public List<Quiz> getQuizKeys(String sessionId);
	public void insertresult(Result result);
	public List<Admin> getadmin();
	public List<Recruiter> getrec();
}
