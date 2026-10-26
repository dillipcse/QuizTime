package com.exa.quiz.dao;

import java.util.List;

import com.exa.quiz.form.AddQuestionForm;
import com.exa.quiz.model.QuestionBank;

public interface TestDao {
	public List<QuestionBank> getquestions(String techId,String levelId);
	public List<QuestionBank>  getallkeys();
	List<QuestionBank> getquestionkeys(String techId);
}
