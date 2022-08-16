package com.signal.all.dto;

import org.apache.ibatis.type.Alias;

@Alias("test")
public class TestDTO {
	private String cl_id;
	private int st_no;
	private int st_score;
	private String st_que;
	private int st_hidden;
	private String st_keyword;
	public String getCl_id() {
		return cl_id;
	}
	public void setCl_id(String cl_id) {
		this.cl_id = cl_id;
	}
	public int getSt_no() {
		return st_no;
	}
	public void setSt_no(int st_no) {
		this.st_no = st_no;
	}
	public int getSt_score() {
		return st_score;
	}
	public void setSt_score(int st_score) {
		this.st_score = st_score;
	}
	public String getSt_que() {
		return st_que;
	}
	public void setSt_que(String st_que) {
		this.st_que = st_que;
	}
	public int getSt_hidden() {
		return st_hidden;
	}
	public void setSt_hidden(int st_hidden) {
		this.st_hidden = st_hidden;
	}
	public String getSt_keyword() {
		return st_keyword;
	}
	public void setSt_keyword(String st_keyword) {
		this.st_keyword = st_keyword;
	}
	
	
}
