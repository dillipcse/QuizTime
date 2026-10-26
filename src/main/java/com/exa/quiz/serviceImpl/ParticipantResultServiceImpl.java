package com.exa.quiz.serviceImpl;

import java.util.List;

import javax.jdo.annotations.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exa.quiz.dao.ParticipantResultDao;
import com.exa.quiz.model.QuestionBank;
import com.exa.quiz.model.Quiz;
import com.exa.quiz.model.Result;
import com.exa.quiz.model.User;
import com.exa.quiz.service.ParticipantResultService;

@Service
public class ParticipantResultServiceImpl implements ParticipantResultService {
	@Autowired
	private ParticipantResultDao participantResultDao;

	@Override
	@Transactional
	public List<Result> getUser(String date) {
		return participantResultDao.getUser(date);
	}

	@Override
	@Transactional
	public List<QuestionBank> getTotalNumberOfQuestionBank() {
		return participantResultDao.getTotalNumberOfQuestionBank();
	}

	@Override
	public List<Quiz> getquizdetails(String sessionId) {
	
		return participantResultDao.getquizdetails(sessionId);
	}

	@Override
	public List<Result> getUserById(String sessionId) {
	
		return participantResultDao.getUserById(sessionId);
	}

}
