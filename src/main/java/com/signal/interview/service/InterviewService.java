package com.signal.interview.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.signal.all.dto.InterviewDTO;
import com.signal.interview.dao.InterviewDAO;

@Service
public class InterviewService {

	@Autowired InterviewDAO dao;

	public ArrayList<InterviewDTO> interviewList() {
	
		return dao.interviewList();
	}

	public InterviewDTO clientObjectionReg(String inter_no) {
		
		return dao.clientObjectionReg(inter_no);
	}

	public InterviewDTO interviewDetail(String inter_no) {
	
		return dao.interviewDetail(inter_no);
	}

	public ArrayList<InterviewDTO> comInterviewList() {
		
		return dao.comInterviewList();
	}

	public void comInterviewDateDo(HashMap<String, String> params) {
		int row =dao.comInterviewDateDo(params);
		
	}

	public ArrayList<InterviewDTO> interviewDetailResultList(String inter_no) {
		
		return dao.interviewDetailResultList(inter_no);
	}

	public float avgGrade() {
		
		return dao.avgGrade();
	}

	public int countComment() {
	
		return dao.countComment();

	}


	
}
