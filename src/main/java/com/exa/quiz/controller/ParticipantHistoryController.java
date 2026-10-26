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

import com.exa.quiz.service.ParticipantHistoryService;

@Controller
@RequestMapping("/participantHistory2")
public class ParticipantHistoryController {
	@Autowired
	private ParticipantHistoryService participantHistoryService;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView adminView() {
		return new ModelAndView("/participanthistory");
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView showParticipantHistoryController(HttpSession session, Map model, HttpServletRequest request) {
		String fromdate = request.getParameter("fromdate");
		String todate = request.getParameter("todate");

		List resultList = participantHistoryService.gethistory(fromdate, todate);
		System.out.println(resultList);

		System.out.println("padma");
		return new ModelAndView("/participantHistory2", "resultList", resultList);
	}

}
