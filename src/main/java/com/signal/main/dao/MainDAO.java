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

}
