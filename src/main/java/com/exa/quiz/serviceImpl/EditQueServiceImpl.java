package com.exa.quiz.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exa.quiz.dao.EditQueDao;
import com.exa.quiz.model.QuestionBank;
import com.exa.quiz.service.EditQueService;
@Service
public class EditQueServiceImpl implements EditQueService{
@Autowired
	private EditQueDao editQueDao;
	@Override
	public List<QuestionBank> editque(int qid) {
		
		return editQueDao.editque(qid);
	}
	@Override
	public void updateque(String techId, String compId, String question, String optionA, String optionB, String optionC,
			String optionD, String qkey,int qid) {
		editQueDao.updateque(techId, compId, question, optionA, optionB, optionC, optionD, qkey,qid);
		
	}

}
