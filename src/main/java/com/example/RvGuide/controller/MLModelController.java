package com.example.RvGuide.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.RvGuide.bean.LinearClassificationBean;
import com.example.RvGuide.bean.TextProcessingBean;
import com.example.RvGuide.service.MLModelsService;

@Controller
@RequestMapping("/mlmodels")
public class MLModelController {
	
	@Autowired
	MLModelsService ml_model;
	
	@GetMapping("/baseballpredict")
	public ModelAndView getLCPage(){
		ModelAndView mvn = new ModelAndView("baseballpredict","lcBean",new LinearClassificationBean() );
		return mvn;
	}
	
	@PostMapping("/getlcprediction")
	public ModelAndView getLCPredictions(@ModelAttribute("lcBean") LinearClassificationBean lcBean){
		ModelAndView mvn = new ModelAndView();
		LinearClassificationBean lcResbean = ml_model.getLCMPrediction(lcBean.getOBP(), lcBean.getSLG(), lcBean.getOOBP(), lcBean.getOSLG());
		double qPercentage = lcResbean.getQualifyingPercentage();
		double wins = lcResbean.getWins();
		int w = (int) lcResbean.getWins();
		if (wins-w>0.5){
			w = w+1;
		}
		mvn.setViewName("baseballresult");
		mvn.addObject("wins",w);
		mvn.addObject("qper",qPercentage);
		return mvn;
	}
	
	@GetMapping("/getlcdetails")
	public ModelAndView getLCModelDetails(){
		return null;
	}

}
