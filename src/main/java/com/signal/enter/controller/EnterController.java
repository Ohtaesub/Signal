package com.signal.enter.controller;

import java.util.ArrayList;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.signal.all.dto.EnterDTO;
import com.signal.all.dto.JobPostingDTO;
import com.signal.all.dto.ResumeDTO;
import com.signal.enter.service.EnterService;

//by태섭, 관리자 마이페이지 입사제안관리 기능 2022년 8월 8일

@Controller
public class EnterController {

	Logger logger = LoggerFactory.getLogger(this.getClass());
	// by태섭, service 객체를 한 번만 선언하고 계속 사용한다.
	@Autowired EnterService service;
	
	// by태섭, 입사제안현황 페이지로 이동 시 리스트 호출
	// 나중에 로그인 세션 적용해서 해당 기업이 제안한 현황만 보여주자
	@RequestMapping(value = "/companyOfferList.do", method = RequestMethod.GET)
	public String companyOfferList(Model model /*@RequestParam String com_id*/) {
		logger.info("입사제안현황 리스트 요청");
		ArrayList<EnterDTO> offerList = service.offerList();
		model.addAttribute("offerList", offerList);
		return "companyOfferList"; 
	}
	
	// by태섭, 기업이 일반회원에게 입사제안 페이지 이동_2022_08_10 
	@RequestMapping(value = "/offer.go")
	public String offer(Model model, @RequestParam int re_no) {
		logger.info("입사제안 요청 이력서 번호 : "+re_no);
		logger.info("채용공고 리스트 호출");
		// by태섭, 나중에 해당 기업이 올린 공고리스트만 보여줘야 한다. 인자값으로 com_id
		// by태섭, 기업 채용공고 리스트 호출
		ArrayList<JobPostingDTO> jobPostingList = service.jobPostingList();
		model.addAttribute("jobPostingList", jobPostingList);
		model.addAttribute("re_no",re_no);
		// by태섭, 해당 이력서에 대한 회원 정보
		ArrayList<ResumeDTO> personInfo = service.personInfo(re_no);
		model.addAttribute("personInfo", personInfo);
		return "personOffer";
	}
	
	// by태섭, 기업이 일반회원에게 입사제안_2022_08_10 
	@RequestMapping(value = "/offer.do")
	public String offerDo(Model model, @RequestParam int re_no, int jpo_no ) {
		logger.info("입사제안 요청 이력서 번호 : "+re_no);		
		logger.info("입사제안 요청 공고 번호 : "+jpo_no);
		
		service.offer(re_no, jpo_no);
		return "./resume/personList";
	}
	
	
	// by태섭, 기업 채용공고 리스트 호출_2022_08_09 
	/* 입사제안 팝업창 시도 코드 
	@RequestMapping(value = "/jobPostingList.go") 
	public String jobPostingList(Model model) { 
		logger.info("채용공고 리스트 호출"); // 나중에 해당 기업이 올린 공고리스트만 보여줘야 한다. 인자값으로 com_id 
		ArrayList<JobPostingDTO> jobPostingList = service.jobPostingList(); 
		model.addAttribute("jobPostingList", jobPostingList); 
		return "comOfferJobPostingList"; 
	}
	*/
	
	
	// by태섭, 개인 마이페이지 입사제안현황 기능_2022_08_11
	@RequestMapping(value = "/clientOfferList.go")
	public String clientOfferList(Model model) {
		// by태섭, 나중에 개인 회원에 해당하는 리스트만 보여주기, 인자값에 id값을 넣어주자
		logger.info("입사제안 리스트 호출");
		ArrayList<EnterDTO> clientOfferList = service.clientOfferList();
		model.addAttribute("clientOfferList", clientOfferList);
		return "clientOfferList";
	}
	
	// by태섭, 개인 입사제안 선택 후 삭제 기능_2022_08_11	
	@RequestMapping(value = "/deleteOffer.do", method = RequestMethod.POST)
	public String delete(Model model, @RequestParam String[] chkArr) {//같은 이름으로 여러 개 올 경우 이렇게 받아줘야 한다.
		
		logger.info("입사제안 삭제 요청");
		// by태섭, 제안 삭제 요청 chkArr에 offer_no 담아서 삭제 요청
		boolean success = service.deleteOffer(chkArr);
		logger.info("삭제 성공 여부 : "+success);
		// by태섭, 삭제 후 다시 입사제안현황 페이지로 보내주자
		return "redirect:/clientOfferList.go";
	}
	
	//by태섭, 개인 입사지원 현황 리스트 호출_2022_08_11
	@RequestMapping(value = "/clientApplyList.go")
	public String clientApplyList(Model model) {
		// by태섭, 나중에 개인 회원에 해당하는 리스트만 보여주기, 인자값에 id값을 넣어주자
		logger.info("입사지원 리스트 호출");
		ArrayList<EnterDTO> clientApplyList = service.clientApplyList();
		model.addAttribute("clientApplyList", clientApplyList);
		return "clientApplyList";
	}
	
	
	
	
	
	
}
