package com.signal.resume.service;

import java.util.ArrayList;
import java.util.HashMap;

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

	public boolean resumeReg(HashMap<String, String> params) {
		
		logger.info("이력서 기본정보 등록 서비스");
		boolean success = false;
		
		if(dao.resumeReg(params)>0) {
			success = true;
		}
		logger.info("이력서 등록 : " + success);
		return success;
		
	}
	
	
}
