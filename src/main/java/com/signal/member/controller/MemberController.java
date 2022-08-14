package com.signal.member.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.signal.all.dto.MemberDTO;
import com.signal.member.service.MemberService;

@Controller
public class MemberController {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired MemberService service;
	
	@RequestMapping(value = "/main.do", method = RequestMethod.GET)
	public String home(Model model) {
		
		//임시로 보낸것임 바꿔주어야함 주소
		return "main";
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
	
		
	// 개인회원,기업회원,관리자 로그인 (String으로 받아옴)
	@RequestMapping(value = "/login.do", method= RequestMethod.POST)
	public String login(Model model,HttpServletRequest request) throws Exception{
		logger.info("로그인 요청!");
		
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String state = request.getParameter("memberSelect");
		String clientLogin = service.clientLogin(id,pw);
		MemberDTO client = service.clientdto(clientLogin);
		
		
		String companyLogin = service.companyLogin(id,pw);
		MemberDTO company = service.companydto(companyLogin);
		
		logger.info("개인회원 로그인 시도 아이디 : "+clientLogin);
		logger.info("기업회원 로그인 시도 아이디 : "+companyLogin);
		
		String page = "main";
		String msg = "로그인 실패!";
		HttpSession session = request.getSession();
		if(clientLogin !=null && companyLogin==null) {
			if(client.getCl_state().equals("탈퇴회원")) {
				msg = "탈퇴된 회원입니다.";
				model.addAttribute("msg",msg);
				page = "loginPopup";
			}else if(state.equals("개인회원")){				
				msg = "개인회원 로그인에 성공하였습니다!";
				model.addAttribute("msg",msg);
				session.setAttribute("loginId", clientLogin);
				session.setAttribute("isClient", "true");
			}else {
				msg ="아이디 / 비밀번호 또는 회원상태를 확인해주세요.";
				model.addAttribute("msg",msg);
				page = "loginPopup";
			}
		}else if(companyLogin !=null && clientLogin==null) {
			if(company.getCom_state().equals("탈퇴회원")){
				msg = "탈퇴된 회원입니다.";
				model.addAttribute("msg",msg);
				page = "loginPopup";
			}else if(state.equals("기업회원")){
			msg = "기업회원 로그인에 성공하였습니다!";
			model.addAttribute("msg",msg);
			session.setAttribute("loginId", companyLogin);
			session.setAttribute("isCompany", "true");
			}else {
				msg ="아이디 / 비밀번호 또는 회원상태를 확인해주세요.";
				model.addAttribute("msg",msg);
				page = "loginPopup";
			}
		}else {
			msg = "탈퇴된 회원입니다.";
			model.addAttribute("msg",msg);
			page = "loginPopup";
		}
		
		return page;
	}	
		
		
		
		
		
		
		
	/*  
	// 개인회원,기업회원,관리자 로그인 (id,pw 있는것 개수 count 해서 int에 담는 방법)
	@RequestMapping(value = "/login.do", method= RequestMethod.POST)
	public String login(Model model,HttpSession session,@RequestParam HashMap<String,String> params ) {
		logger.info("로그인 요청!! : "+params);
		
		String id = params.get("id");
		String pw = params.get("pw");
		String state = params.get("memberSelect");
		String page = "main";
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
				msg="개인회원 로그인에 성공하셨습니다!";
				model.addAttribute("msg",msg);
				session.setAttribute("loginId", id);
				//개인,기업,관리자에 따라 마이페이지가 다르게 보여야 하므로 세션을 추가해 준다.
				session.setAttribute("isClient", "true");
			}
		}else if(cnt2>0) { //기업회원 테이블에서 로그인할 아이디와 비밀번호가 있는경우
			//가져온 아이디와 비밀번호가 있으면 이제 회원상태를 확인한다.
			if(state.equals("기업회원")) {
				msg="기업회원 로그인에 성공하셨습니다!";
				model.addAttribute("msg",msg);
				session.setAttribute("loginId", id);
				//개인,기업,관리자에 따라 마이페이지가 다르게 보여야 하므로 세션을 추가해 준다.
				session.setAttribute("isCompany", "true");
			}
		}else if(cnt3>0) { //관리자 테이블에서 로그인할 아이디와 비밀번호가 있는경우
			//가져온 아이디와 비밀번호가 있으면 회원상태를 확인한다.
			if(!state.equals("개인회원") || !state.equals("기업회원") || !state.equals("탈퇴회원")) { // 관리자 회원도 탈퇴일 수 있으므로 조건을 준다.
				msg="관리자 로그인에 성공하셨습니다!";
				model.addAttribute("msg",msg);
				session.setAttribute("loginId", id);
				//개인,기업,관리자에 따라 마이페이지가 다르게 보여야 하므로 세션을 추가해 준다.
				session.setAttribute("isAdmin", "true");
			}
		}else if((cnt1<1 || cnt2<1 || cnt3<1) && state.equals("탈퇴회원")) {
				msg="탈퇴된 회원입니다!";
				model.addAttribute("msg",msg);
				page = "loginPopup";
		}else {
			msg= "아이디 또는 비밀번호 또는 회원상태를 확인해주세요.";
			model.addAttribute("msg",msg);
			page = "loginPopup";
		}
		
		return page;
	}
	*/
	
	
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
    		model.addAttribute("msg", "비밀번호 변경에 성공하였습니다.");
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
    		model.addAttribute("msg", "비밀번호 변경에 성공하였습니다.");
    	}
    	
