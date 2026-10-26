package com.exa.quiz.service;

import java.util.List;

import com.exa.quiz.model.Admin;
import com.exa.quiz.model.Recruiter;

public interface AdminService {
	public List<Admin> validateLoginAdmin(String adminEmail, String password);

	public List<Admin> getAdminByAdminEmail(String adminEmail);
	public void saveRecruiter(Recruiter recruiter);
}
