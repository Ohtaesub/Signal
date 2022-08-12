package com.signal.member.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.signal.all.dto.MemberDTO;
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


	/* 개인회원 가입서비스 form 방식
	public int clientJoin(HashMap<String, String> params, MultipartFile cl_photo) {
		logger.info("회원가입 서비스 요청");
		return dao.clientJoin(params);		
	}
	*/
	
	// 기업회원 회원가입 서비스 ajax
	public HashMap<String, Object> joinClient(HashMap<String, Object> params) {
		logger.info("개인회원 가입 서비스이동");
		HashMap<String, Object> map = new HashMap<String, Object>();
		int row = dao.joinClient(params);
		boolean success = row>0?true:false;
		map.put("success", success);
		return map;	
	}
		

	
	// 개인회원 로그인서비스
	public int clientMember(String id, String pw, String state) {
		logger.info("개인회원 로그인 서비스 요청");
		return dao.clientMember(id,pw,state);
	}


	// 기업회원 로그인서비스
	public int companyMember(String id, String pw, String state) {
		logger.info("개인회원 로그인 서비스 요청");
		return dao.companyMember(id,pw,state);
	}


	//관리자 로그인 서비스
	public int adminMember(String id, String pw, String state) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	/* 사진 업로드 포함 회원가입 방법 *************
	public String clientJoin(HashMap<String, String> params, MultipartFile cl_photo) {
		logger.info("회원가입 서비스 요청");
		
		MemberDTO dto = new MemberDTO();
		dto.setCl_id(params.get("cl_id"));
		dto.setCl_pw(params.get("cl_pw"));
		dto.setCl_age(params.get("cl_age"));
		dto.setCl_address(params.get("cl_address"));
		dto.setCl_call(params.get("cl_call"));
		dto.setCl_gender(params.get("gender"));
		dto.setCl_email(params.get("cl_email"));
		dto.setCl_state(params.get("cl_state"));
		dto.setCl_birth(params.get("cl_birth"));
		
		int success = dao.clientJoin(dto);
		String clId = dto.getCl_id();
		if(success>0) {
			fileSave(cl_photo,clId);
		}
		return "login";
	}


	private void fileSave(MultipartFile cl_photo, String clId) {
		String oriFileName= cl_photo.getOriginalFilename(); // 파일명 추출
		if(!oriFileName.equals("")) {
			logger.info("업로드 진행");
			//3-2. 확장자 분리
			String ext = oriFileName
					.substring(oriFileName.lastIndexOf(".")).toLowerCase();			
			//3-3. 새 이름 만들기
			String newFileName = System.currentTimeMillis()+ext;
			
			logger.info(oriFileName+" => "+newFileName);
			
			//3-4. 파일 받아서 저장하기
			try {
				byte[] arr = cl_photo.getBytes();
				Path path = Paths.get("C:/upload/"+newFileName);
				Files.write(path, arr);
				logger.info(newFileName+" save ok");
				//4. 업로드 후 photo 테이블에 데이터 입력	
				dao.fileWrite(oriFileName,newFileName,clId);
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	*/

	/*
	//개인회원 가입서비스 요청 및 파일업로드 form 방식
	public int clientJoin(HashMap<String, String> params,MultipartFile cl_photo) {
		logger.info("회원가입 서비스 요청");
		return dao.clientJoin(params,cl_photo);
	}
	
	public void fileWrite(MultipartFile cl_photo) {
		logger.info("사진파일 등록 서비스 요청");
		return dao.fileWrite();
	}
	*/

	
	/*
	// 개인회원 가입서비스 요청 ajax
	public HashMap<String, Object> clientJoin(HashMap<String, Object> params) {
		
		logger.info("회원가입 서비스 요청");
		HashMap<String, Object> result = new HashMap<String, Object>();
		int row = dao.clientJoin(params);
		boolean success = false;
		
		if(row > 0) {
			success = true;
		}
		
		result.put("success", success);
		
		return result;
	}
	*/
	
	
	/*
	public ModelAndView fileUpload(MultipartFile file, HttpSession session) {

		ModelAndView mav = new ModelAndView("clientPhotoUploadForm");
		
		//1. 파일명 추출하기
		String fileName = file.getOriginalFilename();
		
		//2. 신규 파일명 생성하기
		String ext = fileName.substring(fileName.lastIndexOf("."));
		String newFileName = System.currentTimeMillis()+ext;
		
		try {
			byte[] bytes = file.getBytes(); //3. 파일 받아오기
			//4. 파일 저장(Java nio 사용)
			Path filePath = Paths.get("C:/upload/"+newFileName);
			Files.write(filePath, bytes);
			
			//5. DB 에 저장(불가능 하다 - 아직 글을 쓰지도 않았으니까)
			//그래서 세션에 임시 저장한다.
			
			HashMap<String, String> map = (HashMap<String, String>) session.getAttribute("fileList");
			if(map == null) {
				map = new HashMap<String, String>();				
			}
			
			map.put(newFileName, fileName);
			logger.info("업로드 된 파일 수 : "+map.size());
			session.setAttribute("fileList", map);
			
			//6. 이미지 url 전달
			mav.addObject("path", "/photo/"+newFileName);
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return mav;
		
	}
	*/

	/*
	//파일 삭제, 세션에서 지우기
	public HashMap<String, Object> fileDelete(String fileName, HttpSession session) {
		
		HashMap<String, Object> result = new HashMap<String, Object>();
		
		boolean success = delFile(fileName);
		
		if(success) {
			HashMap<String, String> fileList = (HashMap<String, String>) session.getAttribute("fileList");
			fileList.remove(fileName);
			logger.info("삭제 후 남은 파일 수 : "+fileList.size());
			session.setAttribute("fileList", fileList);
			
		}
		
		result.put("success", success);
		
		return result;
	}
	*/
	
	/*
	//delFile 메서드 생성후 삭제 성공 유무를 통해 삭제 완료 여부 확인
	private boolean delFile(String fileName) {
		
		File file = new File("C:/upload/"+fileName);
		boolean success = false;
		if(file.exists()) {
			success = file.delete();
		}
		return success;
	}
	*/
	
	
	//기업회원 아이디 중복체크
	public HashMap<String, Object> overlayCompanyId(String com_id) {
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		String overcomId = dao.overlayCompanyId(com_id);
		logger.info("중복된 아이디 인가요? : "+overcomId);
		//중복된 아이디이면 중복 아이디:(중복아이디)가 보여짐 -> 사용불가 아이디
		//사용가능한 아이디이면 중복 아이디:(null)이 보여짐 ->사용가능 아이디
		boolean over = overcomId == null?false:true;
		map.put("overlayCompanyId", over);
		
		return map;
	}


	// 기업회원 이메일 중복확인
	public HashMap<String, Object> overlayComEmail(String com_email) {
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		String overlayComEmail=dao.overlayComEmail(com_email);
		logger.info("중복된 이메일 인가요? : "+overlayComEmail);
		//중복된 이메일이면 중복 이메일:(중복이메일)이 보여짐 ->사용불가 이메일
		//사용가능한 이메일이면 중복 이메일:(null)이 보여짐 ->사용가능 이메일
		boolean over = overlayComEmail ==null?false:true;
		map.put("overlayComEmail", over);
		
		return map;
	}


	// 기업회원 회원가입 서비스 ajax
	public HashMap<String, Object> joinCompany(HashMap<String, Object> params) {
		logger.info("기업회원 가입 서비스이동");
		HashMap<String, Object> map = new HashMap<String, Object>();
		int row = dao.joinCompany(params);
		boolean success = row>0?true:false;
		map.put("success", success);
		return map;	
	}


	// 개인회원 아이디 찾기 서비스 form 방식
	public String findClientId(String name, String email) {
		logger.info("개인회원 Id찾기 서비스 도착");
		//서비스에서는 단순히 매퍼와 연결해주는 것이므로 해줄 것이 없다. dao에 받아온 변수를 담아 보내주자
		return dao.findClientId(name,email);
	}


	// 기업회원 아이디 찾기 서비스 form 방식
	public String findCompanyId(String email, String number) {
		logger.info("기업회원 Id찾기 서비스 도착");
		//서비스에서는 단순히 매퍼와 연결해주는 것이므로 해줄 것이 없다. dao에 받아온 변수를 담아 보내주자
		return dao.findCompanyId(email,number);
	}

	
	// 개인회원 비밀번호 재설정과 관련된 정보입력 확인(새 비밀번호 설정 페이지로 넘어가기 위함)
	public int findClientPw(String id, String name, String email) {
		//서비스에서는 단순히 매퍼와 연결해주는 것이므로 해줄 것이 없다. dao에 받아온 변수를 담아 보내주자
		return dao.findClientPw(id,name,email);
	}


	// 개인회원 새 비밀번호 설정 서비스(뒤에 파라미터는 직접 바꿔주었음 String parameter -> String cl_pw)
	public void clientPwChange(String id, String cl_pw) {
		dao.clientPwChange(id,cl_pw);
	}


	public int findCompanyPw(String id, String email, String number) {
		//서비스에서는 단순히 매퍼와 연결해주는 것이므로 해줄 것이 없다. dao에 받아온 변수를 담아 보내주자
		return dao.findCompanyPw(id,email,number);
	}

	
	// 기업회원 새 비밀번호 설정 서비스(뒤에 파라미터는 직접 바꿔주었음 String parameter -> String com_pw)
	public void companyPwChange(String id, String com_pw) {
		dao.companyPwChange(id,com_pw);	
	}


	




}
