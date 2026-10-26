package com.exa.quiz.serviceImpl;

import java.util.List;

import javax.jdo.annotations.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exa.quiz.dao.ParticipantHistoryDao;
import com.exa.quiz.model.QuestionBank;
import com.exa.quiz.model.Result;
import com.exa.quiz.model.User;
import com.exa.quiz.service.ParticipantHistoryService;

@Service
public class ParticipantHistoryServiceImpl implements ParticipantHistoryService {
	@Autowired
	private ParticipantHistoryDao participantHistoryDao;

	@Override
	@Transactional
	public List<QuestionBank> getTotalNumberOfQuestionBank() {
		return participantHistoryDao.getTotalNumberOfQuestionBank();
	}

	@Override
	public List<Result> gethistory(String fromdate, String todate) {
		return participantHistoryDao.gethistorybydate(fromdate, todate);
	}

}
