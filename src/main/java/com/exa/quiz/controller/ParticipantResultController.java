package com.exa.quiz.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.exa.quiz.service.ParticipantResultService;

@Controller
@RequestMapping("/participantResult")
public class ParticipantResultController {
	@Autowired
	private ParticipantResultService participantresultService;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView showParticipantResultController(HttpSession session, Map model) {
		String date = "yyyy-MM-dd";

		// String date = "dd/MM/yyyy";
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat dateFormat = new SimpleDateFormat(date);
		// System.out.println("Today Date = " +
		// dateFormat.format(calendar.getTime()));
		String dateoftoday = dateFormat.format(calendar.getTime());

		List result = participantresultService.getUser(dateoftoday);
		String u = (String) session.getAttribute("userid");
		return new ModelAndView("/participantResult", "result", result);
	}

}
