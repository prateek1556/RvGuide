package com.example.RvGuide.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.RvGuide.bean.CoronaWorldTotalBean;
import com.example.RvGuide.service.CoronaService;

@Controller
@RequestMapping("/coronavirus")
public class CoronaController {
	
	@Autowired
	CoronaService coronaService;
	
	@GetMapping
	public ModelAndView coconaVirus() {
		System.out.println("Inside Test");
		ModelAndView mvn = new ModelAndView();
		
		CoronaWorldTotalBean bean = coronaService.getCoronaWorldTotal();
		System.out.println("Bean --->"+bean);
		mvn.addObject("corona",bean);
		System.out.println("Showing page");
		mvn.setViewName("CoronaVirus");
		return mvn;
	}

}
