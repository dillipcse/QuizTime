package com.exa.quiz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.exa.quiz.form.AddQuestionForm;

import com.exa.quiz.model.QuestionBank;
import com.exa.quiz.service.QuestionsService;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("/addquestion")
public class AddQuestionController {
	@Autowired
	private QuestionsService questionsService;
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView showAddQuestionController(AddQuestionForm addQuestionForm, BindingResult result, Map model,
			HttpSession session) {
		if ((session.getAttribute("adminEmail")) == null) {
			return new ModelAndView("redirect:adminlogin.htm");
		}
		return new ModelAndView("/addquestion");
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView processAddQuestionController(AddQuestionForm addQuestionForm, BindingResult result, Map model,
			HttpSession session, HttpServletRequest request) {
		if ((session.getAttribute("adminEmail")) == null) {
			return new ModelAndView("redirect:adminlogin.htm");
		}
		System.out.println("ghghgsh");
			AddQuestionForm addQuestion=(AddQuestionForm)addQuestionForm;
			QuestionBank questionBank=new QuestionBank();
			questionBank.setCompId(addQuestion.getCompId());
			questionBank.setOptionA(addQuestion.getOptionA());
			questionBank.setOptionB(addQuestion.getOptionB());
			questionBank.setOptionC(addQuestion.getOptionC());
			questionBank.setOptionD(addQuestion.getOptionD());
			questionBank.setQid(addQuestion.getQid());
			questionBank.setQkey(addQuestion.getQkey());
			questionBank.setQuestion(addQuestion.getQuestion());
			questionBank.setTechId(addQuestion.getTechId());
			questionBank.setStatus("Active");
			questionsService.saveQuestions(questionBank);
			int s=2;
			if (request.getParameter("c").equals("d") && request.getParameter("s1").equals("v1")) {
				return new ModelAndView("/adminview","m",s); 
			} 
				return new ModelAndView("/addquestion","m",s); 
		//return new ModelAndView("redirect:addquestion.htm");
		//return new ModelAndView("redirect:questionbank.htm");
	}
}
