package com.signal.interview.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.mariadb.jdbc.internal.logging.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.signal.all.dto.EnterDTO;
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

	public void comInterviewUpdateDo(HashMap<String, String> params) {
		
	
		
		int row =dao.comInterviewUpdateState(params);
		
 		

		
		
	}

	public int getTotal() {
		logger.info("면접자수  서비스 요청");
		return dao.getTotal();
	}

	public ArrayList<InterviewDTO> comSearchList(String searchOption, String search, int skip) {
		
		return dao.comSearchList(searchOption,search,skip);
	}

	public int comSearchTotal(String searchOption, String search) {
	
		return dao.comSearchTotal(searchOption, search);
	}

	// by태섭, 기업 마이페이지 입사지원현황_2022_08_17
		public ArrayList<EnterDTO> companyApplyList(String com_id, int skip, int amount) {
			logger.info("기업 마이페이지 입사지원현황 리스트 서비스 요청");
			return dao.companyApplyList(com_id, skip, amount);
		}

		// by태섭, 기업 마이페이지 입사지원 총 갯수_2022_08_17
		public int getCompanyApplyTotal(String com_id) {
			return dao.getCompanyApplyTotal(com_id);
		}

		// by태섭, 기업 마이페이지 입사지원에서 면접 상태 변경하기_2022_08_18
		public boolean interviewSave(int inter_no, String inter_date, String inter_result) {
			return dao.interviewSave(inter_no, inter_date, inter_result);		
		}

		// by태섭, 면접 결과
		 /*
		public String interResult(String inter_no) {
			logger.info("면접 결과 리스트 요청 서비스");
			return dao.interResult(inter_no);
		}*/

		public EnterDTO interResultList(String inter_no) {
			logger.info("면접 결과 리스트 요청 서비스");
			return dao.interResultList(inter_no);
		}




	
}
