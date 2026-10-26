package com.exa.quiz.service;

import java.util.List;


import com.exa.quiz.model.QuestionBank;
import com.exa.quiz.model.Quiz;
import com.exa.quiz.model.Result;
import com.exa.quiz.model.User;

public interface ParticipantResultService {

	public List<Result> getUser(String date);
	public List<QuestionBank> getTotalNumberOfQuestionBank();
	public List<Quiz> getquizdetails(String sessionId);
	public List<Result> getUserById(String sessionId);

	
}
