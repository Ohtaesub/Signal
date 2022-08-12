package com.signal.member.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.signal.all.dto.MemberDTO;
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
	
	
	// 개인회원 이메일 중복체크
	@RequestMapping("/overlayEmail.ajax")
	@ResponseBody
	public HashMap<String, Object>overlayEmail(@RequestParam String chkEmail) {
		logger.info("이메일 중복 체크 : "+chkEmail);
		return service.overlayEmail(chkEmail);
	}
	
	
	/*
	// 개인회원 회원가입 요청 및 파일업로드
	@RequestMapping(value="clientJoin.do")
	public String clientJoin(Model model,@RequestParam HashMap<String, String>params, MultipartFile cl_photo) {
		
		//1. 파일명 추출하기
		String fileName = cl_photo.getOriginalFilename();
		String ext = fileName.substring(fileName.lastIndexOf(".")).toLowerCase();//확장자
		
		//2. 새 파일명으로 바꿔주기(중복 방지)
		String newFileName = System.currentTimeMillis()+ext;
		logger.info(fileName+" -> "+newFileName);
		
		//3. 새 파일명으로 저장하기
		try {
			byte[] arr = cl_photo.getBytes();//바이트 추출
			Path filePath = Paths.get("C:/upload/"+newFileName);// 어디에 저장할지 지정
			Files.write(filePath, arr);// 파일 저장
			service.fileWrite(cl_photo);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		logger.info("회원가입 요청정보 : "+params);

		int success=service.clientJoin(params,cl_photo);
		String msg = "회원가입에 실패하였습니다.";
		
		if(success>0) {
			msg="회원가입에 성공하셨습니다.";
		}
		
		// 회원가입 성공 여부 출력창 스크립트에 달아주기 위함
		model.addAttribute("msg",msg);
		// 임시 페이지 다른 곳으로 주소 바꿀것!
		 return "login";
	}
	*/
	
	
	/*
	// 개인회원 회원가입 요청 및 파일업로드(아직 불가) (form 방식)
	@RequestMapping(value="clientJoin.do")
	public String clientJoin(Model model,@RequestParam HashMap<String, String>params, MultipartFile cl_photo) {			
		logger.info("회원가입 요청하려는 입력정보 : "+params);
		int success = service.clientJoin(params,cl_photo);
		String msg = "회원가입에 실패 했습니다.";
		if(success>0) {
			msg="회원가입에 성공 했습니다.";
		}
		model.addAttribute("msg",msg);
		return "login";
	}
	*/
	
	
	// 개인회원 회원가입 요청 ajax 버전
		@RequestMapping("/joinClient.ajax")
		@ResponseBody
		public HashMap<String, Object> joinClient(@RequestParam HashMap<String, Object> params){
			logger.info("개인회원 가입요청 : "+params);
			HashMap<String, Object> map = new HashMap<String, Object>();
			service.joinClient(params);
			map.put("success", 1);
			return map;
		}
	
	
	/*
	// 개인회원 회원가입 요청 ajax
	@RequestMapping(value = "/clientJoin.ajax")
	@ResponseBody
	public HashMap<String, Object> clientJoin(@RequestParam HashMap<String, Object> params) {
		logger.info("회원 가입 요청 : "+params);
		return service.clientJoin(params);
	}
	*/
	
	
	/*
	//파일 업로드 팝업창 띄우기
	@RequestMapping(value = "/clientPhotoUploadForm.go")
	public String uploadForm() {

		return "clientPhotoUploadForm";
	}
	*/
	
	/*
	//파입 업로드 요청 보내기
	@RequestMapping(value = "/clientPhotoUpload.do")
	public ModelAndView clientPhotoUpload(MultipartFile file, HttpSession session) {
		logger.info("개인회원 사진 upload 요청");
		return service.fileUpload(file,session);
	}
	*/
	
	/*
	//파일 삭제 , 세션에서 지우기
	@RequestMapping(value = "/fileDelete")
	@ResponseBody
	public HashMap<String,Object> fileDelete(@RequestParam String fileName, HttpSession session) {
		logger.info(fileName+" 삭제 요청");
		return service.fileDelete(fileName,session);
	}
	*/
	
	
	// 개인회원,기업회원 로그인
	@RequestMapping(value = "/login.do", method= RequestMethod.POST)
	public String login(Model model,HttpSession session,@RequestParam HashMap<String,String> params ) {
		logger.info("로그인 요청!! : "+params);
		
		String id = params.get("id");
		String pw = params.get("pw");
		String state = params.get("memberSelect");
		String page = "login";
		String msg = "로그인 실패!";
		int cnt1 = service.clientMember(id,pw,state);
		int cnt2 = service.companyMember(id,pw,state);
		int cnt3 = service.adminMember(id,pw,state);
		
		//로그인이 null이 아닌경우로 가져와서 로그인 다시할 것 제일 중요함 비밀번호 틀려도 접속됌 현재
		// ==아니고 equals를 사용해야 인식한다! 매우매우 중요함
		//매퍼에서 아이디와 비밀번호 맞는것의 갯수를 구해온다. -> 아이디가 기본키 이므로 한개이다.
		//0보다 크면 아이디와 비밀번호와 회원상태가 맞는것이 있다는 뜻이므로 로그인이 가능하다.
		if(cnt1>0) {
			//가져온 아이디와 비밀번호가 있으면 이제 회원상태를 확인한다.
			if(state.equals("개인회원")) {
				page="main";
				msg="개인회원 로그인에 성공하셨습니다!";
				model.addAttribute("msg",msg);
				session.setAttribute("loginId", id);
				//개인,기업,관리자에 따라 마이페이지가 다르게 보여야 하므로 세션을 추가해 준다.
				session.setAttribute("isClient", "true");
			}
		}else if(cnt2>0) { //기업회원 테이블에서 로그인할 아이디와 비밀번호가 있는경우
			//가져온 아이디와 비밀번호가 있으면 이제 회원상태를 확인한다.
			if(state.equals("기업회원")) {
				page="main";
				msg="기업회원 로그인에 성공하셨습니다!";
				model.addAttribute("msg",msg);
				session.setAttribute("loginId", id);
				//개인,기업,관리자에 따라 마이페이지가 다르게 보여야 하므로 세션을 추가해 준다.
				session.setAttribute("isCompany", "true");
			}
		}else if(cnt3>0) { //관리자 테이블에서 로그인할 아이디와 비밀번호가 있는경우
			//가져온 아이디와 비밀번호가 있으면 회원상태를 확인한다.
			if(!state.equals("개인회원") || !state.equals("기업회원") || !state.equals("탈퇴회원")) { // 관리자 회원도 탈퇴일 수 있으므로 조건을 준다.
				page="main";
				msg="관리자 로그인에 성공하셨습니다!";
				model.addAttribute("msg",msg);
				session.setAttribute("loginId", id);
				//개인,기업,관리자에 따라 마이페이지가 다르게 보여야 하므로 세션을 추가해 준다.
				session.setAttribute("isAdmin", "true");
			}
		}else {
			msg= "아이디 또는 비밀번호 또는 회원상태를 확인해주세요.";
			model.addAttribute("msg",msg);
			page = "loginPopup";
		}
		
		return page;
	}
	
	
	//로그아웃 기능 구현
	@RequestMapping(value = "/logout.do")
	public String logout(Model model,HttpSession session) {
		
		//위에 이름 날리기
		session.removeAttribute("loginId");
		
		// 개인회원 세션 날리기
        session.removeAttribute("isClient");
        // 기업회원 세션 날리기
        session.removeAttribute("isCompany");
        
        //추가되어야 할 것 관리자 로그아웃
        
		model.addAttribute("msg", "로그아웃 되었습니다.");
		//페이지는 임시
		return "main";
		}
	
	
	//기업회원 가입페이지 이동 요청
	@RequestMapping(value = "/joinFormCompany.go")
	public String joinFormCompany() {

		return "joinFormCompany";
	}
	
	
	// 기업회원 아이디 중복체크
	@RequestMapping("/overlayCompanyId.ajax")
	@ResponseBody
	public HashMap<String, Object>overlayCompanyId(@RequestParam String chkComId) {
		logger.info("아이디 중복 체크 : "+chkComId);
		return service.overlayCompanyId(chkComId);
	}
	
	
	// 기업회원 이메일 중복체크
	@RequestMapping("/overlayComEmail.ajax")
	@ResponseBody
	public HashMap<String, Object>overlayComEmail(@RequestParam String chkComEmail) {
		logger.info("이메일 중복 체크 : "+chkComEmail);
		return service.overlayComEmail(chkComEmail);
	}
	
	
	// 기업회원 회원가입 요청 ajax 버전
	@RequestMapping("/joinCompany.ajax")
	@ResponseBody
	public HashMap<String, Object> joinCompany(@RequestParam HashMap<String, Object> params){
		logger.info("기업회원 가입요청 : "+params);
		HashMap<String, Object> map = new HashMap<String, Object>();
		service.joinCompany(params);
		map.put("success", 1);
		return map;
	}
	
	
	// 개인회원 아이디 찾기 페이지 이동요청
	@RequestMapping(value = "/findClientId.go")
	public String findClientIdForm() {
		logger.info("개인회원 ID찾기 페이지 이동");
		return "findClientId";
	}
	
	
	// 기업회원 아이디 찾기 페이지 이동요청
	@RequestMapping(value = "/findCompanyId.go")
	public String findCompanyIdForm() {
		logger.info("기업회원 ID찾기 페이지 이동");
		return "findCompanyId";
	}
	
	
	// 개인회원 아이디 찾기 요청! 
	// HttpServletRequest : jsp 파일에서 파라미터들의 내용을 가져오는 역할
	@RequestMapping(value = "/findClientId.do", method= RequestMethod.POST)
	public String findClientId(Model model, HttpServletRequest req) {
		logger.info("개인회원 ID찾기 요청");
		// HttpServletRequest로 파라미터를 가져오고 그 파라미터들을 꺼낼때는 getParameter로 파라미터값을 하나씩 꺼낸다.
		// 이때 getParameter는 모두 String 타입이다 *** 중요
		String name = req.getParameter("cl_name");
		String email = req.getParameter("cl_email");
		String msg = "일치하는 정보가 없습니다.";
		String page = "findClientId";
		
		
		logger.info(name+" , "+email+"을 가진 아이디가 있는지 확인");
		// 서비스에 아이디 찾기 요청을 보내는데 name과 email변수를 담아 보낸다.
		// 서비스에서 dao를 거쳐 mapper에서 DB를 확인해서 아이디가 있는 경우 그 값을 id라는 변수에 담는다.
		String id = service.findClientId(name,email);
		
		// db에서 맞는 Id가 있는지 확인하고 돌아와서 값이 있는경우 아래 구문을 실행한다.
		if(id !=null) {
			msg = "아이디는 "+id+" 입니다.";
			page = "main";
		}
		
		model.addAttribute("msg",msg);
		
		return page;
	}
	
	
	// 기업회원 아이디 찾기 요청! 
	// HttpServletRequest : jsp 파일에서 파라미터들의 내용을 가져오는 역할
	@RequestMapping(value = "/findCompanyId.do", method= RequestMethod.POST)
	public String findCompanyId(Model model, HttpServletRequest req) {
		logger.info("개인회원 ID찾기 요청");
		// HttpServletRequest로 파라미터를 가져오고 그 파라미터들을 꺼낼때는 getParameter로 파라미터값을 하나씩 꺼낸다.
		// 이때 getParameter는 모두 String 타입이다 *** 중요
		String email = req.getParameter("com_email");
		String number = req.getParameter("com_business_no");
		String msg = "일치하는 정보가 없습니다.";
		String page = "findCompanyId";
		
		
		logger.info(email+" , "+number+"을 가진 아이디가 있는지 확인");
		// 서비스에 아이디 찾기 요청을 보내는데 name과 email변수를 담아 보낸다.
		// 서비스에서 dao를 거쳐 mapper에서 DB를 확인해서 아이디가 있는 경우 그 값을 id라는 변수에 담는다.
		String id = service.findCompanyId(email,number);
		
		// db에서 맞는 Id가 있는지 확인하고 돌아와서 값이 있는경우 아래 구문을 실행한다.
		if(id !=null) {
			msg = "아이디는 "+id+" 입니다.";
			page = "main";
		}
		
		model.addAttribute("msg",msg);
		
		return page;
	}
	
	
	// 개인회원 비밀번호 찾기 페이지 이동요청
	@RequestMapping(value = "/findClientPw.go")
	public String findClientPwForm() {
		logger.info("개인회원 ID찾기 페이지 이동");
		return "findClientPw";
	}
	
	
	// 기업회원 비밀번호 찾기 페이지 이동요청
	@RequestMapping(value = "/findCompanyPw.go")
	public String findCompanyPwForm() {
		logger.info("기업회원 ID찾기 페이지 이동");
		return "findCompanyPw";
	}
	
	
	// 개인회원 비밀번호 찾기 요청! 
	// HttpServletRequest : jsp 파일에서 파라미터들의 내용을 가져오는 역할
	@RequestMapping(value = "/findClientPw.do", method= RequestMethod.POST)
	public String findClientPw(Model model, HttpServletRequest req,HttpSession session) {
		logger.info("개인회원 PW찾기 요청");
		// HttpServletRequest로 파라미터를 가져오고 그 파라미터들을 꺼낼때는 getParameter로 파라미터값을 하나씩 꺼낸다.
		// 이때 getParameter는 모두 String 타입이다 *** 중요
		String id = req.getParameter("cl_id");
		String name = req.getParameter("cl_name");
		String email = req.getParameter("cl_email");
		
		
		logger.info(id+" , "+name+" , "+email+"을 가진 데이터가 DB에 있는지 확인");
		// 서비스에 비밀번호 찾기 요청을 보내는데 Id와 name과 email변수를 담아 보낸다.
		// 서비스에서 dao를 거쳐 mapper에서 DB를 확인해서 아이디가 있는 경우 그 값을 row라는 변수에 담는다.
		// 해당 변수 3개와 일치하는 아이디를 카운트해오는 것이므로 int 타입이다.
		int row = service.findClientPw(id,name,email);
		
		// db에서 맞는 Id가 있는지 확인하고 돌아와서 값이 있는경우 아래 구문을 실행한다.
		if(row>0) {
			model.addAttribute("cl_id", id);
			//어떤 아이디에 비밀번호를 변경할 것인지에 대한 세션 저장
			session.setAttribute("findId", id);
			//새 비밀번호 설정 페이지 이동
			return "clientPwChangeForm";
		}else {
			model.addAttribute("msg","일치하는 정보가 없습니다.");
			return "findClientPw";
			
		}
	}
	
	//개인회원 새 비밀번호 설정 페이지 이동
    @RequestMapping(value="/clientPwChange.go")
    public String clientPwChangeForm() {
        logger.info("새 비밀번호 설정 페이지 이동");
        return "clientPwChangeForm";
    }
  
    
    //개인회원 새 비밀번호 설정 요청
    @RequestMapping(value="/clientPwChange.do")
    public String clientPwChange(Model model,HttpServletRequest req, HttpSession session) {
		
    	//세션을 캐스팅해준다.
    	String id = (String) session.getAttribute("findId");
    	String page = "clientPwChangeForm";
    	//세션의 값이 null이 아닌경우 하단 구문을 실행한다.
    	if(id !=null) {
    		//입력한 비밀번호를 HttpServletRequest를 통해 service로 보내준다.
    		service.clientPwChange(id, req.getParameter("cl_pw"));
    		page = "main";
    		model.addAttribute("msg", "비밀번호 변경에 성공하였습니다. 다시 로그인 해주세요.");
    	}
    	
    	//비밀번호를 변경하였으면 다시 로그인하기 위해 세션을 지워준다.
    	session.removeAttribute("findId");
    	
    	return page;
    }
    
    
	 // 기업회원 비밀번호 찾기 요청! 
	// HttpServletRequest : jsp 파일에서 파라미터들의 내용을 가져오는 역할
	@RequestMapping(value = "/findCompanyPw.do", method= RequestMethod.POST)
	public String findCompanyPw(Model model, HttpServletRequest req,HttpSession session) {
		logger.info("기업회원 PW찾기 요청");
		// HttpServletRequest로 파라미터를 가져오고 그 파라미터들을 꺼낼때는 getParameter로 파라미터값을 하나씩 꺼낸다.
		// 이때 getParameter는 모두 String 타입이다 *** 중요
		String id = req.getParameter("com_id");
		String email = req.getParameter("com_email");
		String number = req.getParameter("com_business_no");
		
		
		logger.info(id+" , "+email+" , "+number+"을 가진 데이터가 DB에 있는지 확인");
		// 서비스에 비밀번호 찾기 요청을 보내는데 Id와 name과 email변수를 담아 보낸다.
		// 서비스에서 dao를 거쳐 mapper에서 DB를 확인해서 아이디가 있는 경우 그 값을 row라는 변수에 담는다.
		// 해당 변수 3개와 일치하는 아이디를 카운트해오는 것이므로 int 타입이다.
		int row = service.findCompanyPw(id,email,number);
		
		// db에서 맞는 Id가 있는지 확인하고 돌아와서 값이 있는경우 아래 구문을 실행한다.
		if(row>0) {
			model.addAttribute("com_id", id);
			//어떤 아이디에 비밀번호를 변경할 것인지에 대한 세션 저장
			session.setAttribute("findId", id);
			//새 비밀번호 설정 페이지 이동
			return "companyPwChangeForm";
		}else {
			model.addAttribute("msg","일치하는 정보가 없습니다.");
			return "findCompanyPw";
			
		}
	}
	
	
	//기업회원 새 비밀번호 설정 요청
    @RequestMapping(value="/companyPwChange.do")
    public String companyPwChange(Model model,HttpServletRequest req, HttpSession session) {
		
    	//세션을 캐스팅해준다.
    	String id = (String) session.getAttribute("findId");
    	String page = "companyPwChangeForm";
    	//세션의 값이 null이 아닌경우 하단 구문을 실행한다.
    	if(id !=null) {
    		//입력한 비밀번호를 HttpServletRequest를 통해 service로 보내준다.
    		service.companyPwChange(id, req.getParameter("com_pw"));
    		page = "main";
    		model.addAttribute("msg", "비밀번호 변경에 성공하였습니다. 다시 로그인 해주세요.");
    	}
    	
    	//비밀번호를 변경하였으면 다시 로그인하기 위해 세션을 지워준다.
    	session.removeAttribute("findId");
    	
    	return page;
    }
    
    
    
}