package com.exa.quiz.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.exa.quiz.form.AddQuestionForm;
import com.exa.quiz.model.QuestionBank;
import com.exa.quiz.service.TestService;

@Controller
@RequestMapping(value = "/getinstructions")
public class InstructionController {
	@Autowired
	private TestService testService;
	@SuppressWarnings("unused")
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView showquestions(HttpServletRequest request, HttpSession session, HttpServletResponse response)
			throws ServletException, IOException {
		String technologyId = request.getParameter("techId");
		session.setAttribute("technologyId", technologyId);
		String levelId = request.getParameter("levelId");
		String techgeneral = request.getParameter("techgeneralId");
		session.setAttribute("techgeneral", techgeneral);
		String techapti = request.getParameter("techaptiId");
		session.setAttribute("techapti", techapti);
		List technologyList = testService.getquestions(technologyId,levelId);
		@SuppressWarnings({ "unused", "rawtypes" })
		List technologygenList = testService.getquestions(techgeneral,levelId);
		@SuppressWarnings({ "rawtypes", "unused" })
		List technologyaptiList = testService.getquestions(techapti,levelId);
		ArrayList<QuestionBank> obj = new ArrayList<QuestionBank>();
		obj.addAll(technologygenList);
		obj.addAll(technologyaptiList);
		obj.addAll(technologyList);
		session.setAttribute("objj", obj);
		return new ModelAndView("/starttest", "obj", obj);

	}
}
