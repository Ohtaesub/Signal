package com.signal.enter.dao;

import java.util.ArrayList;

import com.signal.all.dto.EnterDTO;
import com.signal.all.dto.JobPostingDTO;
import com.signal.all.dto.ResumeDTO;
import com.signal.enter.controller.Criteria;

public interface EnterDAO {

	ArrayList<EnterDTO> offerList(/* String com_id */);

	ArrayList<JobPostingDTO> jobPostingList();

	ArrayList<ResumeDTO> personInfo(int re_no);

	int offer(int re_no, int jpo_no);

	//ArrayList<EnterDTO> clientOfferList();
	
	//by태섭, 페이징 처리를 적용한 리스트_2022_08_12
	//ArrayList<EnterDTO> clientOfferList(String cl_id, Criteria cri);
	
	//by태섭, 받은 제안 총 개수
	public int getOfferTotal(String cl_id);

	boolean deleteOffer(String[] chkArr);

	ArrayList<EnterDTO> clientApplyList(String cl_id, int skip, int amount);

	void upHit(int offer_no);

	ArrayList<EnterDTO> clientOfferList(String cl_id, int skip, int amount);

	//by태섭, 지원 총 개수
	public int getApplyTotal(String cl_id);

	

	

}
