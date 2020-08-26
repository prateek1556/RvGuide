package com.example.RvGuide.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.RvGuide.service.MLModelsService;

@Controller
@RequestMapping("/mlmodels")
public class MLModelController {
	
	@Autowired
	MLModelsService ml_model;
	
	@PostMapping
	public ModelAndView getLCPredictions(double obp,double slg,double oobp,double oslg){
		return null;
	}
	
	@GetMapping
	public ModelAndView getLCModelDetails(){
		return null;
	}

}
