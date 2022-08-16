package com.signal.jobposting.dao;

import java.util.ArrayList;
import java.util.HashMap;

import com.signal.all.dto.JobPostingDTO;

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

	ArrayList<JobPostingDTO> postingList(String id);

	void upHit(String jpo_no);

	JobPostingDTO jobPostingDetail(String jpo_no);

	JobPostingDTO UpdatePage(String id, String jpo_no);

	int postingUpdate(JobPostingDTO dto);

	// ArrayList<JobPostingDTO> postingPhoto(String jpo_no);


	
	
	
}
