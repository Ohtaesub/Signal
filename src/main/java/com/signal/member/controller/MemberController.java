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
		
		//임시로 보낸것임 바꿔주어야함 주소
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
	
	
	// 개인회원,기업회원 이메일 중복체크
	@RequestMapping("/overlayEmail.ajax")
	@ResponseBody
	public HashMap<String, Object>overlayEmail(@RequestParam String chkEmail) {
		logger.info("이메일 중복 체크 : "+chkEmail);
		return service.overlayEmail(chkEmail);
	}
	
	
	// 개인회원 회원가입 요청
	@RequestMapping(value="clientJoin.do")
	public String clientJoin(Model model,@RequestParam HashMap<String, String>params) {
		logger.info("회원가입 요청!"+params);
		int success=service.clientJoin(params);
		String msg = "회원가입에 실패하였습니다.";
		
		if(success>0) {
			msg="회원가입에 성공하셨습니다.";
		}
		
		// 회원가입 성공 여부 출력창 스크립트에 달아주기 위함
		model.addAttribute("msg",msg);
		// 임시 페이지 다른 곳으로 주소 바꿀것!
		return "login";
	}
	
	@RequestMapping(value = "/clientPhotoUploadForm.go")
	public String clientPhotoUploadForm() {

		return "clientPhotoUploadForm";
	}
	
	
}
