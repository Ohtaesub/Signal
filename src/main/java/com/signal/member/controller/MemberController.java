package com.signal.member.controller;

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

import com.signal.member.service.MemberService;

@Controller
public class MemberController {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired MemberService service;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String home(Model model) {
		
		return "login";
	}
	
	// login 팝업창 띄우기
	@RequestMapping(value = "/loginPopup.go")
	public String loginPopup() {

		return "loginPopup";
	}
	
	// 회원가입 회원선택 페이지 이동
	@RequestMapping(value = "/joinSelect.go")
	public String joinSelect() {
		logger.info("회원가입 선택페이지 이동");
		return "joinSelect";
	}
	
	// 개인회원 가입페이지 이동
	@RequestMapping(value = "/joinFormClient.go")
	public String joinFormClient() {

		return "joinFormClient";
	}
	
	// 개인회원 아이디 중복체크
	@RequestMapping("/overlayClientId.ajax")
	@ResponseBody
	public HashMap<String, Object>overlayClientId(@RequestParam String chkclId) {
		logger.info("아이디 중복 체크 : "+chkclId);
		return service.overlayClientId(chkclId);
	}
	
	
}
