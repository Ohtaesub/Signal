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
	
	/* 로그인 int로 받는 경우
	//개인회원 로그인
	int clientMember(String id, String pw, String state);

	//기업회원 로그인
	int companyMember(String id, String pw, String state);
	*/
	
	//개인회원 로그인
	String clientLogin(String id, String pw);

	MemberDTO clientdto(String clientLogin);

	//기업회원 로그인
	String companyLogin(String id, String pw);

	MemberDTO companydto(String companyLogin);

	//기업회원 id 중복체크
	String overlayCompanyId(String com_id);

	//기업회원 email 중복체크
	String overlayComEmail(String com_email);

	// 기업회원 가입 ajax
	int joinCompany(HashMap<String, Object> params);

	// 기업회원 가입 ajax
	int joinClient(HashMap<String, Object> params);


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
	
	//개인회원 개인정보관리 페이지 이동 및 리스트 보여주기
	MemberDTO clientInfoManagement(String cl_id);

	//개인회원 비밀번호 DB에서 확인(암호화 때문)
	String passwordConfirm(String cl_pw);

	//개인회원 정보 수정하기
	void clientInfoUpdate(HashMap<String, String> params);

	//기업회원 기업회원정보관리 페이지 이동 및 리스트 보여주기
	MemberDTO companyInfoManagement(String com_id);

	//기업회원 비밀번호 DB에서 확인(암호화 때문)
	String passwordConfirm2(String com_pw);

	//기업회원 회원정보 수정하기
	void companyMemberInfoUpdate(HashMap<String, String> params);

	HashMap<String, Object> passwordConfirm3(String memberPw);

	//개인회원 탈퇴가 되었는지 true,false 반환
	boolean clientDelete(String cl_id);

	//개안회원 탈퇴가 true이면 개인회원 관리 테이블에 파라미터 인서트 요청
	void clientManagement(HashMap<String, String> params);

	
	boolean companyDelete(String com_id);

	void companyManagement(HashMap<String, String> params);
	


	//파일 업로드 메서드
	//void fileWrite(String oriFileName, String newFileName, String clId);



	// 개인회원 가입 dao ajax
	//int clientJoin(HashMap<String, Object> params);

}
