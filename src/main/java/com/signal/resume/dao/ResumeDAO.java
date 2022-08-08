package com.signal.resume.dao;

import java.util.ArrayList;
import java.util.HashMap;

import com.signal.all.dto.ResumeDTO;

public interface ResumeDAO {

	ArrayList<ResumeDTO> list();

	ArrayList<ResumeDTO> personList();

	ResumeDTO resumeDetail(String re_no);

	ArrayList<ResumeDTO> careerDetail(String re_no);

	ArrayList<ResumeDTO> socialDetail(String re_no);

	ArrayList<ResumeDTO> licenseDetail(String re_no);

	int allCount(HashMap<String, Object> searchResult);

	ArrayList<ResumeDTO> personList2(HashMap<String, Object> searchResult);

}
