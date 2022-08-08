package com.signal.resume.controller;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.signal.all.dto.ResumeDTO;
import com.signal.resume.service.ResumeService;

@Controller
public class ResumeController {

	@Autowired ResumeService service;
	Logger logger = LoggerFactory.getLogger(this.getClass());

	// 이력서 리스트 불러오기
	// cl_id 세션값으로 해당 id에 맞는 리스트만 불러오기
	// 우선 메인페이지 제작 전 전체 리스트 호출로 수정 진행
	@RequestMapping(value = "resumeList.go", method = RequestMethod.GET)
	public String resumeList(Model model) {		
		
		logger.info("이력서 리스트 요청");
		
		// * 추후에 아이디 값 가져가기
		ArrayList<ResumeDTO> list = service.list();
		logger.info("결과 확인 : 리스트 개수=" +list.size());
		model.addAttribute("list", list);
		
		return "./resume/resumeList";
	}
	
	
	// 인재현황 리스트 불러오기
	
	@RequestMapping(value = "personList.go", method = RequestMethod.GET)
	public String personList(Model model) {		
		
		logger.info("인재현황 리스트 요청");

		ArrayList<ResumeDTO> list = service.personList();
		logger.info("결과 확인 : 리스트 개수=" +list.size());
		model.addAttribute("list", list);
		
		return "./resume/personList";
	}
	
	// 이력서 상세보기
	@RequestMapping(value = "resumeDetail.do", method = RequestMethod.GET)
	public String resumeDetail(Model model, @RequestParam String re_no) {
		ResumeDTO dto = service.resumeDetail(re_no);
		ArrayList<ResumeDTO> careerDto = service.careerDetail(re_no);
		ArrayList<ResumeDTO> socialDto = service.socialDetail(re_no);
		ArrayList<ResumeDTO> licenseDto = service.licenseDetail(re_no);		
		String page = "./resume/resumeDetail";
		
		model.addAttribute("dto", dto);
		model.addAttribute("careerDto", careerDto);
		model.addAttribute("socialDto", socialDto);
		model.addAttribute("licenseDto", licenseDto);
		
		return page;
	}
	
	
	
	
	
}
