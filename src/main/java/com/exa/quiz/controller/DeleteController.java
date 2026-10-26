package com.exa.quiz.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.exa.quiz.form.AddQuestionForm;
import com.exa.quiz.model.QuestionBank;

import com.exa.quiz.service.DeleteService;
import com.exa.quiz.service.QuestionBankService;

@Controller
@RequestMapping("/delete")
public class DeleteController {
	@Autowired
	private DeleteService deleteService;
	@Autowired
	private QuestionBankService questionBankService;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView deleteQuestion(AddQuestionForm addQuestionForm, Map model, HttpSession session,
			HttpServletRequest request) {

		String qid = request.getParameter("qid");
		String techId = request.getParameter("techId");
		String compId = request.getParameter("compId");
		System.out.println(compId);
		String question = request.getParameter("question");
		
		System.out.println(qid);

		int id1 = Integer.parseInt(qid);
		
		String status="InActive";
		deleteService.updatestatus( question ,status);
		List trash = questionBankService.showtrash("InActive");
		System.out.println(trash);
		return new ModelAndView("/questionbank", "trash", trash);
	}
}
