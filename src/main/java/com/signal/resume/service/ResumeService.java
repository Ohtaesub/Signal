package com.signal.resume.service;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.signal.all.dto.ResumeDTO;
import com.signal.resume.dao.ResumeDAO;

@Service
public class ResumeService {
	
	@Autowired ResumeDAO dao;
	Logger logger = LoggerFactory.getLogger(this.getClass());

	public ArrayList<ResumeDTO> list() {
		logger.info("이력서 리스트 서비스 요청");
		return dao.list();
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
	// 이력서 상세보기 서비스 요청 끝	
	
	
}
