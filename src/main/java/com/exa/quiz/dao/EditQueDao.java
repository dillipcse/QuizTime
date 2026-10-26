package com.exa.quiz.dao;

import java.util.List;

import com.exa.quiz.model.QuestionBank;

public interface EditQueDao {

	public List<QuestionBank> editque(int qid);

	public void updateque(String techId, String compId, String question, String optionA, String optionB, String optionC,
			String optionD, String qkey,int qid);
}
