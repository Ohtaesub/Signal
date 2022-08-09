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

import com.signal.all.dto.InterviewDTO;
import com.signal.interview.service.InterviewService;
@Controller
public class InterviewController {
	@Autowired InterviewService service;
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	//면접현황리스트 (개인)
	@RequestMapping(value = "/interviewList.go", method = RequestMethod.GET)
	public String interviewList(Model model) {
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
	public String comInterviewList(Model model) {
		ArrayList<InterviewDTO>comInterviewList =service.comInterviewList();
		model.addAttribute("comInterviewList",comInterviewList);
	
		return "comInterviewList";
	}
	//면접관리(기업)-일정변경페이지 이동
	@RequestMapping(value = "/comInterviewDate.go", method = RequestMethod.GET)
	public String comInterviewDate(Model model,@RequestParam String inter_no) {
		
		InterviewDTO dto =service.interviewDetail(inter_no);
		model.addAttribute("dto",dto);
		return "comInterviewDate";
	}
	//면접관리(기업)-일정변경 업데이트
	@RequestMapping(value = "/comInterviewDate.do")
	public String update(HttpSession session,Model model
			,@RequestParam HashMap<String, String>params){
		String page ="redirect:/comInterviewList.go";
		
	
		service.comInterviewDateDo(params);
		return page;
	}
	
}
