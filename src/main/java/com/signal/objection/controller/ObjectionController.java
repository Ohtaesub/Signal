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

import com.signal.all.dto.ObjectionDTO;
import com.signal.objection.service.ObjectionService;

@Controller
public class ObjectionController {
	@Autowired ObjectionService service;
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	//이의제기관리(사용자)리스트
	@RequestMapping(value = "/clientObjectionList.go", method = RequestMethod.GET)
	public String clientObjectionList(Model model) {	
		ArrayList<ObjectionDTO>clientObjectionList =service.clientObjectionList();
		model.addAttribute("clientObjectionList",clientObjectionList);
	
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
	public String comObjectionList(Model model) {
		ArrayList<ObjectionDTO>comObjectionList =service.comObjectionList();
		model.addAttribute("comObjectionList",comObjectionList);
	
		return "comObjectionList";
	}
	
	//이의제기관리(관리자)리스트
	@RequestMapping(value = "/adminObjectionList.go", method = RequestMethod.GET)
	public String adminObjectionList(Model model) {
		ArrayList<ObjectionDTO>adminObjectionList =service.adminObjectionList();
		model.addAttribute("adminObjectionList",adminObjectionList);
	
		return "adminObjectionList";
	}
	
	//블라인드관리(관리자)리스트
	@RequestMapping(value = "/adminBlindList.go", method = RequestMethod.GET)
	public String adminBlindList(Model model) {
		
		ArrayList<ObjectionDTO>adminBlindList =service.adminBlindList();
		model.addAttribute("adminBlindList",adminBlindList);
	
		return "adminBlindList";
	}
	
}
