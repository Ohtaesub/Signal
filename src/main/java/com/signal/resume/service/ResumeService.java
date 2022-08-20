package com.signal.resume.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
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

	

	public ResumeDTO resumeRegDetail(String id) {
		ResumeDTO dto = new ResumeDTO();
		dto = dao.resumeRegDetail(id);
		return dto;
	}

	public int resumeReg(HashMap<String, String> params) {
		
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
		dto.setRe_average(params.get("re_average"));
		dto.setRe_total(params.get("re_total"));
		
		int rowB=dao.resumeRegB(dto);			
		logger.info("이력서 등록 결과 : " + rowB);	
		int re_no=dto.getRe_no();
		logger.info("이력서 등록 결과 : " + re_no);
		
		String jp = params.get("jp_no");		
		String jc = params.get("jc_no");		
		logger.info("jp="+ jp + "jc=" + jc);
				
		
		
		
		return re_no;
	}
	
	public void portfolioUp(int re_no, MultipartFile re_portfolio) {
		
		ResumeDTO dto = new ResumeDTO();
		
		String oriFileName = re_portfolio.getOriginalFilename();
		if(!oriFileName.equals("")) {
			String ext = oriFileName.substring(oriFileName.lastIndexOf(".")).toLowerCase();
			String newFileName = System.currentTimeMillis()+ext;
			
			try {
				byte[] arr = re_portfolio.getBytes();
				Path path = Paths.get("C:/STUDY/SPRING_ADVANCE/Signal/src/main/webapp/resources/images/portfolio/" + newFileName);
				Files.write(path, arr);
				logger.info(newFileName + " 포트폴리오 save ok");
				dto.setRe_portfolio(newFileName);
				dto.setRe_portfolio_ori(oriFileName);
				dto.setRe_no(re_no);
				dao.portfolioUp(re_no, newFileName, oriFileName);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
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

	public boolean resumeDelete(String re_no) {
		boolean result = false;
		
		int resumeDelete = dao.resumeDelete(re_no);
		if(resumeDelete>0) {
			result = true;
		}				
		return result;
	}

	



	

	

	
	
	
}
