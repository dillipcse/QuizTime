package com.exa.quiz.controller;

import java.util.Calendar;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.exa.quiz.model.Quiz;
import com.exa.quiz.model.Result;
import com.exa.quiz.service.ParticipantResultService;
import com.exa.quiz.serviceImpl.ParticipantResultServiceImpl;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.CMYKColor;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;

@Controller
@RequestMapping("/pdf")
public class PdfController {
	@Autowired
	private ParticipantResultService participantresultService;
	Font ffont = new Font(Font.FontFamily.UNDEFINED, 16, Font.ITALIC);
	Font blueFont = FontFactory.getFont(FontFactory.COURIER, 12, Font.BOLD, new CMYKColor(100, 0, 100, 0));
	Font redFont = FontFactory.getFont(FontFactory.COURIER, 12, Font.BOLD, new CMYKColor(0, 255, 0, 0));
	Font yellowFont = FontFactory.getFont(FontFactory.COURIER, 14, Font.BOLD, new CMYKColor(0, 0, 255, 0));

	@RequestMapping(method = RequestMethod.GET)
	public void generatePdf(Map model, HttpSession session, HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		String sessionId = request.getParameter("sessionId");
		System.out.println(sessionId);
		session.setAttribute("sessionId", sessionId);
		System.out.println("1");
		String date = "yyyy-MM-dd";
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat dateFormat = new SimpleDateFormat(date);
		String dateoftoday = dateFormat.format(calendar.getTime());
		// ParticipantResultService participantresultService = new
		// ParticipantResultServiceImpl();
		List result2 = participantresultService.getUser(dateoftoday);
		List result = participantresultService.getUserById(sessionId);
		Result result1 = (Result) result.get(0);
		List quizdetails = participantresultService.getquizdetails(sessionId);
		final ServletContext servletContext = request.getSession().getServletContext();
		final File tempDirectory = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
		final String temperotyFilePath = tempDirectory.getAbsolutePath();
		System.out.println("10");
		String fileName = result1.getName() + "Result.pdf";
		System.out.println("9");
		response.setContentType("application/pdf");
		response.setHeader("Content-disposition", "attachment; filename=" + fileName);
		System.out.println("19");
		Document document = null;
		try {
			System.out.println("11");
			try {
				document = new Document();
				PdfWriter writer = PdfWriter.getInstance(document,
						new FileOutputStream(temperotyFilePath + "\\" + fileName));
				document.open();
				String s = "" + result1.getAnsweredQue() + "/30";
				System.out.println(s);
				String p = "" + result1.getPercentage() + "%";
				System.out.println(p);
				PdfContentByte cb = writer.getDirectContent();
				Phrase header = new Phrase("Participant Result", ffont);
				System.out.println("4");
				// Phrase footer = new Phrase("this is a footer", ffont);
				ColumnText.showTextAligned(cb, Element.ALIGN_CENTER, header,
						(document.right() - document.left()) / 2 + document.leftMargin(), document.top() + 10, 0);
				document.add(new Paragraph(20, "Full Name:\t\t" + "\t\t" + result1.getName()));
				document.add(new Paragraph(20, "Email:\t\t" + "\t\t" + result1.getSessionId()));
				document.add(new Paragraph(20, "Mobile:\t\t" + "\t\t" + result1.getMobile()));
				document.add(new Paragraph(20, "Date Submited:\t\t" + "\t\t" + result1.getDate()));
				document.add(new Paragraph(20, "Answered Questions:\t\t" + s));
				document.add(new Paragraph(20, "Participant Score:\t\t" + p));
				for (int i = 0; i <= 29; i++) {
					Quiz quiz = (Quiz) quizdetails.get(i);
					document.add(new Paragraph((i + 1) + ". " + quiz.getQuestion()));
					document.add(new Paragraph("     A" + "." + " " + quiz.getOptionA()));
					document.add(new Paragraph("     B" + "." + " " + quiz.getOptionB()));
					document.add(new Paragraph("     C" + "." + " " + quiz.getOptionC()));
					document.add(new Paragraph("     D" + "." + " " + quiz.getOptionD()));
					document.add(new Paragraph("     Answer" + ":" + " " + quiz.getQkey()));
					
					String qkey = quiz.getQkey();
					String ukey = quiz.getUkey();
					System.out.println("5");
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
				System.out.println("pdf3");
			} catch (FileNotFoundException e) {

				e.printStackTrace();
			}
			// PdfController.createPDF(temperotyFilePath + "\\" + fileName);
			// CreatePdf.createPDF(temperotyFilePath + "\\" + fileName,session);
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			System.out.println("12");
			baos = convertPDFToByteArrayOutputStream(temperotyFilePath + "\\" + fileName);
			OutputStream os = response.getOutputStream();
			System.out.println("13");
			baos.writeTo(os);
			os.flush();
		} catch (Exception e1) {
			e1.printStackTrace();
		}

	}

	private ByteArrayOutputStream convertPDFToByteArrayOutputStream(String fileName) {
		System.out.println("14");
		InputStream inputStream = null;
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try {
			System.out.println("15");
			inputStream = new FileInputStream(fileName);
			byte[] buffer = new byte[1024];
			baos = new ByteArrayOutputStream();
			System.out.println("16");
			int bytesRead;
			while ((bytesRead = inputStream.read(buffer)) != -1) {
				baos.write(buffer, 0, bytesRead);
			}
			System.out.println("17");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			System.out.println("18");
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return baos;
	}

	public static Document createPDF(String file) {
		System.out.println("pdfcreate");

		System.out.println("1");
		String date = "yyyy-MM-dd";
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat dateFormat = new SimpleDateFormat(date);
		String dateoftoday = dateFormat.format(calendar.getTime());
		/*
		 * List result2 = participantresultService.getUser(dateoftoday);
		 * System.out.println(result2); List result =
		 * participantresultService.getUserById(sessionId); System.out.println(result);
		 * Result result1 = (Result) result.get(0); List quizdetails =
		 * participantresultService.getquizdetails(sessionId);
		 * System.out.println(quizdetails);
		 */
		System.out.println("2");
		System.out.println("pdf1");
		Document document = null;

		try {
			document = new Document();
			PdfWriter.getInstance(document, new FileOutputStream(file));
			document.open();
			System.out.println("pdf2");
			document.add(new Paragraph("sisiri"));

			document.close();
			System.out.println("pdf3");
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		return document;

	}

}
