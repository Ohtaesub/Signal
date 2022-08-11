package com.signal.jobposting.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.signal.all.dto.JobPostingDTO;
import com.signal.jobposting.dao.JobPostingDAO;
import com.signal.jobposting.service.JobPostingService;


@Controller
public class JobPostingController {


	@Autowired JobPostingService service;
	@Autowired JobPostingDAO dao;
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	   //로그인 관련 - 완
	   @RequestMapping(value = "/login.do")
	   public String login(Model model, HttpServletRequest request) throws Exception {
	      logger.info("로그인 페이지 입장");
	      String com_id = request.getParameter("com_id");
	      String com_pw = request.getParameter("com_pw");
	      logger.info(com_id+"/"+com_pw);
	      String loginId = service.login(com_id,com_pw);
	      logger.info("로그인 아이디 : "+loginId);
	      HttpSession session = request.getSession();
	      session.setAttribute("loginId", loginId);
	      String page = "alert";
	      if(loginId != null) {
	         // model.addAttribute("url", "/companyInfo.go");
	    	 model.addAttribute("url", "/companyInfo.go");
	         model.addAttribute("msg", loginId+"님 환영합니다.");
	      }else{
	         model.addAttribute("msg", "아이디 또는 비밀번호를 확인해주세요.");
	         model.addAttribute("url", "/login.go");
	      }
	      return page;
	   }

	// 기업정보 불러오기
	   @RequestMapping(value = "/companyInfo.go")
		public String companyInfo(Model model, HttpSession session) {
				String id = (String) session.getAttribute("loginId");
				logger.info(id+"의 기업정보 유무확인 및 불러오기");

				String ceo = service.ComDetail(id);
				String no = service.file(id);
				
				logger.info("대표자명: "+ceo);
				logger.info("기업번호: "+no);
				
				String url = "/companyInfoWrite.go";
				if(ceo != null) {
					JobPostingDTO dto = service.ComInfoDetail(id,ceo,no);
					model.addAttribute("dto",dto);				
				}
				
			return "companyInfo2";
		}
	
	
	/* 기업정보 페이지(대표자명 받아와서 존재하면 보여주고 존재하지 않으면 등록 페이지로)
	@RequestMapping(value = "/companyInfo.go")
	public String companyInfo(Model model, HttpSession session) {
			String id = (String) session.getAttribute("loginId");
			logger.info(id+"의 기업정보 유무확인");		
			String ceo = service.ComDetail(id);
			logger.info(ceo+": 대표자명 ");
			String url = "/companyInfoWrite.go";
			if(ceo != null) {
				JobPostingDTO dto = service.ComInfoDetail(id,ceo,);
				model.addAttribute("dto",dto);				
			}
			
		return "companyInfo";
	}
	*/
	
	
	
	
	// 기업정보 등록페이지 이동(+기업명)
	@RequestMapping(value = "/companyInfoWrite.go")
	public String infoWritePage(Model model, HttpSession session) {
		String id = (String) session.getAttribute("loginId");
		
		logger.info("로그인 아이디: "+id+" / "+"기업정보 등록페이지로 이동");
		
		JobPostingDTO dto = service.infoCom(id);
		logger.info("기업명과 아이디? "+dto);
		model.addAttribute("dto",dto);
			
		return "companyInfoWrite";
	}
	
	// 기업정보 등록(+사진 저장)
	@RequestMapping(value = "/companyInfoWrite.do")
	public String infoWrite(MultipartFile[] ci_photo, @RequestParam HashMap<String, String> params, 
			HttpServletRequest session,  Model model) {
		
		logger.info("기업로고사진 = " + ci_photo);
		logger.info("param : {}",params);

		int sum = service.infoWrite(ci_photo,params);
		String msg = "기업정보 등록에 실패하였습니다.";
		if(sum > 0) {
			msg = "기업정보 등록이 완료되었습니다.";
		}
		model.addAttribute("msg",msg);
		model.addAttribute("url","/companyInfo.go");
		
		return "alert";
	}

	// 기업정보 수정하기 페이지로
	@RequestMapping(value = "/companyInfoUpdate.go")
	   public String comInfoUpdate(Model model,HttpSession session) {
			
			String id = (String) session.getAttribute("loginId");
			logger.info(id+"수정 상세보기 페이지 이동");
			JobPostingDTO dto = service.comUpdate(id);
			model.addAttribute("dto",dto);
			logger.info("담겻?"+dto);
	      return "companyInfoDetail";
	   }

	// 기업정보 수정하기
	@RequestMapping(value = "/companyInfoUpdate.do")
	   public String update(MultipartFile[] ci_photo, Model model, @RequestParam HashMap<String, String> params,
			   HttpSession session) {

			String id = (String) session.getAttribute("loginId");
			logger.info(id+": 아이디");
		    logger.info("param : {}",params);

		    int num = service.update(ci_photo, params,id);
		    if(num>0) {
		         model.addAttribute("msg", "수정에 성공하였습니다.");
		         model.addAttribute("url", "/companyInfo.go");
		      }else {
		    	  model.addAttribute("msg", "수정에 실패하였습니다.");
		    	  model.addAttribute("url", "/companyInfo.go");
		      }
		    
	      return "alert";
	}
	
	/*
	 * // 기업정보 상세보기
	 * 
	 * @RequestMapping(value = "/companyInfo.do") public String
	 * companyInfoDetail(Model model, HttpSession session,
	 * 
	 * @RequestParam String ci_ceo) { String id = (String)
	 * session.getAttribute("loginId"); logger.info(id+"의 기업정보 상세보기");
	 * 
	 * String url = "/companyInfoWrite.go"; if(ci_ceo != null) { JobPostingDTO dto =
	 * service.ComInfoDetail(id,ci_ceo); model.addAttribute("dto",dto); }
	 * 
	 * return "companyInfo"; }
	 */
	
	
	
	
	
	@RequestMapping(value = "/jobPosting/list.go")
	public String jobPostingCom() {
			logger.info("기업 채용공고 페이지 이동");
		return "jobPostingCom";
	}
	
	@RequestMapping(value = "/jobPosting/list.do")
	public String jobPostingList() {
		
		
		return "jobPostingCom";
	}
	
	
	
	
}
