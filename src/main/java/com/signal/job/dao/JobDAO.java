package com.signal.job.dao;

import java.util.HashMap;

public interface JobDAO {

	int jpReg(HashMap<String, Object> params);

	int jcReg(HashMap<String, Object> params);

	void jpHiddenUp(String jp_no, String jp_hidden);

	void jpJcHiddenUp(String jp_no, String jp_hidden);

	void jcHiddenUp(String jc_no, String jc_hidden);

}
