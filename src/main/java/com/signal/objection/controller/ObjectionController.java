package com.signal.objection.controller;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.signal.all.dto.ObjectionDTO;
import com.signal.objection.service.ObjectionService;

@Controller
public class ObjectionController {
	@Autowired ObjectionService service;
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@RequestMapping(value = "/clientObjectionList.go", method = RequestMethod.GET)
	public String clientObjectionList(Model model) {
		
		ArrayList<ObjectionDTO>clientObjectionList =service.clientObjectionList();
		model.addAttribute("clientObjectionList",clientObjectionList);
	
		return "clientObjectionList";
	}
	
	
	
	
	
	
}
