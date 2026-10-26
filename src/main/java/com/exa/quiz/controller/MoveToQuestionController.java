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
import com.exa.quiz.service.QuestionsService;

@Controller
@RequestMapping("/movetobank")
public class MoveToQuestionController {
	
	@Autowired
	private QuestionBankService questionBankService;
	@Autowired
	private QuestionsService questionsService;
	@Autowired
	private DeleteService deleteService;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView deleteQuestion(QuestionBank qb, AddQuestionForm addQuestionForm,
			@SuppressWarnings("rawtypes") Map model, HttpSession session, HttpServletRequest request) {
		@SuppressWarnings("rawtypes")
		List generalMcqList, aptitudeq, javaq, javaScriptq, Sapui5q = null;
		System.out.println("987654");

		String qid = request.getParameter("qid");
		String techId = request.getParameter("techId");
		String compId = request.getParameter("compId");
		System.out.println(compId);
		String question = request.getParameter("question");

		System.out.println(qid);

		int id1 = Integer.parseInt(qid);

		String status = "Active";
		deleteService.updateStatusToActive(question, status);
		/*
		 * List trash = questionBankService.showtrash("Active");
		 * System.out.println(trash); return new ModelAndView("/questionbank", "trash",
		 * trash);
		 */

		/*
		 * String qid = request.getParameter("qid"); String techId =
		 * request.getParameter("techId"); String compId =
		 * request.getParameter("compId"); String question =
		 * request.getParameter("question"); String optionA =
		 * request.getParameter("optionA"); String optionB =
		 * request.getParameter("optionB"); String optionC =
		 * request.getParameter("optionC"); String optionD =
		 * request.getParameter("optionD"); String qkey = request.getParameter("qkey");
		 * 
		 * int id = Integer.parseInt(qid); qb.setQid(id); qb.setTechId(techId);
		 * qb.setCompId(compId); qb.setQuestion(question); qb.setOptionA(optionA);
		 * qb.setOptionB(optionB); qb.setOptionC(optionC); qb.setOptionD(optionD);
		 * qb.setQkey(qkey); questionsService.saveQuestions(qb);
		 * 
		 * deleteService.deletequetrash(id);
		 */

		if (techId.equals("GE")) {
			generalMcqList = questionBankService.showGeneralMcq(techId, status);
			return new ModelAndView("/questionbank", "generalMcqList", generalMcqList);
		}
		if (techId.equals("AP")) {
			aptitudeq = questionBankService.showAptitudeq(techId, status);
			return new ModelAndView("/questionbank", "aptitudeq", aptitudeq);
		}
		if (techId.equals("JA")) {
			javaq = questionBankService.showJavaq(techId, status);
			return new ModelAndView("/questionbank", "javaq", javaq);
		}
		if (techId.equals("JS")) {
			javaScriptq = questionBankService.showJavaScriptq(techId, status);
			return new ModelAndView("/questionbank", "javaScriptq", javaScriptq);
		}
		if (techId.equals("UI"))
			Sapui5q = questionBankService.showSapui5q(techId, status);
		return new ModelAndView("/questionbank", "Sapui5q", Sapui5q);

	}
}
