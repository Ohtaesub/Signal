package com.signal.member.service;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.signal.member.dao.MemberDAO;

@Service
public class MemberService {

	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired MemberDAO dao;
	
	// 개인회원 아이디 중복확인
	public HashMap<String, Object> overlayClientId(String cl_id) {
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		String overclId = dao.overlayClientId(cl_id);
		logger.info("중복된 아이디 인가요? : "+overclId);
		//중복된 아이디이면 중복 아이디:(중복아이디)가 보여짐 -> 사용불가 아이디
		//사용가능한 아이디이면 중복 아이디:(null)이 보여짐 ->사용가능 아이디
		boolean over = overclId == null?false:true;
		map.put("overlayClientId", over);
		
		return map;
	}

	// 개인회원 이메일 중복확인
	public HashMap<String, Object> overlayEmail(String cl_email) {
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		String overClientEmail=dao.overlayEmail(cl_email);
		logger.info("중복된 이메일 인가요? : "+overClientEmail);
		//중복된 이메일이면 중복 이메일:(중복이메일)이 보여짐 ->사용불가 이메일
		//사용가능한 이메일이면 중복 이메일:(null)이 보여짐 ->사용가능 이메일
		boolean over = overClientEmail ==null?false:true;
		map.put("overlayEmail", over);
		
		return map;
	}

	public int clientJoin(HashMap<String, String> params) {
		logger.info("회원가입 서비스 요청!");
		return dao.clientJoin(params);
	}

}
