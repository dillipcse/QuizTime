package com.exa.quiz.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exa.quiz.dao.DeleteDao;

import com.exa.quiz.service.DeleteService;

@Service
public class DeleteServiceImpl implements DeleteService {
	@Autowired
	private DeleteDao deleteDao;

	@Override
	public void deleteque(int qid) {
		deleteDao.deleteque(qid);
	}

	@Override
	public void updatestatus(String question, String status) {
		deleteDao.updatestatus(question, status);	
		
	}

	@Override
	public void updateStatusToActive(String question, String status) {
		deleteDao.updateStatusToActive(question, status);
		
	}

	
}
