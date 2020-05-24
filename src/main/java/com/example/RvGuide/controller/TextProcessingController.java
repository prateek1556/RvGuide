package com.example.RvGuide.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.RvGuide.bean.TextProcessing;
import com.example.RvGuide.service.TextProcessingService;

@Controller
@RequestMapping("/textprocessing")
public class TextProcessingController {
	
	@Autowired
	TextProcessingService txtService;
	
	@GetMapping
	public ModelAndView textProcessing() {
		ModelAndView mvn = new ModelAndView("textprocessing","txtBean",new TextProcessing());
		return mvn;
	}
	
	@PostMapping("/getprocessedtext") 
	public ModelAndView getProcessedText(@ModelAttribute("txtBean") TextProcessing txtBean){
		ModelAndView mvn = new ModelAndView();
		System.out.println("Controller Print ++++ txt ---> "+txtBean.getText());
		String str = txtService.getCleanData(txtBean.getText());
		mvn.setViewName("CleanText");
		mvn.addObject("cleantxt",str);
		return mvn;
	}
	
}
