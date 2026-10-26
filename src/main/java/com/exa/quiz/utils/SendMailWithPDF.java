package com.exa.quiz.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
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

import com.exa.quiz.model.Admin;
import com.exa.quiz.model.Quiz;
import com.exa.quiz.model.Result;
import com.exa.quiz.service.SaveResultService;
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


public class SendMailWithPDF extends Thread {
	
	String userid;
	Long mobile;
	String dateoftoday;
	String name;
	int j;
	Result result1;
	List quizdetails;
	SaveResultService saveresultService;
	Font ffont = new Font(Font.FontFamily.UNDEFINED, 16, Font.ITALIC);
	Font blueFont = FontFactory.getFont(FontFactory.COURIER, 12, Font.BOLD, new CMYKColor(100, 0, 100, 0));
	Font redFont = FontFactory.getFont(FontFactory.COURIER, 12, Font.BOLD, new CMYKColor(0, 255, 0, 0));
	Font yellowFont = FontFactory.getFont(FontFactory.COURIER, 14, Font.BOLD, new CMYKColor(0, 0, 255, 0));
	
	public SendMailWithPDF(String userid, Long mobile, String dateoftoday, String name, int j,
			Result result1, List quizdetails, SaveResultService saveresultService) {
		this.userid = userid;
		this.mobile = mobile;
		this.dateoftoday = dateoftoday;
		this.name = name;
		this.j = j;
		this.result1 = result1;
		this.quizdetails = quizdetails;
		this.saveresultService = saveresultService;
	}
	
	@Override
	public void run() {
		try {
			createPDFAndSendMail();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void createPDFAndSendMail() throws IOException {
		Document document = new Document();
		try {
			// String fileName = result1.getName();
			String FILE = "d://" + name + "Result.pdf";
			// PdfWriter.getInstance(document, new FileOutputStream(FILE));
			PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(FILE));
			document.open();
			String s = "" + result1.getAnsweredQue() + "/30";
			String p=""+result1.getPercentage()+"%";
			PdfContentByte cb = writer.getDirectContent();
			Phrase header = new Phrase("Participant Result", ffont);
			ColumnText.showTextAligned(cb, Element.ALIGN_CENTER, header,
					(document.right() - document.left()) / 2 + document.leftMargin(), document.top() + 10, 0);
			document.add(new Paragraph(20, "Full Name:\t\t" + "\t\t" + name));
			document.add(new Paragraph(20, "Email:\t\t" + "\t\t" + userid));
			document.add(new Paragraph(20, "Mobile:\t\t" + "\t\t" + mobile));
			document.add(new Paragraph(20, "Date Submited:\t\t" + "\t\t" + dateoftoday));
			document.add(new Paragraph(20, "Answered Questions:\t\t" + j));
			document.add(new Paragraph(20, "Answered Questions:\t\t"+ s));
			document.add(new Paragraph(20,"Participant Score:\t\t"+p));
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

		//final String username = adminmail.get(0).getAdminEmail();
		//final String password = adminmail.get(0).getPassword();
		final String username = "dillipnayak.bdk@gmail.com";
		final String password = "egypfzavswcdgeau";
		List recmail = saveresultService.getrec();

		String arr = String.join(",", recmail);
		System.out.println(arr);
		Properties props = new Properties();
		//props.put("mail.smtp.auth", true);
		//props.put("mail.smtp.starttls.enable", true);
		//props.put("mail.smtp.host", "smtp.gmail.com");
		//props.put("mail.smtp.port", "587");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "465");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.ssl.enable", "true");

		Session session1 = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});
		session1.setDebug(true);
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
