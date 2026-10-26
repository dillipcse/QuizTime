package com.exa.quiz.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exa.quiz.dao.QuestionBankDao;
import com.exa.quiz.model.QuestionBank;

import com.exa.quiz.service.QuestionBankService;
@Service
public class QuestionBankServiceImpl implements QuestionBankService {
	@Autowired
	private QuestionBankDao questionBankDao;
	@Override
	public List<QuestionBank> showGeneralMcq(String techId,String status) {
		return questionBankDao.showGeneralMcq(techId,status);
	}
	@Override
	public List<QuestionBank> showJavaq(String techId,String status) {
		return questionBankDao.showJavaq(techId,status);
	}
	@Override
	public List<QuestionBank> showJavaScriptq(String techId,String status) {
		return questionBankDao.showJavaScriptq(techId,status);
	}
	@Override
	public List<QuestionBank> showSapui5q(String techId,String status) {
		return questionBankDao.showSapui5q(techId,status);
	}
	@Override
	public List<QuestionBank> showAptitudeq(String techId,String status) {
		return questionBankDao.showAptitudeq(techId,status);
	}
	@Override
	public List<QuestionBank> showtrash(String status) {
		
		return questionBankDao.showtrash(status);
	}

}
