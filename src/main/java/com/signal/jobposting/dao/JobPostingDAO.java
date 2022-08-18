package com.signal.jobposting.dao;

import java.util.ArrayList;
import java.util.HashMap;

import com.signal.all.dto.InterviewDTO;
import com.signal.all.dto.JobPostingDTO;
import com.signal.all.dto.ObjectionDTO;
import com.signal.enter.controller.Criteria;

public interface JobPostingDAO {

	JobPostingDTO infoCom(String id);

	int infoWrite(JobPostingDTO dto);

	JobPostingDTO ComInfoDetail(String id, String ceo,String no);
	// 로그인 관련
	// String login(String com_id, String com_pw);

	String ComDetail(String id);

	String file(String no);

	JobPostingDTO Detail(String id, String ceo, String no);

	JobPostingDTO comUpdate(String id);

	// int update(HashMap<String, String> params);

	int update(JobPostingDTO dto);

	ArrayList<JobPostingDTO> photoList(String id);

	JobPostingDTO infoList(String id);

	JobPostingDTO posting(String id);

	int postingWrite(JobPostingDTO dto);

	void upHit(String jpo_no);

	JobPostingDTO jobPostingDetail(String jpo_no);

	JobPostingDTO UpdatePage(String id, String jpo_no);

	int postingUpdate(JobPostingDTO dto);

	int close();

	ArrayList<JobPostingDTO>postingList(HashMap<String, Object> params);

	int comPostingPasingTotal(HashMap<String, Object> params);

	ArrayList<InterviewDTO> jobPostingSearch(String searchOption, int skip, String id);

	int jobPostingListTotal2(String searchOption, String id);

	ArrayList<JobPostingDTO> mainPostingList(HashMap<String, Object> params);

	int mainPostingPasingTotal(HashMap<String, Object> params);

	//ArrayList<InterviewDTO> jobPostingMainSearch(String searchOption,String searchOption1,String searchOption2,String search, int skip);

	//int jobPostingMainTotal(String searchOption,String searchOption1,String searchOption2, String search);

	
	ArrayList<InterviewDTO> jobPostingMainSearch(String searchOption,String search, int skip);

	int jobPostingMainTotal(String searchOption, String search);
	

	
	
	//ArrayList<ObjectionDTO> comPostingPasing(Criteria cri);

	//int comPostingPasingTotal();

	// ArrayList<JobPostingDTO> postingPhoto(String jpo_no);


	
	
	
}
