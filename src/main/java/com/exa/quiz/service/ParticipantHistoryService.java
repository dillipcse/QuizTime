package com.exa.quiz.service;

import java.util.List;

import com.exa.quiz.model.QuestionBank;
import com.exa.quiz.model.Result;
import com.exa.quiz.model.User;

public interface ParticipantHistoryService {
	public List<Result> gethistory(String fromdate,String todate);
	public List<QuestionBank> getTotalNumberOfQuestionBank();

}
