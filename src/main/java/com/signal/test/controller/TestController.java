package com.signal.test.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.signal.test.service.TestService;

@Controller
public class TestController {
	
	@Autowired TestService service;
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@RequestMapping(value = "selfInsert.go", method = RequestMethod.GET)
	public ModelAndView recommendGo(HttpSession session, Model model) {		
		
		String id = (String) session.getAttribute("loginId");	
		
		return service.selfInsert(id);
	}
}
