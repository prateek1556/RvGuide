package com.example.RvGuide.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.RvGuide.bean.AlgorithmBean;
import com.example.RvGuide.service.AlgorithmService;
import com.example.RvGuide.service.UserService;

@Controller
public class MainController {
		
	@Autowired
	AlgorithmService algoService;
	
	@Autowired
	UserService userService;
	
	@GetMapping("/practicecode")
	public ModelAndView practiceCode() {
		ModelAndView mvn = new ModelAndView();
		mvn.setViewName("practicecode");
		return mvn;
	}
		
	
	@GetMapping("/datastructure")
	public ModelAndView dataStructure() {
		ModelAndView mvn = new ModelAndView();
		mvn.setViewName("datastructure");
		return mvn;
	}

	@GetMapping("/machinelearning")
	public ModelAndView machineLearning() {
		ModelAndView mvn = new ModelAndView();
		mvn.setViewName("machinelearning");
		return mvn;
	}

	

}
