package com.signal.objection.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.signal.all.dto.ObjectionDTO;
import com.signal.interview.dao.InterviewDAO;
import com.signal.objection.dao.ObjectionDAO;

@Service
public class ObjectionService {
@Autowired ObjectionDAO dao;

public ArrayList<ObjectionDTO> clientObjectionList() {
	
	return dao.clientObjectionList();
}

}
