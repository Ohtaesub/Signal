package com.signal.main.service;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.signal.all.dto.CallendarDTO;
import com.signal.main.dao.MainDAO;

@Service
public class MainService {

	@Autowired MainDAO dao;
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public ArrayList<CallendarDTO> startPost1(String day1) {
		return dao.startPost1(day1);
	}

	public ArrayList<CallendarDTO> endPost1(String day1) {
		return dao.endPost1(day1);
	}
	
	public ArrayList<CallendarDTO> startPost2(String day2) {
		return dao.startPost2(day2);
	}

	public ArrayList<CallendarDTO> endPost2(String day2) {
		return dao.endPost2(day2);
	}
	
	public ArrayList<CallendarDTO> startPost3(String day3) {
		return dao.startPost3(day3);
	}

	public ArrayList<CallendarDTO> endPost3(String day3) {
		return dao.endPost3(day3);
	}
	
	public ArrayList<CallendarDTO> startPost4(String day4) {
		return dao.startPost4(day4);
	}

	public ArrayList<CallendarDTO> endPost4(String day4) {
		return dao.endPost4(day4);
	}
	
	public ArrayList<CallendarDTO> startPost5(String day5) {
		return dao.startPost5(day5);
	}

	public ArrayList<CallendarDTO> endPost5(String day5) {
		return dao.endPost5(day5);
	}
	
	public ArrayList<CallendarDTO> startPost6(String day6) {
		return dao.startPost6(day6);
	}

	public ArrayList<CallendarDTO> endPost6(String day6) {
		return dao.endPost6(day6);
	}
	
	public ArrayList<CallendarDTO> startPost7(String day7) {
		return dao.startPost7(day7);
	}

	public ArrayList<CallendarDTO> endPost7(String day7) {
		return dao.endPost7(day7);
	}

	public ArrayList<CallendarDTO> postPop(String chkDay, String chkState) {
		
		ArrayList<CallendarDTO> result = new ArrayList<CallendarDTO>();
		
		if(chkState.equals("start")) {
		result = dao.postPopStart(chkDay);
		} else if(chkState.equals("end")) {
			result = dao.postPopEnd(chkDay);
		}
		return result;
	}

	public int startPostCnt1(String day1) {
		int result = dao.cnt1(day1);
		return result;
	}
	
	public int startPostCnt2(String day2) {
		int result = dao.cnt2(day2);
		return result;
	}
	
	public int startPostCnt3(String day3) {
		int result = dao.cnt3(day3);
		return result;
	}
	
	public int startPostCnt4(String day4) {
		int result = dao.cnt4(day4);
		return result;
	}
	
	public int startPostCnt5(String day5) {
		int result = dao.cnt5(day5);
		return result;
	}
	
	public int startPostCnt6(String day6) {
		int result = dao.cnt6(day6);
		return result;
	}
	
	public int startPostCnt7(String day7) {
		int result = dao.cnt7(day7);
		return result;
	}

	public int endPostCnt1(String day1) {
		int result = dao.cnt8(day1);
		return result;
	}
	
	public int endPostCnt2(String day2) {
		int result = dao.cnt9(day2);
		return result;
	}
	public int endPostCnt3(String day3) {
		int result = dao.cnt10(day3);
		return result;
	}
	public int endPostCnt4(String day4) {
		int result = dao.cnt11(day4);
		return result;
	}
	public int endPostCnt5(String day5) {
		int result = dao.cnt12(day5);
		return result;
	}
	public int endPostCnt6(String day6) {
		int result = dao.cnt13(day6);
		return result;
	}
	public int endPostCnt7(String day7) {
		int result = dao.cnt14(day7);
		return result;
	}
	
	
	
	
}
