package com.signal.enter.service;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.signal.all.dto.EnterDTO;
import com.signal.all.dto.JobPostingDTO;
import com.signal.all.dto.ResumeDTO;
import com.signal.enter.controller.Criteria;
import com.signal.enter.dao.EnterDAO;

@Service
public class EnterService {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	// by태섭, EnterDAO 객체를 한 번만 선언하고 계속 사용한다.
	@Autowired EnterDAO dao;
	
	// by태섭, 기업이 입사제안한 리스트 호출 서비스
	public ArrayList<EnterDTO> offerList(String com_id, int skip, int amount) {
		logger.info("입사제안 리스트 서비스 요청");
		return dao.offerList(com_id, skip, amount);
	}

	// by태섭, 페이칭 처리를 위한 해당 기업 제안 총 갯수
	public int getComOfferTotal(String com_id) {
		return dao.getComOfferTotal(com_id);
	}

	// by태섭, 해당 기업의 채용공고 리스트 호출
	public ArrayList<JobPostingDTO> jobPostingList(String com_id) {
		logger.info("해당 기업의 채용공고 리스트 서비스 요청");
		return dao.jobPostingList(com_id);
	}

	// by태섭, 이력서 번호에 해당하는 회원 정보 호출 서비스
	public ArrayList<ResumeDTO> personInfo(int re_no) {
		logger.info("해당 이력서에 대한 회원 정보");
		return dao.personInfo(re_no);
	}

	// by태섭, 해당 이력서 번호와 채용 공고 번호를 Offer 테이블에 저장, 입사제안 서비스
	public void offer(int re_no, int jpo_no) {
		logger.info("입사제안 서비스 요청");
		// by태섭, 입사제안 성공여부 확인하기 위해 success 변수 선언
		int success = dao.offer(re_no, jpo_no);		
		logger.info("제안 성공 여부 :"+ success);
	}

	// by태섭, 개인 마이페이지 입사제안현황_2022_08_11
	public ArrayList<EnterDTO> clientOfferList(String cl_id, int skip, int amount) {
		logger.info("입사제안현황 리스트 서비스 요청");
		return dao.clientOfferList(cl_id,skip, amount);
	}
	
	// by태섭, 개인 회원이 받은 입사제안 총 개수_2022_08_12
    public int getOfferTotal(String cl_id) {
        return dao.getOfferTotal(cl_id);
    }    

    // by태섭, 받은 입사제안 삭제 요청 서비스
	public boolean deleteOffer(String[] chkArr) {
		logger.info("삭제 서비스 요청");
		return dao.deleteOffer(chkArr);
	}

	// by태섭, 채용 공고 클릭 시 열람여부 변경_2022_80_12
	//나중에 트랜잭션 걸어주자
	public void jobPostingDetail(int offer_no) {
		dao.upHit(offer_no);		
	}

	// by태섭, 개인 마이페이지 입사지원현황_2022_08_11
	public ArrayList<EnterDTO> clientApplyList(String cl_id, int skip, int amount) {
		logger.info("입사지원현황 리스트 서비스 요청");
		return dao.clientApplyList(cl_id,skip, amount);
	}

	// by태섭, 개인 회원 입사지원 총 개수_2022_08_12
	public int getApplyTotal(String cl_id) {
		return dao.getApplyTotal(cl_id);
	}


	

}
