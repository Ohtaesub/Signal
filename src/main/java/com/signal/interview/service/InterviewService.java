package com.signal.interview.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.mariadb.jdbc.internal.logging.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.signal.all.dto.InterviewDTO;
import com.signal.enter.controller.Criteria;
import com.signal.interview.dao.InterviewDAO;

@Service
public class InterviewService {
	
	private Logger logger = org.slf4j.LoggerFactory.getLogger(this.getClass());
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

	public ArrayList<InterviewDTO> comInterviewList(Criteria cri) {
		
		return dao.comInterviewList(cri);
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

	public InterviewDTO comInterviewUpdate(String inter_no) {
		
		return dao.comInterviewUpdate(inter_no);
	}

	//public ArrayList<InterviewDTO> queList() {
		
		//return dao.queList();
	//}

	public ArrayList<InterviewDTO> comInterviewUpdateQue(String inter_no) {
		
		return dao.comInterviewUpdateQue(inter_no);
	}

	public String comInterviewUpdateDo(HashMap<String, String> params) {
		
	
		
		
		
 		dao.comInterviewUpdateState(params);

		
		return "redirect:/comInterviewList.go";
	}

	public int getTotal() {
		logger.info("면접자수  서비스 요청");
		return dao.getTotal();
	}

	public ArrayList<InterviewDTO> comSearchList(String searchOption, String search, int skip) {
		// TODO Auto-generated method stub
		return dao.comSearchList(searchOption,search,skip);
	}

	public int comSearchTotal(String searchOption, String search) {
	
		return dao.comSearchTotal(searchOption, search);
	}

	


	
}
