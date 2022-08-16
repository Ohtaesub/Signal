package com.signal.resume.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.signal.all.dto.ResumeDTO;
import com.signal.resume.dao.ResumeDAO;

@Service
public class ResumeService {
	
	@Autowired ResumeDAO dao;
	Logger logger = LoggerFactory.getLogger(this.getClass());

	public ArrayList<ResumeDTO> list(String id) {
		logger.info("이력서 리스트 서비스 요청");
		return dao.list(id);
	}

	public ArrayList<ResumeDTO> personList() {
		logger.info("인재현황 리스트 서비스 요청");
		return dao.personList();
	}

	// 이력서 상세보기 서비스 요청 시작	
	public ResumeDTO resumeDetail(String re_no) {
		logger.info("이력서 상세보기 서비스 요청 : 이력서 번호-" + re_no);
		ResumeDTO dto = new ResumeDTO();
		dto = dao.resumeDetail(re_no);
		return dto;
	}

	public ArrayList<ResumeDTO> careerDetail(String re_no) {
		
		return dao.careerDetail(re_no);
	}

	public ArrayList<ResumeDTO> socialDetail(String re_no) {
		
		return dao.socialDetail(re_no);
	}

	public ArrayList<ResumeDTO> licenseDetail(String re_no) {
		
		return dao.licenseDetail(re_no);
	}
	
	public ArrayList<ResumeDTO> recommendDetail(String re_no) {
		
		return dao.recommendDetail(re_no);
	}
	
	public ArrayList<ResumeDTO> recommendUp(String id) {
		
		return dao.recommendUp(id);
	}
	// 이력서 상세보기 서비스 요청 끝	

	public HashMap<String, Object> personList2(HashMap<String, String> params) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		//cnt : 리스트 갯수, page : 보여줄 페이지 수
		int cnt = Integer.parseInt(params.get("cnt"));
		int page = Integer.parseInt(params.get("page"));
		logger.info("보여줄 페이지 : "+page);
		
		String searchCondition = params.get("searchCondition");
		String startAge = params.get("startAge");
		String endAge = params.get("endAge");
		
		
		HashMap<String, Object> searchResult = new HashMap<String, Object>();
		searchResult.put("searchCondition", searchCondition);
		searchResult.put("startAge", startAge);
		searchResult.put("endAge", endAge);
		
		//총 갯수(allCnt) / 페이지당 보여줄 갯수(cnt) = 생성 가능한 페이지(pages)

		int allCnt = dao.allCount(searchResult);

		logger.info("allCnt : "+allCnt);
		int pages = allCnt % cnt > 0 ? (allCnt / cnt)+1 : (allCnt / cnt);
		logger.info("pages : "+pages);
		
		if(pages==0) {pages=1;}
		
		if(page > pages) { //5개씩 보는 마지막 페이지로 갔을 때, 15개씩 보는 걸로 바꿨을때 뜨는 에러 해결
			page = pages;
		}
		
		map.put("pages", pages); //만들 수 있는 최대 페이지 수
		
		map.put("currPage", page); //현재 페이지
		
		int offset = (page-1) * cnt;
		logger.info("offset,cnt : "+offset+","+cnt); //offset:게시글 시작번호		
		
		searchResult.put("cnt", cnt);
		searchResult.put("offset", offset);
		
		ArrayList<ResumeDTO> personList = dao.personList2(searchResult);

		map.put("personList", personList);
		
