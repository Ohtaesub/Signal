package com.signal.job.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.signal.job.dao.JobDAO;

@Service
public class JobService {
	
	@Autowired JobDAO dao;
	

	public boolean jpReg(HashMap<String, Object> params) {
		boolean success=false;
		int result = dao.jpReg(params);
		
		if(result > 0) {
			success=true;
		}
				
		return success;		
	}


	public boolean jcReg(HashMap<String, Object> params) {
		boolean success=false;
		int result = dao.jcReg(params);
		
		if(result > 0) {
			success=true;
		}
				
		return success;	
	}


	public void jpHiddenUp(String jp_no, String jp_hidden) {
		dao.jpHiddenUp(jp_no, jp_hidden);
		dao.jpJcHiddenUp(jp_no, jp_hidden);
		
	}
	
	public int hiddenGet(String jp_no) {
		int hiddenGet=dao.hiddenGet(jp_no);
		return hiddenGet;
	}


	public void jcHiddenUp(String jc_no, String jc_hidden) {
		dao.jcHiddenUp(jc_no, jc_hidden);			
	}


	

}
