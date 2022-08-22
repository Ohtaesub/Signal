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
	
	
	
	
	
}
