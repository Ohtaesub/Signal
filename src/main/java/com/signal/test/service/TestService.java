package com.signal.test.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.signal.all.dto.ResumeDTO;
import com.signal.all.dto.TestDTO;
import com.signal.test.dao.TestDAO;

@Service
public class TestService {

	@Autowired TestDAO dao;
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public ModelAndView selfInsert(String id) {
		ModelAndView mav = new ModelAndView("./selfTest/selfInsert");		
		boolean result = false;
		ArrayList<TestDTO> selfInsert = dao.selfInsert(id);
		if(selfInsert.size()>0) {			
			result = true;
			mav.addObject("list", selfInsert);
		}
		logger.info("사이즈="+selfInsert.size()+'/'+result);
		mav.addObject("result", result);
		mav.addObject("cl_id", id);
		return mav;
	}

	public ArrayList<TestDTO> selfRegGo() {
		
		return dao.selfRegGo();
	}

	public boolean selfReg(HashMap<String, Object> params) {
		int cnt = dao.selfReg(params);
		boolean success=false;
		if(cnt>0) {
			String st_comment=(String) params.get("st_comment");
			String cl_id=(String)params.get("cl_id");
			int row = dao.selfContentReg(st_comment,cl_id);
			if(row>0) {
			success=true;
			}
		}
		return success;
	}

	public boolean scoreReg(HashMap<String, Object> params) {
		int cnt = dao.scoreReg(params);
		boolean success=false;
		if(cnt>0) {
			success=true;
		}
		logger.info("결과는? " + success);
		return success;
	}

	public HashMap<String, Object> stReg(HashMap<String, Object> params) {
		logger.info("사이즈는?" + params.size());
		logger.info("흠? " + params.get("st_list"));
		logger.info("흠? " + params.get("st_list[0]"));	
		return null;
	}

	public ArrayList<TestDTO> selfQueList() {

		return dao.selfQueList();
	}
	
	public ArrayList<TestDTO> selfQueListA() {

		return dao.selfQueListA();
	}
	
	public ArrayList<TestDTO> selfQueListB() {

		return dao.selfQueListB();
	}

	public ArrayList<TestDTO> interviewQueList() {

		return dao.interviewQueList();
	}

	public void stHiddenUp(String st_no, String st_hidden) {
		dao.stHiddenUp(st_no, st_hidden);
		
	}

}
