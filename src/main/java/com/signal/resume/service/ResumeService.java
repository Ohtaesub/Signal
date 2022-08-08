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

}
