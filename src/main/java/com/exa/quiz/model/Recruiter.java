package com.exa.quiz.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "recruiter")
public class Recruiter {


	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "rid")
	private int rid;
	@Column(name = "rec_mail")
	private String rec_mail;
	@Column(name = "rec_name")
	private String rec_name;
	public String getRec_name() {
		return rec_name;
	}
	public void setRec_name(String rec_name) {
		this.rec_name = rec_name;
	}
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	public String getRec_mail() {
		return rec_mail;
	}
	public void setRec_mail(String rec_mail) {
		this.rec_mail = rec_mail;
	}
	@Override
	public String toString() {
		return "Recruiter [rid=" + rid + ", rec_mail=" + rec_mail + "]";
	}

}
