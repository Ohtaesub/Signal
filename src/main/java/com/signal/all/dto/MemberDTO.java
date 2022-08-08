package com.signal.all.dto;

import java.security.Timestamp;
import java.sql.Date;

public class MemberDTO {

	private String cl_id;
	private String cl_pw;
	private String cl_name;
	private String cl_call;
	private String cl_address;
	private Date cl_birth;
	private String cl_email;
	private String cl_gender;
	private Timestamp cl_join_date;
	private String cl_state;
	private String cl_photo;
	private String st_comment;
	private int cl_age;
	public String getCl_id() {
		return cl_id;
	}
	public void setCl_id(String cl_id) {
		this.cl_id = cl_id;
	}
	public String getCl_pw() {
		return cl_pw;
	}
	public void setCl_pw(String cl_pw) {
		this.cl_pw = cl_pw;
	}
	public String getCl_name() {
		return cl_name;
	}
	public void setCl_name(String cl_name) {
		this.cl_name = cl_name;
	}
	public String getCl_call() {
		return cl_call;
	}
	public void setCl_call(String cl_call) {
		this.cl_call = cl_call;
	}
	public String getCl_address() {
		return cl_address;
	}
	public void setCl_address(String cl_address) {
		this.cl_address = cl_address;
	}
	public Date getCl_birth() {
		return cl_birth;
	}
	public void setCl_birth(Date cl_birth) {
		this.cl_birth = cl_birth;
	}
	public String getCl_email() {
		return cl_email;
	}
	public void setCl_email(String cl_email) {
		this.cl_email = cl_email;
	}
	public String getCl_gender() {
		return cl_gender;
	}
	public void setCl_gender(String cl_gender) {
		this.cl_gender = cl_gender;
	}
	public Timestamp getCl_join_date() {
		return cl_join_date;
	}
	public void setCl_join_date(Timestamp cl_join_date) {
		this.cl_join_date = cl_join_date;
	}
	public String getCl_state() {
		return cl_state;
	}
	public void setCl_state(String cl_state) {
		this.cl_state = cl_state;
	}
	public String getCl_photo() {
		return cl_photo;
	}
	public void setCl_photo(String cl_photo) {
		this.cl_photo = cl_photo;
	}
	public String getSt_comment() {
		return st_comment;
	}
	public void setSt_comment(String st_comment) {
		this.st_comment = st_comment;
	}
	public int getCl_age() {
		return cl_age;
	}
	public void setCl_age(int cl_age) {
		this.cl_age = cl_age;
	}
	
	
}