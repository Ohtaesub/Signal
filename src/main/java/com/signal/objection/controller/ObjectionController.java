package com.signal.objection.controller;

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

import com.signal.all.dto.InterviewDTO;
import com.signal.all.dto.ObjectionDTO;
import com.signal.all.dto.PageMakerDTO;
import com.signal.enter.controller.Criteria;
import com.signal.objection.service.ObjectionService;

@Controller
public class ObjectionController {
	@Autowired ObjectionService service;
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	//이의제기관리(사용자)리스트
	@RequestMapping(value = "/clientObjectionList.go", method = RequestMethod.GET)
	public String clientObjectionList(Model model,Criteria cri,@RequestParam HashMap<String, Object> params) {	
		
		
		
				//String com_id = (String) session.getAttribute("loginId");
				//params.put("com_id", com_id);
				
				int pageNum = 1;
				if(params.get("pageNum") != null) {
					pageNum = (int) Integer.parseInt(String.valueOf(params.get("pageNum")));
				}
				
				int skip = (pageNum -1) * 10;
				
				
				//params.put("com_id", loginId);
				params.put("skip", skip);
				
				//페이지 리스트 수
				ArrayList<ObjectionDTO>clientObjectionList =service.clientObjectionList(params);
				model.addAttribute("clientObjectionList",clientObjectionList);
				
				//페이징처리 토탈개수
				int total = service.clientObjectionListTotal(params);
				
				PageMakerDTO pageMaker = new PageMakerDTO(cri, total);
				model.addAttribute("pageMaker", pageMaker);

		
		return "clientObjectionList";
	}
	//이의제기등록(사용자)
	@RequestMapping(value = "/clientDbjectionReg.do")
	public String clientDbjectionRegDo(HttpSession session,Model model,@RequestParam HashMap<String, String>params){		
			service.clientDbjectionRegDo(params);
		
			
		return "redirect:/interviewList.go";
	}
	
	//이의제기관리(기업)리스트
	@RequestMapping(value = "/comObjectionList.go", method = RequestMethod.GET)
	public String comObjectionList(Model model,Criteria cri,@RequestParam HashMap<String, Object> params) {
		//String com_id = (String) session.getAttribute("loginId");
		//params.put("com_id", com_id);
		
		int pageNum = 1;
		if(params.get("pageNum") != null) {
			pageNum = (int) Integer.parseInt(String.valueOf(params.get("pageNum")));
		}
		
		int skip = (pageNum -1) * 10;
		
		
		//params.put("com_id", loginId);
		params.put("skip", skip);
		
		//페이지 리스트 수
		ArrayList<ObjectionDTO>comObjectionList =service.comObjectionList(params);
		model.addAttribute("comObjectionList",comObjectionList);
		
		//페이징처리 토탈개수
		int total = service.comObjectionListTotal(params);
		
		PageMakerDTO pageMaker = new PageMakerDTO(cri, total);
		model.addAttribute("pageMaker", pageMaker);
		
		return "comObjectionList";
	}
	
	//이의제기 처리페이지(기업)
	@RequestMapping(value = "/comObjectionUpdate.go", method = RequestMethod.GET)
	public String comObjectionUpdate(Model model,@RequestParam String obj_no) {
		
		ObjectionDTO dto =service.comObjectionUpdate(obj_no);
		model.addAttribute("dto",dto);
	
		return "comObjectionUpdate";
	}
	//이의제기 처리페이지(기업) -업데이트
		@RequestMapping(value = "/comObjectionUpdate.do")
		public String comObjectionUpdateDo(HttpSession session,Model model
				,@RequestParam HashMap<String, String>params){
			String page ="redirect:/comObjectionList.go";
			
		
			service.comObjectionUpdateDo(params);
			
			return page;
		}
	
	//이의제기관리(관리자)리스트 페이징
	@RequestMapping(value = "/adminObjectionList.go", method = RequestMethod.GET)
	public String adminObjectionList(Model model,Criteria cri) {
		
		//페이징 리스트
		ArrayList<ObjectionDTO>adminObjectionList =service.adminObjectionList(cri);
		model.addAttribute("adminObjectionList",adminObjectionList);
		int pageNum=cri.getPageNum();
		model.addAttribute("pageNum",pageNum);
		
		//페이징 위한 게시글 토탈수
		int total=service.adminObjectionTotal();
		PageMakerDTO pageMaker =new PageMakerDTO(cri, total);
		model.addAttribute("pageMaker",pageMaker);
		
		
		
		return "adminObjectionList";
	}
	//이의제기관리(관리자)검색 페이징
	@RequestMapping(value="/adminObjectionList.do")
	public String adminObjectionSearch(Model model,HttpSession session,@RequestParam String searchOption, String search, int pageNum ) {
			logger.info("옵션 확인: "+searchOption+search);
		
			model.addAttribute("searchOption",searchOption);
			
			//옵션 페이징처리
			int skip=(pageNum-1) * 10;
			ArrayList<InterviewDTO>dto = service.adminObjectionSearch(searchOption, search,skip);
			model.addAttribute("adminObjectionList",dto);
			
			int adminObjectionTotal=service.adminObjectionTotal2(searchOption, search);
			model.addAttribute("pageNum",pageNum);
			
			PageMakerDTO pageMake2= new PageMakerDTO(pageNum, adminObjectionTotal);
			model.addAttribute("pageMaker", pageMake2);
			
		return "adminObjectionList";
	}
	//이의제기관리(관리자)-블라인드기능
	@RequestMapping(value = "/adminBlind")
	public String adminBlind(Model model, @RequestParam String inter_no) {

		
			service.adminBlind(inter_no);
	
		return "redirect:adminObjectionList.go";
	}
	

	//블라인드관리(관리자)리스트 -페이징
		@RequestMapping(value = "/adminBlindList.go", method = RequestMethod.GET)
		public String adminBlindList(Model model,Criteria cri) {
			
			//페이징 리스트
			ArrayList<ObjectionDTO>adminBlindList =service.adminBlindList(cri);
			model.addAttribute("adminBlindList",adminBlindList);
		
			
			int pageNum=cri.getPageNum();
			model.addAttribute("pageNum",pageNum);
			
			//페이징 위한 게시글 토탈수
			int total=service.adminBlindTotal();
			PageMakerDTO pageMaker =new PageMakerDTO(cri, total);
			model.addAttribute("pageMaker",pageMaker);
			

			return "adminBlindList";
		}
		//블라인드관리(관리자)검색 -페이징
		@RequestMapping(value="/adminBlindList.do")
		public String adminBlindSearch(Model model,HttpSession session,@RequestParam String searchOption, String search, int pageNum ) {
				logger.info("옵션 확인: "+searchOption+search);
			
				model.addAttribute("searchOption",searchOption);
				
				//옵션 페이징처리
				int skip=(pageNum-1) * 10;
				ArrayList<InterviewDTO>dto = service.adminBlindSearch(searchOption, search,skip);
				model.addAttribute("adminBlindList",dto);
				
				int adminBlindTotal=service.adminBlindTotal2(searchOption, search);
				model.addAttribute("pageNum",pageNum);
				
				PageMakerDTO pageMake2= new PageMakerDTO(pageNum, adminBlindTotal);
				model.addAttribute("pageMaker", pageMake2);
				
			return "adminBlindList";
		}
		
		
		
		
		
		
	//블라인드관리(관리자)-블라인드취소기능
	@RequestMapping(value = "/adminBlindCancel")
	public String adminBlindCancel(Model model, @RequestParam String inter_no) {

			service.adminBlindCancel(inter_no);
	
		return "redirect:adminBlindList.go";
	}
	
	
}
