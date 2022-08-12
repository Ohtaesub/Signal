package com.signal.member.dao;

import java.util.HashMap;

import org.springframework.web.multipart.MultipartFile;

import com.signal.all.dto.MemberDTO;

public interface MemberDAO {

	String overlayClientId(String cl_id);

	String overlayEmail(String cl_email);

	// 개인회원 가입 dao ajax x
	
	
	//회원가입시 파일업로드랑 params dto로 담아넣는 방법 ***
	//int clientJoin(MemberDTO dto);
	int clientJoin(HashMap<String, String> params);

	//개인회원 로그인
	int clientMember(String id, String pw, String state);

	//기업회원 id 중복체크
	String overlayCompanyId(String com_id);

	//기업회원 email 중복체크
	String overlayComEmail(String com_email);

	// 기업회원 가입 ajax
	int joinCompany(HashMap<String, Object> params);

	// 기업회원 가입 ajax
	int joinClient(HashMap<String, Object> params);

	//기업회원 로그인
	int companyMember(String id, String pw, String state);

	// 개인회원 Id찾기
	String findClientId(String name, String email);

	// 기업회원 Id찾기
	String findCompanyId(String email, String number);

	// 개인회원 Pw찾기
	int findClientPw(String id, String name, String email);

	void clientPwChange(String id, String cl_pw);

	// 기업회원 Pw찾기
	int findCompanyPw(String id, String email, String number);

	void companyPwChange(String id, String com_pw);

	//파일 업로드 메서드
	//void fileWrite(String oriFileName, String newFileName, String clId);



	// 개인회원 가입 dao ajax
	//int clientJoin(HashMap<String, Object> params);

}
