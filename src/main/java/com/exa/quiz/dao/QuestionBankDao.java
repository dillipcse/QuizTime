package com.exa.quiz.dao;

import java.util.List;

import com.exa.quiz.model.QuestionBank;


public interface QuestionBankDao {
	public List<QuestionBank> showGeneralMcq(String techId,String status);
	public List<QuestionBank> showJavaq(String techId,String status);
	public List<QuestionBank> showJavaScriptq(String techId,String status);
	public List<QuestionBank> showSapui5q(String techId,String status);
	public List<QuestionBank> showAptitudeq(String techId,String status);
	public List<QuestionBank> showtrash(String status);

}
