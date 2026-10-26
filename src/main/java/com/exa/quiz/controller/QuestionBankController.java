package com.exa.quiz.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.exa.quiz.form.AddQuestionForm;
import com.exa.quiz.service.QuestionBankService;

import javax.servlet.http.HttpServletRequest;

@Controller
// @RequestMapping("/questionbank")
public class QuestionBankController {
	@Autowired
	private QuestionBankService questionBankService;

	@RequestMapping(value = "/questionbank", method = RequestMethod.GET)
	public ModelAndView showQuestionBankController(AddQuestionForm addQuestionForm, Map model, HttpSession session) {
		return new ModelAndView("/questionbank");
	}

	// @RequestMapping("/generalmcq")
	@RequestMapping("/generalmcq")
	public ModelAndView showGeneralMcq(AddQuestionForm addQuestionForm, HttpServletRequest req, Map model,
			HttpSession session) {
		String techId = "GE";
		List generalMcqList = questionBankService.showGeneralMcq(techId, "Active");
		System.out.println(generalMcqList);
		return new ModelAndView("/questionbank", "generalMcqList", generalMcqList);
	}

	// @RequestMapping("/aptitude")
	@RequestMapping("/aptitude")
	public ModelAndView showAptitude() {
		String techId = "AP";
		List aptitudeq = questionBankService.showAptitudeq(techId, "Active");
		return new ModelAndView("/questionbank", "aptitudeq", aptitudeq);
	}

	@RequestMapping("/sapui5")
	public ModelAndView showSapui5() {
		String techId = "UI";
		List Sapui5q = questionBankService.showSapui5q(techId, "Active");
		return new ModelAndView("/questionbank", "Sapui5q", Sapui5q);
	}

	@RequestMapping("/javascript")
	public ModelAndView showJavaScript() {
		String techId = "JS";
		List javaScriptq = questionBankService.showJavaScriptq(techId, "Active");
		return new ModelAndView("/questionbank", "javaScriptq", javaScriptq);
	}

	@RequestMapping("/java")
	public ModelAndView showJava() {
		String techId = "JA";
		List javaq = questionBankService.showJavaq(techId, "Active");
		System.out.println(javaq);
		return new ModelAndView("/questionbank", "javaq", javaq);
	}

	@RequestMapping("/trash")
	public ModelAndView showtrash() {
		List trash = questionBankService.showtrash("InActive");
		System.out.println(trash);
		return new ModelAndView("/questionbank", "trash", trash);
	}
}
