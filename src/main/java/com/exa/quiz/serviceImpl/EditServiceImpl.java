package com.exa.quiz.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exa.quiz.dao.EditDao;
import com.exa.quiz.dao.QuestionsDao;
import com.exa.quiz.model.QuestionBank;
import com.exa.quiz.service.EditService;

@Service
public class EditServiceImpl implements EditService {
	@Autowired
	private EditDao editDao;

	@Override
	public List<QuestionBank> getedits(int qid) {

		return editDao.getedits(qid);
	}

}
