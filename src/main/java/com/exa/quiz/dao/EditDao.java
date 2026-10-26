package com.exa.quiz.dao;

import java.util.List;

import com.exa.quiz.model.QuestionBank;

public interface EditDao {

	public List<QuestionBank> getedits(int qid);
}
