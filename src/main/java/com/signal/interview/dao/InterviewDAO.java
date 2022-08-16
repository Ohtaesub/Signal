package com.signal.interview.dao;

import java.util.ArrayList;
import java.util.HashMap;

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



	void comInterviewUpdateState(HashMap<String, String> params);

	int getTotal();

	int comSearchTotal(String searchOption, String search);

	ArrayList<InterviewDTO> comSearchList(String searchOption, String search, int skip);






}
