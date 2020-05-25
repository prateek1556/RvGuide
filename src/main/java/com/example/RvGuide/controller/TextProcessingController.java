package com.example.RvGuide.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.RvGuide.bean.TextProcessingBean;
import com.example.RvGuide.service.TextProcessingService;

@Controller
@RequestMapping("/textprocessing")
public class TextProcessingController {
	
	@Autowired
	TextProcessingService txtService;
	
	@GetMapping
	public ModelAndView textProcessing() {
		ModelAndView mvn = new ModelAndView("textprocessing","txtBean",new TextProcessingBean());
		return mvn;
	}
	
	@PostMapping("/getprocessedtext") 
	public ModelAndView getProcessedText(@ModelAttribute("txtBean") TextProcessingBean txtBean){
		ModelAndView mvn = new ModelAndView();
		System.out.println("Controller Print ++++ txt ---> "+txtBean.getText());
		TextProcessingBean txt_obj = txtService.getCleanData(txtBean.getText());
		String str = txt_obj.getText();
		String review = str.substring(0, 2).toUpperCase() + txt_obj.getText().substring(2);
		System.out.println("review --->"+review);
		mvn.setViewName("CleanText");
		mvn.addObject("review",review);
		mvn.addObject("sentiment",txt_obj.getSentiment());
		System.out.println("Sentiments ---> "+txt_obj.getSentiment());
		return mvn;
	}
	
}
