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
import com.exa.quiz.service.EditQueService;

@Controller
@RequestMapping("/editque")
public class EditQueController {
	@Autowired
	private EditQueService editQueService;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView deleteQuestion(AddQuestionForm addQuestionForm, Map model, HttpSession session,
			HttpServletRequest request) {
		String qid = request.getParameter("qid");
		int id = Integer.parseInt(qid);
		session.setAttribute("id", id);
		List editqueList = editQueService.editque(id);
		QuestionBank bank = (QuestionBank) editqueList.get(0);

		return new ModelAndView("/editquestions", "bank", bank);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView updateQuestion(AddQuestionForm addQuestionForm, Map model, HttpSession session,
			HttpServletRequest request) {
		int id = (int) session.getAttribute("id");
		String techId = request.getParameter("techId");
		String compId = request.getParameter("compId");
		String question = request.getParameter("question");
		String optionA = request.getParameter("optionA");
		String optionB = request.getParameter("optionB");
		String optionC = request.getParameter("optionC");
		String optionD = request.getParameter("optionD");
		String qkey = request.getParameter("qkey");
		editQueService.updateque(techId, compId, question, optionA, optionB, optionC, optionD, qkey, id);
		if (techId.equals("GE")) {
			System.out.println("Dillipge");
			String b = "general";
			return new ModelAndView("/questionbank", "b", b);
		}
		if (techId.equals("AP")) {
			System.out.println("dillip ap");
			String b = "apti";
			return new ModelAndView("/questionbank", "b", b);
		}
		if (techId.equals("UI")) {
			System.out.println("Dillipge");
			String b = "sapui5";
			return new ModelAndView("/questionbank", "b", b);
		}
		if (techId.equals("JS")) {
			System.out.println("dillip ap");
			String b = "javascript";
			return new ModelAndView("/questionbank", "b", b);
		}
		if (techId.equals("JA")) {
			System.out.println("dillip ap");
			String b = "java";
			return new ModelAndView("/questionbank", "b", b);
		}
		System.out.println("dillip kk");
		return new ModelAndView("/questionbank");
	}

}
