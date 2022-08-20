package com.signal.interview.controller;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.signal.all.dto.EnterDTO;
import com.signal.all.dto.InterviewDTO;
import com.signal.all.dto.JobPostingDTO;
import com.signal.all.dto.PageMakerDTO;
import com.signal.enter.controller.Criteria;
import com.signal.interview.service.InterviewService;
@Controller
public class InterviewController {
	@Autowired InterviewService service;
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	//면접현황리스트 (개인)
	@RequestMapping(value = "/interviewList.go", method = RequestMethod.GET)
	public String interviewList(Model model) {
		
		//String cl_id = (String) session.getAttribute("loginId");
		//params.put("com_id", com_id);
		
		//면접현황리스트부분
		ArrayList<InterviewDTO>interviewList =service.interviewList();
		model.addAttribute("interviewList",interviewList);
		//평균평점
		float avgGrade =service.avgGrade();
		model.addAttribute("avgGrade",avgGrade);
		//총코멘트수
		int countComment =service.countComment();
		model.addAttribute("countComment",countComment);
		
		return "interviewList";
	}
	
	//이의제기등록페이지
	@RequestMapping(value = "/clientObjectionReg.go", method = RequestMethod.GET)
	public String clientObjectionReg(Model model,@RequestParam String inter_no) {
		
		InterviewDTO dto =service.clientObjectionReg(inter_no);
		model.addAttribute("dto",dto);
	
		return "clientObjectionReg";
	}
	
	//면접현황상세 (개인) 
	@RequestMapping(value = "/interviewDetail.go", method = RequestMethod.GET)
	public String interviewDetail(Model model,@RequestParam String inter_no) {
		
		//면접현황상세
		InterviewDTO dto =service.interviewDetail(inter_no);
		model.addAttribute("dto",dto);
		
		//면접현황상세-평점상세내역리스트
		ArrayList<InterviewDTO>interviewDetailResultList =service.interviewDetailResultList(inter_no);
		model.addAttribute("interviewDetailResultList",interviewDetailResultList);
		
		return "interviewDetail";
	}
	//면접관리리스트(기업)
	@RequestMapping(value = "/comInterviewList.go", method = RequestMethod.GET)
	public String comInterviewList(Model model,Criteria cri) {
	
		ArrayList<InterviewDTO>comInterviewList =service.comInterviewList(cri);
		model.addAttribute("comInterviewList",comInterviewList);
		int pageNum=cri.getPageNum();
		model.addAttribute("pageNum",pageNum);
		int total=service.getTotal();
		
		PageMakerDTO pageMaker =new PageMakerDTO(cri, total);
		model.addAttribute("pageMaker",pageMaker);
		return "comInterviewList";
	}
	//면접관리리스트(기업)검색
	@RequestMapping(value="/comInterviewList.do")
	public String comInterviewList(Model model,HttpSession session,@RequestParam String searchOption, String search, int pageNum ) {
			
			//String com_id = (String) session.getAttribute("loginId");
			//params.put("com_id", com_id);
		
		
			logger.info("옵션 확인: "+searchOption+search);
		
			model.addAttribute("searchOption",searchOption);
			
			//옵션 페이징처리
			int skip=(pageNum-1) * 10;
			ArrayList<InterviewDTO>dto = service.comSearchList(searchOption, search,skip);
			model.addAttribute("comInterviewList",dto);
			
			int comSearchTotal=service.comSearchTotal(searchOption, search);
			model.addAttribute("pageNum",pageNum);
			
			PageMakerDTO pageMake2= new PageMakerDTO(pageNum, comSearchTotal);
			model.addAttribute("pageMaker", pageMake2);
			
		return "comInterviewList";
	}
	
	
	
	
	//면접관리리스트(기업) 결과등록 페이지 이동
	//comInterviewReg.go
	@RequestMapping(value = "/comInterviewReg.go", method = RequestMethod.GET)
	public String comInterviewReg(Model model,@RequestParam String inter_no) {
		
		//면접결과
		InterviewDTO dto =service.comInterviewRegState(inter_no);
		model.addAttribute("dto",dto);
		
		//질문리스트(노출체크된질문 가져오기)
		ArrayList<InterviewDTO>comInterviewRegQue =service.comInterviewRegQue();
		model.addAttribute("que",comInterviewRegQue);
		
		return "comInterviewReg";
	}
	
	//면접관리리스트(기업) 결과등록 
	//comInterviewReg.do
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//면접관리리스트(기업)- 결과수정 페이지 이동 
	@RequestMapping(value = "/comInterviewUpdate.go", method = RequestMethod.GET)
	public String comInterviewUpdate(Model model,@RequestParam String inter_no) {
		
		//면접결과,코멘트
		InterviewDTO dto =service.comInterviewUpdate(inter_no);
		model.addAttribute("dto",dto);
		
		//등록된 질문 리스트 
		//ArrayList<InterviewDTO> queList = service.queList();
		//model.addAttribute("queList",queList);
		
		//선택한질문, 점수 선택 
		ArrayList<InterviewDTO>comInterviewUpdateQue =service.comInterviewUpdateQue(inter_no);
		model.addAttribute("que",comInterviewUpdateQue);
		
		return "comInterviewUpdate";
	}
	
	//면접관리리스트(기업)-결과수정 - 수정 
	//@RequestMapping(value = "/comInterviewUpdate.do")
	//public ModelAndView comInterviewUpdateDo(@RequestParam HashMap<String, String>params){	
		//ModelAndView mav =new ModelAndView();
		//String pclose="pclose";
		//String page="comInterviewUpdate";
		//logger.info("params:{}",params);
		//System.out.println(params);
	