    	//비밀번호를 변경하였으면 다시 로그인하기 위해 세션을 지워준다.
    	session.removeAttribute("findId");
    	
    	return page;
    }
    
    
    //개인회원 개인정보관리 페이지 이동 요청 및 리스트 뿌려주기 + 정보수정 페이지 리스트까지 같이 보여줌
    @RequestMapping(value="/clientInfoManagement.do")
    public String clientInfoManagement(HttpSession session, Model model) {
        logger.info("개인회원 개인정보관리 페이지 이동 및 리스트 보여주기 요청");
        
        //dto에 등록된 값들을 뿌려주기 위해 해당 로그인된 세션을 저장한 값을 dto에 담아준다.
        //loginId는 String 타입이므로 service에 String으로 보내야 한다. 그래서 세션을 형변환 해준다.
        MemberDTO dto = service.clientInfoManagement((String) session.getAttribute("loginId"));
        
        //받아온 dto들을 model에 담아 jsp에 뿌려준다.
        model.addAttribute("clientInfo",dto);
        
        return "clientInfoManagement";
    }
    
    
    // 개인회원 정보수정 페이지 이동요청, 기존 개인정보 관리페이지에서 서비스에 요청한 값들 model에 담기
 	@RequestMapping(value = "/clientInfoUpdateForm.go")
 	public String clientInfoUpdateForm(HttpSession session, Model model) {
 		logger.info("개인회원 개인정보수정 페이지 이동 및 리스트 보여주기 요청");
        
        //dto에 등록된 값들을 뿌려주기 위해 해당 로그인된 세션을 저장한 값을 dto에 담아준다.
        //loginId는 String 타입이므로 service에 String으로 보내야 한다. 그래서 세션을 형변환 해준다.
        MemberDTO dto = service.clientInfoManagement((String) session.getAttribute("loginId"));
        
        //받아온 dto들을 model에 담아 jsp에 뿌려준다.
        model.addAttribute("clientInfo",dto);
        
        return "clientInfoUpdateForm";
 	}
 	
 	
 	// 개인회원 정보수정 요청시 현재 비밀번호 암호화 DB와 확인
 	@RequestMapping(value="/passwordConfirm.ajax")
 	@ResponseBody
 	public HashMap<String, Object> passwordConfirm(@RequestParam String cl_pw){
		logger.info("현재 비밀번호 확인 : "+cl_pw);
		return service.passwordConfirm(cl_pw);
	}
 	
 	
 	// 개인회원 정보수정 하기 요청
 	@RequestMapping(value="/clientInfoUpdate.do")
 	public String clientInfoUpdate(RedirectAttributes redirectAttr,HttpSession session, @RequestParam HashMap<String, String> params) {
 		
 		// 어떤 아이디의 정보를 수정할 것인지 확인하기 위해 로그인 세션 가져와서 담아줌 + 세션을 String으로 형변환
 		String loginId = (String) session.getAttribute("loginId");
 		
 		params.put("cl_id", loginId);
 		logger.info("params : {}"+params);
 		
 		//서비스에 어떤 값을 수정할 것인지 담아서 요청을 보낸다.
 		service.clientInfoUpdate(params);
 		
 		// ※중요 redirect 전에 경고창 출력할 때는 RedirectAttributes 를 이용해서 출력한다.
 		String msg = "수정이 완료되었습니다.";
 		redirectAttr.addFlashAttribute("msg",msg);
 		
 		return "redirect:/clientInfoManagement.do";
 	}
 	
 	
 	//기업회원 기업회원정보관리 페이지 이동 요청 및 리스트 뿌려주기 + 정보수정 페이지 리스트까지 같이 보여줌
    @RequestMapping(value="/companyInfoManagement.do")
    public String companyInfoManagement(HttpSession session, Model model) {
        logger.info("기업회원 기업회원정보관리 페이지 이동 및 리스트 보여주기 요청");
        
        //dto에 등록된 값들을 뿌려주기 위해 해당 로그인된 세션을 저장한 값을 dto에 담아준다.
        //loginId는 String 타입이므로 service에 String으로 보내야 한다. 그래서 세션을 형변환 해준다.
        MemberDTO dto = service.companyInfoManagement((String) session.getAttribute("loginId"));
        
        //받아온 dto들을 model에 담아 jsp에 뿌려준다.
        model.addAttribute("companyInfo",dto);
        
        return "companyInfoManagement";
    }
 	
 	
    // 기업회원 회원정보수정 페이지 이동요청, 기존 기업회원정보 관리페이지에서 서비스에 요청한 값들 model에 담기
 	@RequestMapping(value = "/companyInfoUpdateForm.go")
 	public String companyInfoUpdateForm(HttpSession session, Model model) {
 		logger.info("기업회원 기업회원정보수정 페이지 이동 및 리스트 보여주기 요청");
        
        //dto에 등록된 값들을 뿌려주기 위해 해당 로그인된 세션을 저장한 값을 dto에 담아준다.
        //loginId는 String 타입이므로 service에 String으로 보내야 한다. 그래서 세션을 형변환 해준다.
        MemberDTO dto = service.companyInfoManagement((String) session.getAttribute("loginId"));
        
        //받아온 dto들을 model에 담아 jsp에 뿌려준다.
        model.addAttribute("companyInfo",dto);
        
        return "companyInfoUpdateForm";
 	}
 	
 	
 	// 기업회원 회원정보수정 요청시 현재 비밀번호 암호화 DB와 확인
  	@RequestMapping(value="/passwordConfirm2.ajax")
  	@ResponseBody
  	public HashMap<String, Object> passwordConfirm2(@RequestParam String com_pw){
 		logger.info("현재 비밀번호 확인 : "+com_pw);
 		return service.passwordConfirm2(com_pw);
 	}
  	
  	
  	// 기업회원 정보수정 하기 요청
  	@RequestMapping(value="/companyMemberInfoUpdate.do")
  	public String companyMemberInfoUpdate(RedirectAttributes redirectAttr,HttpSession session, @RequestParam HashMap<String, String> params) {
  		
  		// 어떤 아이디의 정보를 수정할 것인지 확인하기 위해 로그인 세션 가져와서 담아줌 + 세션을 String으로 형변환
  		String loginId = (String) session.getAttribute("loginId");
  		
  		params.put("com_id", loginId);
  		logger.info("params : {}"+params);
  		
  		//서비스에 어떤 값을 수정할 것인지 담아서 요청을 보낸다.
  		service.companyMemberInfoUpdate(params);
  		
  		// ※중요 redirect 전에 경고창 출력할 때는 RedirectAttributes 를 이용해서 출력한다.
  		String msg = "수정이 완료되었습니다.";
  		redirectAttr.addFlashAttribute("msg",msg);
  		
  		return "redirect:/companyInfoManagement.do";
  	}
  	
  	
  	// 개인회원 탈퇴 페이지 이동 요청
  	@RequestMapping(value="/clientBreakForm.go")
  	public String clientBreakForm(){
 		logger.info("회원탈퇴 페이지 이동");
 		return "clientBreakForm";
 	}
  	
  	
  	// 개인회원 탈퇴 요청
  	@RequestMapping(value="/clientDelete.do")
  	public String clientDelete(RedirectAttributes redirectAttr, HttpSession session, @RequestParam HashMap<String, String> params) {
  	String cl_id = (String) session.getAttribute("loginId");
  	
  	params.put("cl_id", cl_id);
  	//회원 탈퇴가 완료된 경우 조건을 걸어서 회원관리 테이블에 인서트하는 요청을 보낸다.
  	if(service.clientDelete(cl_id)==true) {
  		// 기타를 선택한경우 조건을 걸어 기타에 대한 내용을 인서트한다.
  		if(params.get("mg_content").equals("기타")) {
            params.put("mg_content", "기타(" + params.get("mg_content_other") + ")");
        }
  		
  		service.clientManagement(params);
  		String msg = "탈퇴가 완료되었습니다.";
  		redirectAttr.addFlashAttribute("msg",msg);
  	}
  	
  	session.removeAttribute("loginId");
  	session.removeAttribute("isClient");
  	
  	return "redirect:/main.do";
  	}
  	
  	
  	// 기업회원 탈퇴 페이지 이동 요청
   	@RequestMapping(value="/companyBreakForm.go")
   	public String companyBreakForm(){
  		logger.info("회원탈퇴 페이지 이동");
  		return "companyBreakForm";
  	}
  
   	
  	// 기업회원 탈퇴 요청
   	@RequestMapping(value="/companyDelete.do")
   	public String companyDelete(RedirectAttributes redirectAttr, HttpSession session, @RequestParam HashMap<String, String> params) {
	String com_id = (String) session.getAttribute("loginId");
   	
   	params.put("com_id", com_id);
   	//회원 탈퇴가 완료된 경우 조건을 걸어서 회원관리 테이블에 인서트하는 요청을 보낸다.
   	if(service.companyDelete(com_id)==true) {
   		// 기타를 선택한경우 조건을 걸어 기타에 대한 내용을 인서트한다.
   		if(params.get("mg_content").equals("기타")) {
             params.put("mg_content", "기타(" + params.get("mg_content_other") + ")");
         }
   		
   		service.companyManagement(params);
   		String msg = "탈퇴가 완료되었습니다.";
   		redirectAttr.addFlashAttribute("msg",msg);
   	}
   	
   	session.removeAttribute("loginId");
   	session.removeAttribute("isCompany");
   	
   	return "redirect:/main.do";
   	}
  	
  	
}