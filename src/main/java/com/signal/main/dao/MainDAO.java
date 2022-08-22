package com.signal.main.dao;

import java.util.ArrayList;

import com.signal.all.dto.CallendarDTO;

public interface MainDAO {

	ArrayList<CallendarDTO> startPost1(String day1);

	ArrayList<CallendarDTO> endPost1(String day1);

	ArrayList<CallendarDTO> startPost2(String day2);

	ArrayList<CallendarDTO> endPost2(String day2);

	ArrayList<CallendarDTO> startPost3(String day3);

	ArrayList<CallendarDTO> endPost3(String day3);

	ArrayList<CallendarDTO> startPost4(String day4);

	ArrayList<CallendarDTO> endPost4(String day4);

	ArrayList<CallendarDTO> startPost5(String day5);

	ArrayList<CallendarDTO> endPost5(String day5);

	ArrayList<CallendarDTO> startPost6(String day6);

	ArrayList<CallendarDTO> endPost6(String day6);

	ArrayList<CallendarDTO> startPost7(String day7);

	ArrayList<CallendarDTO> endPost7(String day7);

	ArrayList<CallendarDTO> postPopStart(String chkDay);

	ArrayList<CallendarDTO> postPopEnd(String chkDay);

	int cnt1(String day1);
	int cnt2(String day2);
	int cnt3(String day3);
	int cnt4(String day4);
	int cnt5(String day5);
	int cnt6(String day6);
	int cnt7(String day7);
	int cnt8(String day1);
	int cnt9(String day2);
	int cnt10(String day3);
	int cnt11(String day4);
	int cnt12(String day5);
	int cnt13(String day6);
	int cnt14(String day7);
	

}
