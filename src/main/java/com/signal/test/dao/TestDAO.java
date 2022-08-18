package com.signal.test.dao;

import java.util.ArrayList;
import java.util.HashMap;

import com.signal.all.dto.ResumeDTO;
import com.signal.all.dto.TestDTO;

public interface TestDAO {

	ArrayList<TestDTO> selfInsert(String id);

	ArrayList<TestDTO> selfRegGo();

	int selfReg(HashMap<String, Object> params);

	int selfContentReg(String id, String st_comment);

	int scoreReg(HashMap<String, Object> params);

	ArrayList<TestDTO> selfQueList();

	ArrayList<TestDTO> interviewQueList();

	ArrayList<TestDTO> selfQueListA();

	ArrayList<TestDTO> selfQueListB();

	void stHiddenUp(String st_no, String st_hidden);

	void stReg(HashMap<String, Object> map);

	String selfComment(String id);

	int selfQueReg(HashMap<String, Object> params);

	ArrayList<TestDTO> interviewQueListA();

	ArrayList<TestDTO> interviewQueListB();

	void itHiddenUp(String it_no, String it_hidden);

	int interQueReg(HashMap<String, Object> params);

}
