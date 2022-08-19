package com.signal.interview.dao;

import java.util.ArrayList;
import java.util.HashMap;

import com.signal.all.dto.EnterDTO;
import com.signal.all.dto.InterviewDTO;
import com.signal.enter.controller.Criteria;

public interface InterviewDAO {

	ArrayList<InterviewDTO> interviewList();

	InterviewDTO clientObjectionReg(String inter_no);

	InterviewDTO interviewDetail(String inter_no);

	ArrayList<InterviewDTO> comInterviewList(Criteria cri);

	int comInterviewDateDo(HashMap<String, String> params);

	ArrayList<InterviewDTO> interviewDetailResultList(String inter_no);

	float avgGrade();

	int countComment();

	InterviewDTO comInterviewUpdate(String inter_no);

	//ArrayList<InterviewDTO> queList();

	ArrayList<InterviewDTO> comInterviewUpdateQue(String inter_no);



	int comInterviewUpdateState(HashMap<String, String> params);

	int getTotal();

	int comSearchTotal(String searchOption, String search);

	ArrayList<InterviewDTO> comSearchList(String searchOption, String search, int skip);



	ArrayList<EnterDTO> companyApplyList(String com_id, int skip, int amount);

	int getCompanyApplyTotal(String com_id);

	// by태섭, 기업이 지원자 면접 상태 변경_2022_08_18
	boolean interviewSave(int inter_no, String inter_date, String inter_result);

	// by태섭, 면접 결과 리스트_2022_08_18
	//String interResult(String inter_no);

	EnterDTO interResultList(String inter_no);

	

}
