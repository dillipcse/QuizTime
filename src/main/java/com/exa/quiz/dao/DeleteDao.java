package com.exa.quiz.dao;



public interface DeleteDao {
	public void deleteque(int qid);
	
	public void updatestatus( String question,String status);
	
	public void updateStatusToActive( String question,String status);

}
