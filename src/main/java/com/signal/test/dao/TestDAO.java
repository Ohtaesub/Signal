package com.signal.test.dao;

import java.util.ArrayList;

import com.signal.all.dto.TestDTO;

public interface TestDAO {

	ArrayList<TestDTO> selfInsert(String id);

}
