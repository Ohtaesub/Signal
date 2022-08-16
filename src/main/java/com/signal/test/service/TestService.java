package com.signal.test.service;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

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
		mav.addObject("result", result);
		return mav;
	}

}
