package com.exa.quiz.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.exa.quiz.model.Admin;
import com.exa.quiz.model.Quiz;
import com.exa.quiz.model.Result;
import com.exa.quiz.service.ParticipantResultService;
import com.exa.quiz.service.SaveResultService;
import com.exa.quiz.utils.SendMailWithPDF;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.CMYKColor;
import com.itextpdf.text.pdf.PdfWriter;

@Controller
@RequestMapping("/saveresult")
public class SaveAnswersController {

	@Autowired
	private SaveResultService saveresultService;
	@Autowired
	private ParticipantResultService participantresultService;

	Font blueFont = FontFactory.getFont(FontFactory.COURIER, 12, Font.BOLD, new CMYKColor(100, 0, 100, 0));
	Font redFont = FontFactory.getFont(FontFactory.COURIER, 12, Font.BOLD, new CMYKColor(0, 255, 0, 0));
	Font yellowFont = FontFactory.getFont(FontFactory.COURIER, 14, Font.BOLD, new CMYKColor(0, 0, 255, 0));

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView showQuestionBankController(HttpServletRequest request, HttpSession session, Model model)
			throws IOException {
		String userid = (String) session.getAttribute("userid");
		Long mobile = (Long) session.getAttribute("mobile");
		String date = "yyyy-MM-dd";
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat dateFormat = new SimpleDateFormat(date);
		String dateoftoday = dateFormat.format(calendar.getTime());
		String name = (String) session.getAttribute("name");
		int corectans = 0;
		Quiz quiz = new Quiz();
		quiz.setSessionId(userid);
		int j = 0;
		for (int i = 1; i <= 30; i++) {
			String option = request.getParameter("" + i + "");
			String keys = request.getParameter("key" + i + "");
			String question = request.getParameter("question" + i + "");
			String optiona = request.getParameter("optiona" + i + "");
			String optionb = request.getParameter("optionb" + i + "");
			String optionc = request.getParameter("optionc" + i + "");
			String optiond = request.getParameter("optiond" + i + "");
			quiz.setQnum(i);
			quiz.setUkey(option);
			quiz.setQuestion(question);
			quiz.setOptionA(optiona);
			quiz.setOptionB(optionb);
			quiz.setOptionC(optionc);
			quiz.setOptionD(optiond);
			quiz.setQkey(keys);
			saveresultService.saveresult(quiz);
			if (option == null) {
				option = "null";
			} else {
				j++;
			}
			if (option.equals(keys)) {
				corectans += 1;
			} else {
				corectans = corectans;
			}
		}

		int marks = corectans * 2;
		float percentage = (marks * 100 / 60);
		Result result3 = new Result();
		result3.setSessionId(userid);
		result3.setTotalQues(30);
		result3.setCorrectAns(corectans);
		result3.setTotalMarks(60);
		result3.setMarks(marks);
		result3.setPercentage(percentage);
		result3.setName(name);
		result3.setMobile(mobile);
		result3.setDate(dateoftoday);
		result3.setAnsweredQue(j);
		saveresultService.insertresult(result3);
		System.out.println("result saved");
		List result2 = participantresultService.getUser(dateoftoday);
		List result = participantresultService.getUserById(userid);
		Result result1 = (Result) result.get(0);
		System.out.println(result);
		System.out.println(result1);
		List quizdetails = participantresultService.getquizdetails(userid);
		// Quiz quiz=(Quiz)quizdetails.get(0);
		System.out.println(quizdetails);
		// String u = (String) session.getAttribute("userid");
		
		SendMailWithPDF sendMailWithPDF = new SendMailWithPDF(userid, mobile, dateoftoday, name, j, result1, quizdetails,saveresultService);
		sendMailWithPDF.start();
//		createPDFAndSendMail(userid, mobile, dateoftoday, name, j, result1, quizdetails);
		return new ModelAndView("/testcomplete");
	}

	private void createPDFAndSendMail(String userid, Long mobile, String dateoftoday, String name, int j,
			Result result1, List quizdetails) throws IOException {
		Document document = new Document();
		try {
			// String fileName = result1.getName();
			String FILE = "d://" + name + "Result.pdf";
			// PdfWriter.getInstance(document, new FileOutputStream(FILE));
			PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(FILE));
			document.open();
			String s = "" + result1.getAnsweredQue() + "/30";

			document.add(new Paragraph(20, "Full Name:\t\t" + "\t\t" + name));
			document.add(new Paragraph(20, "Email:\t\t" + "\t\t" + userid));
			document.add(new Paragraph(20, "Mobile:\t\t" + "\t\t" + mobile));
			document.add(new Paragraph(20, "Date Submited:\t\t" + "\t\t" + dateoftoday));
			document.add(new Paragraph(20, "Answered Questions:\t\t" + j));

			for (int i = 0; i <= 29; i++) {
				Quiz quiz1 = (Quiz) quizdetails.get(i);
				document.add(new Paragraph((i + 1) + ". " + quiz1.getQuestion()));
				document.add(new Paragraph("     A" + "." + " " + quiz1.getOptionA()));
				document.add(new Paragraph("     B" + "." + " " + quiz1.getOptionB()));
				document.add(new Paragraph("     C" + "." + " " + quiz1.getOptionC()));
				document.add(new Paragraph("     D" + "." + " " + quiz1.getOptionD()));
				document.add(new Paragraph("     Answer" + ":" + " " + quiz1.getQkey()));
				String qkey = quiz1.getQkey();
				String ukey = quiz1.getUkey();
				if (ukey == null) {
					ukey = "null";
					document.add(new Paragraph("Not Answered", yellowFont));
				} else {

					if (ukey.equals(qkey)) {
						document.add(new Paragraph("Correct Answer", blueFont));
					} else if (ukey != qkey && ukey != null) {
						document.add(new Paragraph("Wrong Answer", redFont));
					}
				}
			}
			document.close();
			writer.close();
		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		List<Admin> adminmail = saveresultService.getadmin();

		final String username = adminmail.get(0).getAdminEmail();
		final String password = adminmail.get(0).getPassword();
		List recmail = saveresultService.getrec();

		String arr = String.join(",", recmail);
		System.out.println(arr);
		Properties props = new Properties();
		props.put("mail.smtp.auth", true);
		props.put("mail.smtp.starttls.enable", true);
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session1 = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {

			Message message = new MimeMessage(session1);
			message.setFrom(new InternetAddress(username));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(arr));
			message.setSubject("Result of EXA-AG performance test");
			MimeBodyPart messageBodyPart = new MimeBodyPart();
			messageBodyPart.setText("Hi recruiter, This is the result of " + name + "");
			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(messageBodyPart);
			messageBodyPart = new MimeBodyPart();

			messageBodyPart.attachFile(new File("d://" + name + "Result.pdf"), "application/pdf", null);
			multipart.addBodyPart(messageBodyPart);
			message.setContent(multipart);
			Transport.send(message);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

}
