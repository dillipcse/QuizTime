package com.exa.quiz.service;



public interface DeleteService {
public void deleteque(int qid);
	
	public void updatestatus( String question,String status);
	
	public void updateStatusToActive( String question,String status);

}