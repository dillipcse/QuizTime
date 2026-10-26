package com.exa.quiz.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "questionbank")
public class QuestionBank {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "qid")
	private int qid;
	@Column(name = "question")
	private String question;

	@Column(name = "optionA")
	private String optionA;

	@Column(name = "optionB")
	private String optionB;

	@Column(name = "optionC")
	private String optionC;

	@Column(name = "optionD")
	private String optionD;

	@Column(name = "qkey")
	private String qkey;

	@Column(name = "compId")
	private String compId;

	@Column(name = "techId")
	private String techId;
	@Column(name = "status")
	private String status;
	/*
	 * @Column(name = "levelId") private String levelId; public String
	 * getLevelId() { return levelId; }
	 * 
	 * public void setLevelId(String levelId) { this.levelId = levelId; }
	 */

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getQid() {
		return qid;
	}

	public void setQid(int qid) {
		this.qid = qid;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getOptionA() {
		return optionA;
	}

	public void setOptionA(String optionA) {
		this.optionA = optionA;
	}

	public String getOptionB() {
		return optionB;
	}

	public void setOptionB(String optionB) {
		this.optionB = optionB;
	}

	public String getOptionC() {
		return optionC;
	}

	public void setOptionC(String optionC) {
		this.optionC = optionC;
	}

	public String getOptionD() {
		return optionD;
	}

	public void setOptionD(String optionD) {
		this.optionD = optionD;
	}

	public String getQkey() {
		return qkey;
	}

	public void setQkey(String qkey) {
		this.qkey = qkey;
	}

	public String getCompId() {
		return compId;
	}

	public void setCompId(String compId) {
		this.compId = compId;
	}

	public String getTechId() {
		return techId;
	}

	public void setTechId(String techId) {
		this.techId = techId;
	}

	@Override
	public String toString() {
		return "QuestionBank [qid=" + qid + ", question=" + question + ", optionA=" + optionA + ", optionB=" + optionB
				+ ", optionC=" + optionC + ", optionD=" + optionD + ", qkey=" + qkey + ", compId=" + compId
				+ ", techId=" + techId + ", status=" + status + ", getStatus()=" + getStatus() + ", getQid()="
				+ getQid() + ", getQuestion()=" + getQuestion() + ", getOptionA()=" + getOptionA() + ", getOptionB()="
				+ getOptionB() + ", getOptionC()=" + getOptionC() + ", getOptionD()=" + getOptionD() + ", getQkey()="
				+ getQkey() + ", getCompId()=" + getCompId() + ", getTechId()=" + getTechId() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

}
