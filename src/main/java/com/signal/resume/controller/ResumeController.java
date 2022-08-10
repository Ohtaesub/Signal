package com.signal.resume.controller;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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

		/*
		 * ArrayList<ResumeDTO> list = service.personList();
		 * logger.info("결과 확인 : 리스트 개수=" +list.size()); model.addAttribute("list",
		 * list);
		 */
		
		return "./resume/personList";
	}
	
	
	//리스트 호출
	@RequestMapping("/personList.ajax")
	@ResponseBody
	public HashMap<String, Object> personList2(@RequestParam HashMap<String, String> params) {
		logger.info("과정 리스트 요청 : "+params);	
	
		HashMap<String, Object> map = service.personList2(params);		
		logger.info("리스트 불러오기");
		return map;
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
	
	@RequestMapping(value = "resumeReg.go", method = RequestMethod.GET)
	public String resumeReg(HttpSession session, Model model) {		
		
		/* String id = (String) session.getAttribute("loginId"); */
		String id = "aaaabbbb";
		logger.info(id + " 의 이력서 등록페이지 이동");
		ResumeDTO dto = service.resumeRegDetail(id);
		model.addAttribute("cl_id", id);	
		model.addAttribute("dto", dto);
		
		return "./resume/resumeReg";
	}
	
	@RequestMapping(value = "/resumeReg.do")
	public String write(@RequestParam HashMap<String, String> params, 
			HttpSession session, Model model) {
		
			logger.info("params : {}",params);
					
		return service.resumeReg(params);
	}
	
	@RequestMapping(value = "resumeAddReg.go", method = RequestMethod.GET)
	public String resumeAddReg(Model model, @RequestParam String re_no) {		
		
		logger.info(re_no + "번 이력서 추가정보 등록 요청");
		
		ArrayList<ResumeDTO> careerDto = service.careerDetail(re_no);
		ArrayList<ResumeDTO> socialDto = service.socialDetail(re_no);
		ArrayList<ResumeDTO> licenseDto = service.licenseDetail(re_no);	
		
		model.addAttribute("re_no", re_no);
		model.addAttribute("careerDto", careerDto);
		model.addAttribute("socialDto", socialDto);
		model.addAttribute("licenseDto", licenseDto);
		return "./resume/resumeAddReg";
	}
	
	@RequestMapping(value = "careerReg.go", method = RequestMethod.GET)
	public String careerReg(Model model, @RequestParam String re_no) {		
		
		logger.info(re_no + "번 이력서 경력사항 등록 요청");
		model.addAttribute("re_no", re_no);
		return "./resume/careerRegPop";
	}
	
	@RequestMapping(value = "careerUp.go", method = RequestMethod.GET)
	public String careerUp(Model model, @RequestParam String re_no) {		
		
		logger.info(re_no + "번 이력서 경력사항 수정 요청");
		
		ArrayList<ResumeDTO> careerDto = service.careerDetail(re_no);
		
		model.addAttribute("re_no", re_no);
		model.addAttribute("careerDto", careerDto);
		
		return "./resume/careerUpPop";
	}
	
	@RequestMapping(value = "socialReg.go", method = RequestMethod.GET)
	public String socialReg(Model model, @RequestParam String re_no) {		
		
		logger.info(re_no + "번 이력서 그 외 활동 등록 요청");
		model.addAttribute("re_no", re_no);
		return "./resume/socialRegPop";
	}
	
	@RequestMapping(value = "socialUp.go", method = RequestMethod.GET)
	public String socialUp(Model model, @RequestParam String re_no) {		
		
		logger.info(re_no + "번 이력서 그 외 활동 수정 요청");
		
		ArrayList<ResumeDTO> socialDto = service.socialDetail(re_no);
		
		model.addAttribute("re_no", re_no);
		model.addAttribute("socialDto", socialDto);
		
		return "./resume/socialUpPop";
	}
	
	@RequestMapping(value = "licenseReg.go", method = RequestMethod.GET)
	public String licenseReg(Model model, @RequestParam String re_no) {		
		
		logger.info(re_no + "번 이력서 자격증,수상내역 등록 요청");
		model.addAttribute("re_no", re_no);
		return "./resume/licenseRegPop";
	}
	
	@RequestMapping(value = "licenseUp.go", method = RequestMethod.GET)
	public String licenseUp(Model model, @RequestParam String re_no) {		
		
		logger.info(re_no + "번 이력서 자격증,수상내역 수정 요청");
		
		ArrayList<ResumeDTO> licenseDto = service.licenseDetail(re_no);
		
		model.addAttribute("re_no", re_no);
		model.addAttribute("licenseDto", licenseDto);
		
		return "./resume/licenseUpPop";
	}
	
	@RequestMapping(value = "resumeUpdate.go", method = RequestMethod.GET)
	public String resumeUpdate(Model model, @RequestParam String re_no) {		
		
		logger.info(re_no + "번 이력서 수정 요청");
		
		ResumeDTO dto = service.resumeDetail(re_no);
		ArrayList<ResumeDTO> careerDto = service.careerDetail(re_no);
		ArrayList<ResumeDTO> socialDto = service.socialDetail(re_no);
		ArrayList<ResumeDTO> licenseDto = service.licenseDetail(re_no);		
		String page = "./resume/resumeUpdate";
		
		model.addAttribute("dto", dto);
		model.addAttribute("careerDto", careerDto);
		model.addAttribute("socialDto", socialDto);
		model.addAttribute("licenseDto", licenseDto);
		model.addAttribute("re_no", re_no);
		return page;
		
	}
	
	@RequestMapping(value = "/careerReg.do")
	public ModelAndView careerReg(@RequestParam HashMap<String, String> params, 
			HttpSession session, Model model) {
		
		logger.info("params : {}",params);	
		
		return service.careerReg(params);
	}
	
	@RequestMapping(value = "/socialReg.do")
	public ModelAndView socialReg(@RequestParam HashMap<String, String> params, 
			HttpSession session, Model model) {
		
		logger.info("params : {}",params);	
		
		return service.socialReg(params);
	}
	
	@RequestMapping(value = "/licenseReg.do")
	public ModelAndView licenseReg(@RequestParam HashMap<String, String> params, 
			HttpSession session, Model model) {
		
		logger.info("params : {}",params);	
		
		return service.licenseReg(params);
	}
	
	
}