		//ArrayList<String> inter_no = (ArrayList<String>) params.get("inter_no");
		//ArrayList<String> it_no = (ArrayList<String>) values.get("it_no");
		//ArrayList<String> inter_score = (ArrayList<String>) values.get("inter_score");
	
		
		//service.comInterviewUpdateDo(params);
		//mav.setViewName(page);
		//mav.addObject("pclose",pclose);
		
		//return mav;
	//}
	
	//면접관리(기업)-일정변경페이지 이동
	@RequestMapping(value = "/comInterviewDate.go", method = RequestMethod.GET)
	public String comInterviewDate(Model model,@RequestParam String inter_no) {
		
		InterviewDTO dto =service.interviewDetail(inter_no);
		model.addAttribute("dto",dto);
		
		
		
		return "comInterviewDate";
	}
	//면접관리(기업)-일정변경 업데이트
	@RequestMapping(value = "/comInterviewDate.do")
	public ModelAndView update(HttpSession session,Model model
			,@RequestParam HashMap<String, String>params){
		ModelAndView mav =new ModelAndView();
		String pclose="pclose";
		String page="comInterviewDate";
	
		service.comInterviewDateDo(params);
		mav.setViewName(page);
		mav.addObject("pclose",pclose);
	
		return mav;
	}
	
	
	
	
	// by태섭, 기업 마이페이지 입사지원 관리 리스트 호출_2022_08_17
	@RequestMapping(value = "/companyApplyList.go")
	public String companyApplyList(Model model, Criteria cri, HttpSession session) {
		logger.info("기업 입사지원 리스트 호출");
		
		// by태섭, 세션에서 회원 아이디 값 가져오기
		String com_id = (String) session.getAttribute("loginId");
		// 기업 채용 공고명 가져오기 
		ArrayList<JobPostingDTO> jobPostingList = service.jobPostingList(com_id);
		model.addAttribute("jobPostingList", jobPostingList);
		// by태섭, 페이징 처리에 skip, amount 변수
		int skip = cri.getSkip();
		int amount = cri.getAmount();
		//  by태섭, 페이징 처리한 리스트 호출
		ArrayList<EnterDTO> companyApplyList = service.companyApplyList(com_id,skip,amount);
		model.addAttribute("companyApplyList", companyApplyList);
		// by태섭, 페이징 인터페이스 처리 부분
		int total = service.getCompanyApplyTotal(com_id);
		PageMakerDTO pageMake = new PageMakerDTO(cri, total);
	    //PageMaker 데이터를 view로 보내기 위함
	    model.addAttribute("pageMaker", pageMake);
	    return "companyApplyList";
	}
		
	// by태섭, 선택된 채용공고에 따른 리스트 페이징 처리_2022_02_20
	@RequestMapping(value = "/jobPostingApplyList.do")
	public String jobPostingApplyList(Model model, Criteria cri, HttpSession session, @RequestParam String jpo_no) {
		logger.info("채용공고별 리스트 호출");
		String com_id = (String) session.getAttribute("loginId");
		int skip = cri.getSkip();
		int amount = cri.getAmount();
		//셀렉트 박스에서 값을 선택했을 때 고정하기 위해 
		model.addAttribute("jpo_no", jpo_no);
		// 기업 채용 공고명 가져오기 
		ArrayList<JobPostingDTO> jobPostingList = service.jobPostingList(com_id);
		model.addAttribute("jobPostingList", jobPostingList);
		// 선택된 채용공고에 따른 지원자 리스트 호출
		ArrayList<EnterDTO> jobPostingApplyList = service.jobPostingApplyList(com_id, jpo_no, skip, amount);
		model.addAttribute("companyApplyList", jobPostingApplyList);
		// 선택된 채용공고에 따른 지원자 총 수
		int total = service.getJobPostingApplyTotal(com_id,jpo_no);
		PageMakerDTO pageMake = new PageMakerDTO(cri, total);
		model.addAttribute("pageMaker", pageMake);
			
		return "companyApplyList";
	}
		
		
	// by태섭, 기업 마이페이지 입사지원 관리 리스트에서 면접 상태 선택 팝업창_2022_08_17
	@RequestMapping(value = "/companyApplyPopup.go")
	public String companyApplyPopup(Model model, @RequestParam String inter_no) {
		logger.info("팝업창 띄우기");
	    logger.info("면접 번호 : "+inter_no);
	    //String interResult = service.interResult(inter_no);
	    EnterDTO dto = service.interResultList(inter_no);
	    model.addAttribute("interResult", dto);
		return "interviewResultPopup";
	}
		
	// by태섭, 기업 마이페이지 입사지원 관리 팝업창에서 면접 상태 저장하기_2022_08_17
	@RequestMapping(value = "/interviewSave.do", method = RequestMethod.GET)
	public String interviewSave(Model model, @RequestParam int inter_no, String inter_date, String inter_result) {
		logger.info("면접 번호 : "+inter_no);
			
		// by태섭, 팝업창 닫기 위해 변수 선언
		String popupClose = "popupClose";

		//String page = "redirect:/companyApplyList.go";
			
		// by태섭, 수정이 성공했는지 확인하기 위해 
		boolean success = service.interviewSave(inter_no, inter_date, inter_result);
		logger.info("상태 변경 성공 여부 : "+success);
		
		model.addAttribute("popupClose", popupClose);		
			
		return "interviewResultPopup";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
