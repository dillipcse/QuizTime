package com.exa.quiz.dao;

import java.util.List;

import com.exa.quiz.model.QuestionBank;
import com.exa.quiz.model.Result;
import com.exa.quiz.model.User;

public interface ParticipantHistoryDao {

	
	public List<QuestionBank> getTotalNumberOfQuestionBank();

	List<Result> gethistorybydate(String fromdate, String todate);

}
