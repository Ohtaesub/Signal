package com.signal.recommend.dao;

import java.util.HashMap;

public interface RecommendDAO {

	String overlay(String chkId);

	int recommendReg(HashMap<String, Object> params);

	String recommendU(String reco_no);

	int recommendUReg(HashMap<String, String> params);

}
