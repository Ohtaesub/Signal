package com.signal.job.controller;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.signal.all.dto.ResumeDTO;
import com.signal.job.service.JobService;
import com.signal.resume.service.ResumeService;

@Controller
public class JobController {

	@Autowired ResumeService service;
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@RequestMapping(value = "jobClassReg.go", method = RequestMethod.GET)
	public String jobClassPopGo(Model model) {		
		
		ArrayList<ResumeDTO> list = service.jpList();
		model.addAttribute("jpList", list);
		return "jobClassReg";
	}
	
	@RequestMapping(value = "jobchList.go", method = RequestMethod.GET)
	public String recommendGo(Model model, @RequestParam String jp_no) {		
		
		ArrayList<ResumeDTO> jplist = service.jpList();
		ArrayList<ResumeDTO> list = service.jcList(jp_no);
		model.addAttribute("jcList", list);
		model.addAttribute("jpList", jplist);
		return "jobClassReg";
	}
	
}
