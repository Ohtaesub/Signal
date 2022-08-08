package com.signal.all.dto;

import java.sql.Date;

public class InterviewDTO {
	private String jpo_title;
	private String com_name;
	private Date  inter_date;
	private int inter_grade;
	private String inter_result;
	private int inter_no;
	private String inter_comment;
	private String cl_name;
	private int cl_age;
	private String cl_gender;
	private String cl_photo;
	private String re_title;
	
	
	
	public String getCl_name() {
		return cl_name;
	}
	public void setCl_name(String cl_name) {
		this.cl_name = cl_name;
	}
	public int getCl_age() {
		return cl_age;
	}
	public void setCl_age(int cl_age) {
		this.cl_age = cl_age;
	}
	public String getCl_gender() {
		return cl_gender;
	}
	public void setCl_gender(String cl_gender) {
		this.cl_gender = cl_gender;
	}
	public String getCl_photo() {
		return cl_photo;
	}
	public void setCl_photo(String cl_photo) {
		this.cl_photo = cl_photo;
	}
	public String getRe_title() {
		return re_title;
	}
	public void setRe_title(String re_title) {
		this.re_title = re_title;
	}
	public String getJpo_title() {
		return jpo_title;
	}
	public void setJpo_title(String jpo_title) {
		this.jpo_title = jpo_title;
	}
	public String getCom_name() {
		return com_name;
	}
	public void setCom_name(String com_name) {
		this.com_name = com_name;
	}
	public Date getInter_date() {
		return inter_date;
	}
	public void setInter_date(Date inter_date) {
		this.inter_date = inter_date;
	}
	public int getInter_grade() {
		return inter_grade;
	}
	public void setInter_grade(int inter_grade) {
		this.inter_grade = inter_grade;
	}
	public String getInter_result() {
		return inter_result;
	}
	public void setInter_result(String inter_result) {
		this.inter_result = inter_result;
	}
	public int getInter_no() {
		return inter_no;
	}
	public void setInter_no(int inter_no) {
		this.inter_no = inter_no;
	}
	public String getInter_comment() {
		return inter_comment;
	}
	public void setInter_comment(String inter_comment) {
		this.inter_comment = inter_comment;
	}
	
}
