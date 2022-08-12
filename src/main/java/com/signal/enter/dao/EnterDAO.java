package com.signal.enter.dao;

import java.util.ArrayList;

import com.signal.all.dto.EnterDTO;
import com.signal.all.dto.JobPostingDTO;
import com.signal.all.dto.ResumeDTO;

public interface EnterDAO {

	ArrayList<EnterDTO> offerList(/* String com_id */);

	ArrayList<JobPostingDTO> jobPostingList();

	ArrayList<ResumeDTO> personInfo(int re_no);

	int offer(int re_no, int jpo_no);

	ArrayList<EnterDTO> clientOfferList();

	boolean deleteOffer(String[] chkArr);

	ArrayList<EnterDTO> clientApplyList();

	

	

}
