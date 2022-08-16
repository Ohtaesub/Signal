package com.signal.test.dao;

import java.util.ArrayList;
import java.util.HashMap;

import com.signal.all.dto.TestDTO;

public interface TestDAO {

	ArrayList<TestDTO> selfInsert(String id);

	ArrayList<TestDTO> selfRegGo();

	int selfReg(HashMap<String, Object> params);

	int selfContentReg(String self_content, String cl_id);

	int scoreReg(HashMap<String, Object> params);

}
