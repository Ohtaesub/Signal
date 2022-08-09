package com.signal.interview.dao;

import java.util.ArrayList;
import java.util.HashMap;

import com.signal.all.dto.InterviewDTO;

public interface InterviewDAO {

	ArrayList<InterviewDTO> interviewList();

	InterviewDTO clientObjectionReg(String inter_no);

	InterviewDTO interviewDetail(String inter_no);

	ArrayList<InterviewDTO> comInterviewList();

	int comInterviewDateDo(HashMap<String, String> params);

	ArrayList<InterviewDTO> interviewDetailResultList(String inter_no);

	float avgGrade();

	int countComment();



}