		return map;
	}

	public ResumeDTO resumeRegDetail(String id) {
		ResumeDTO dto = new ResumeDTO();
		dto = dao.resumeRegDetail(id);
		return dto;
	}

	public String resumeReg(HashMap<String, String> params) {
		
		logger.info("이력서 기본정보 등록 서비스");
		ResumeDTO dto = new ResumeDTO();
		dto.setCl_id(params.get("cl_id"));
		dto.setRe_title(params.get("re_title"));
		dto.setRe_fn_status(params.get("re_fn_status"));
		dto.setRe_sch_name(params.get("re_sch_name"));
		dto.setRe_sch_period(params.get("re_sch_period"));
		dto.setRe_major(params.get("re_major"));		
		dto.setRe_register(params.get("re_register"));
		dto.setRe_intro(params.get("re_intro"));
		dto.setRe_portfolio(params.get("re_portfolio"));
		dto.setRe_average(params.get("re_average"));
		dto.setRe_total(params.get("re_total"));
		
		String jp = params.get("jp_no");
		int jp_no = Integer.parseInt(jp);
		String jc = params.get("jc_no");		
		int jc_no = Integer.parseInt(jc);
		
		if(jp_no != 0 || jc_no != 0) {
			int rowB=dao.resumeRegB(dto);
			int re_no = dto.getRe_no();
			int row=dao.resumeReg(jp_no, jc_no, re_no);
			logger.info("이력서 등록 결과 : " + rowB + '/' + row);
		} else {
			int rowB=dao.resumeRegB(dto);
			logger.info("이력서 등록 결과 : " + rowB);			
		}	
		
		int re_no = dto.getRe_no();
		logger.info("이력서 등록 결과 : " + re_no);
		
		return "redirect:/resumeAddReg.go?re_no="+re_no;
		
	}

	public ModelAndView careerReg(HashMap<String, String> params) {
		
		ModelAndView mav = new ModelAndView("./resume/careerRegPop");
		
		boolean success=false;
		int row = dao.careerReg(params);
		if(row>0) {
			success=true;
		}
		String reNo=params.get("re_no");
		int re_no=Integer.parseInt(reNo);
		
		mav.addObject("re_no", re_no);
		mav.addObject("success", success);
		return mav;
	}

	public ModelAndView socialReg(HashMap<String, String> params) {
ModelAndView mav = new ModelAndView("./resume/socialRegPop");
		
		boolean success=false;
		int row = dao.socialReg(params);
		if(row>0) {
			success=true;
		}
		String reNo=params.get("re_no");
		int re_no=Integer.parseInt(reNo);
		
		mav.addObject("re_no", re_no);
		mav.addObject("success", success);
		return mav;
	}

	public ModelAndView licenseReg(HashMap<String, String> params) {
ModelAndView mav = new ModelAndView("./resume/licenseRegPop");
		
		boolean success=false;
		int row = dao.licenseReg(params);
		if(row>0) {
			success=true;
		}
		String reNo=params.get("re_no");
		int re_no=Integer.parseInt(reNo);
		
		mav.addObject("re_no", re_no);
		mav.addObject("success", success);
		return mav;
	}
	
	public ModelAndView recommendReg(HashMap<String, String> params) {
		ModelAndView mav = new ModelAndView("./resume/recommendUp");
		boolean success=false;
		int row = dao.recommendReg(params);
		if(row>0) {
			success=true;
		}
		String reNo=params.get("re_no");
		int re_no=Integer.parseInt(reNo);
		
		mav.addObject("re_no", re_no);
		mav.addObject("success", success);
		return mav;
	}		

	public ArrayList<ResumeDTO> recommendMe(String id) {
		logger.info("추천현황 리스트 서비스");
		return dao.recommendMe(id);
	}

	public ArrayList<ResumeDTO> recommendYou(String id) {
		return dao.recommendYou(id);
	}

	public ArrayList<ResumeDTO> recommendUlist(String id) {
		logger.info("내가추천 list 요청");
		return dao.recommendUlist(id);
	}

	public ArrayList<ResumeDTO> jpList() {
		return dao.jpList();
	}

	public ArrayList<ResumeDTO> jcList(String jp_no) {
		return dao.jcList(jp_no);
	}

	public ArrayList<ResumeDTO> jcCheck(String jc_no) {
		return dao.jcCheck(jc_no);
	}

	public ModelAndView careerUp(HashMap<String, String> params) {
		String re_no = params.get("re_no");		
		ModelAndView mav = new ModelAndView("./resume/careerUpPop");
		boolean success=false;
		int row = dao.careerUp(params);
		if(row>0) {
			success=true;
			ArrayList<ResumeDTO>list=dao.careerDetail(re_no);
			mav.addObject("careerDto", list);
		}		
		mav.addObject("re_no", re_no);
		mav.addObject("success", success);
		return mav;
	}

	public ModelAndView socialUp(HashMap<String, String> params) {
		String re_no = params.get("re_no");		
		ModelAndView mav = new ModelAndView("./resume/socialUpPop");
		boolean success=false;
		int row = dao.socialUp(params);
		if(row>0) {
			success=true;
			ArrayList<ResumeDTO>list=dao.socialDetail(re_no);
			mav.addObject("socialDto", list);
		}		
		mav.addObject("re_no", re_no);
		mav.addObject("success", success);
		return mav;
	}

	public ModelAndView licenseUp(HashMap<String, String> params) {
		String re_no = params.get("re_no");		
		ModelAndView mav = new ModelAndView("./resume/licenseUpPop");
		boolean success=false;
		int row = dao.licenseUp(params);
		if(row>0) {
			success=true;
			ArrayList<ResumeDTO>list=dao.licenseDetail(re_no);
			mav.addObject("licenseDto", list);
		}		
		mav.addObject("re_no", re_no);
		mav.addObject("success", success);
		return mav;
	}

	public ModelAndView careerDelete(String ca_no, String re_no) {		
		ModelAndView mav = new ModelAndView("./resume/careerUpPop");
		boolean result=false;
		int row = dao.careerDelete(ca_no);
		if(row>0) {
			result=true;
			ArrayList<ResumeDTO>list=dao.careerDetail(re_no);
			mav.addObject("careerDto", list);
		}
		mav.addObject("re_no", re_no);
		mav.addObject("result", result);
		return mav;
	}

	public ModelAndView socialDelete(String soc_no, String re_no) {
		ModelAndView mav = new ModelAndView("./resume/socialUpPop");
		boolean result=false;
		int row = dao.socialDelete(soc_no);
		if(row>0) {
			result=true;
			ArrayList<ResumeDTO>list=dao.socialDetail(re_no);
			mav.addObject("socialDto", list);
		}
		mav.addObject("re_no", re_no);
		mav.addObject("result", result);
		return mav;
	}

	public ModelAndView licenseDelete(String li_no, String re_no) {
		ModelAndView mav = new ModelAndView("./resume/licenseUpPop");
		boolean result=false;
		int row = dao.licenseDelete(li_no);
		if(row>0) {
			result=true;
			ArrayList<ResumeDTO>list=dao.licenseDetail(re_no);
			mav.addObject("licenseDto", list);
		}
		mav.addObject("re_no", re_no);
		mav.addObject("result", result);
		return mav;
	}

	

	

	
	
	
}
