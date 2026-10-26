package com.exa.quiz.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "result")
public class Result {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "rid")
	private int rid;
	private String date;
	private int	answeredQue;
	public int getAnsweredQue() {
		return answeredQue;
	}

	public void setAnsweredQue(int answeredQue) {
		this.answeredQue = answeredQue;
	}

	public String getDate() {
		return date;
	}

	@Override
	public String toString() {
		return "Result [rid=" + rid + ", date=" + date + ", sessionId=" + sessionId + ", totalQues=" + totalQues
				+ ", correctAns=" + correctAns + ", totalMarks=" + totalMarks + ", marks=" + marks + ", name=" + name
				+ ", mobile=" + mobile + ", percentage=" + percentage + "]";
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getMobile() {
		return mobile;
	}

	public void setMobile(Long mobile) {
		this.mobile = mobile;
	}

	private String sessionId;

	private int totalQues;

	private int correctAns;

	private int totalMarks;
	private int marks;
	private String name;
	private Long mobile;
	private float percentage;

	public float getPercentage() {
		return marks;
	}

	public void setPercentage(float percentage) {
		this.percentage = percentage;
	}

	public int getRid() {
		return rid;
	}

	public void setRid(int rid) {
		this.rid = rid;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public int getTotalQues() {
		return totalQues;
	}

	public void setTotalQues(int totalQues) {
		this.totalQues = totalQues;
	}

	public int getCorrectAns() {
		return correctAns;
	}

	public void setCorrectAns(int correctAns) {
		this.correctAns = correctAns;
	}

	public int getTotalMarks() {
		return totalMarks;
	}

	public void setTotalMarks(int totalMarks) {
		this.totalMarks = totalMarks;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

}
