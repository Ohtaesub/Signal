package com.signal.objection.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.signal.all.dto.ObjectionDTO;
import com.signal.interview.dao.InterviewDAO;
import com.signal.objection.dao.ObjectionDAO;

@Service
public class ObjectionService {
@Autowired ObjectionDAO dao;
Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	public ArrayList<ObjectionDTO> clientObjectionList() {
		
		return dao.clientObjectionList();
	}
	
	public ArrayList<ObjectionDTO> comObjectionList() {
		
		return dao.comObjectionList();
	}
	
	public ArrayList<ObjectionDTO> adminObjectionList() {
	
		return dao.adminObjectionList();
	}
	
	public ArrayList<ObjectionDTO> adminBlindList() {
		
		return dao.adminBlindList();
	}
	
	public void clientDbjectionRegDo(HashMap<String, String> params) {
		
		int success = dao.clientDbjectionRegDo(params);
		logger.info("수정된 데이터 수 : "+ success);
	}

}
