package com.signal.test.controller;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.signal.all.dto.TestDTO;
import com.signal.test.service.TestService;

@Controller
public class TestController {
	
	@Autowired TestService service;
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@RequestMapping(value = "selfInsert.go", method = RequestMethod.GET)
	public ModelAndView recommendGo(HttpSession session, Model model) {		
		
		String id = (String) session.getAttribute("loginId");
		/* String id ="aaaabbbb"; */
		
		return service.selfInsert(id);
	}
	
	@RequestMapping(value = "selfReg.go", method = RequestMethod.GET)
	public String selfRegGo(HttpSession session, Model model, String cl_id) {		
		ArrayList<TestDTO> list = service.selfRegGo();
		model.addAttribute("list", list);
		model.addAttribute("cl_id", cl_id);
		return "./selfTest/selfReg";
	}
	
	@RequestMapping(value = "selfReg.do", method = RequestMethod.POST)
	public String selfReg(HttpSession session, Model model, @RequestParam HashMap<String, Object>params) {	
		logger.info("params : {}",params);
		boolean result = service.selfReg(params);
		if(result) {
			String msg="셀프평가 등록이 완료되었습니다";
			model.addAttribute("msg", msg);
		} else {
			String msg="셀프평가 등록에 실패했습니다";
			model.addAttribute("msg", msg);
		}
		return "./selfTest/selfReg";
	}
	
	@RequestMapping(value = "selfTestQue.go", method = RequestMethod.GET)
	public String selfTestQueGo(HttpSession session, Model model) {		
		
		ArrayList<TestDTO> list = service.selfQueList();		
		model.addAttribute("list", list);
		model.addAttribute("state","all");
		return "./selfTest/selfTestQue";
	}
	
	@RequestMapping(value = "selfTestQueA.go", method = RequestMethod.GET)
	public String selfTestQueAGo(HttpSession session, Model model) {		
		
		ArrayList<TestDTO> list = service.selfQueListA();		
		model.addAttribute("list", list);
		model.addAttribute("state","hide");
		return "./selfTest/selfTestQue";
	}
	
	@RequestMapping(value = "selfTestQueB.go", method = RequestMethod.GET)
	public String selfTestQueBGo(HttpSession session, Model model) {		
		
		ArrayList<TestDTO> list = service.selfQueListB();		
		model.addAttribute("list", list);
		model.addAttribute("state","show");
		return "./selfTest/selfTestQue";
	}
	
	@RequestMapping(value = "stHiddenUp.do", method = RequestMethod.GET)
	public String stHiddenUp(HttpSession session, Model model,
			@RequestParam String st_no, @RequestParam String st_hidden, @RequestParam String state) {
		logger.info("state "+state);
		service.stHiddenUp(st_no, st_hidden);
		ArrayList<TestDTO> list;
		if(state.equals("all")) {
		list = service.selfQueList();
		} else if(state.equals("show")) {
			list=service.selfQueListB();
		} else {
			list = service.selfQueListA();
		}
		model.addAttribute("list", list);
		return "./selfTest/selfTestQue";
	}
	
	@RequestMapping(value = "interviewTestQue.go", method = RequestMethod.GET)
	public String interviewTestQueGo(HttpSession session, Model model) {		
		
		ArrayList<TestDTO> list = service.interviewQueList();
		model.addAttribute("list", list);
		return "/selfTest/interviewTestQue";
	}
	
	
	
}
