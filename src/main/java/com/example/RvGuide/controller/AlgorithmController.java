package com.example.RvGuide.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.example.RvGuide.bean.AlgorithmBean;
import com.example.RvGuide.service.AlgorithmService;
import com.example.RvGuide.service.UserService;

@Controller
@RequestMapping("/algorithm")
//@SessionAttributes({"algoObj1","algoObj2"})
public class AlgorithmController {
	
	@Autowired
	AlgorithmService algoService;
	
	@Autowired
	UserService userService;
	
	@GetMapping
	public ModelAndView algorithms() {
		System.out.println("initiating Algo Page");
		ModelAndView mvn = new ModelAndView();
		String currentPrincipalName = get_username();
		System.out.println("Printing Email ---> "+currentPrincipalName);
		List<AlgorithmBean> algoList = algoService.getAlgorithmByEmail(currentPrincipalName);
		System.out.println("Algo List Object --->"+algoList);
		mvn.setViewName("algorithm");
		mvn.addObject("algorithmList",algoList);
		return mvn;
	}
	
	
	@GetMapping("/addalgorithm")
	public ModelAndView add_algorithm() {
		System.out.println("loding addalgo page");
		ModelAndView mvn = new ModelAndView("addalgorithm","algorithmBean",new AlgorithmBean());
		System.out.println("algo page loaded");
		return mvn;
	}
	
	@PostMapping(value="/algorithmadded")
	public ModelAndView algorithmAdded(@ModelAttribute("algorithmBean") AlgorithmBean algorithmBean){
		ModelAndView mvn = new ModelAndView();
		System.out.println("Start Posting");
		//System.out.println("Printing BindingResults ---->"+bindingResult.getErrorCount()+"++++++ "+bindingResult.getAllErrors());
		System.out.println("Setting Email");
		String currentPrincipalName = get_username();
		algorithmBean.setEmail(currentPrincipalName);
		System.out.println("Email Set");
		
			algoService.saveAlgorithm(algorithmBean);
			
			
		mvn.setViewName("addalgorithm");
		mvn.addObject("SuccessMessage","Algorithm Added");
		System.out.println("finally algo posted in database");
		return mvn;
	}
	
	@GetMapping(path = {"/loadupdatealgorithm/{id}"})
	public ModelAndView loadUpdateAlgorithm(@PathVariable("id") int id){
		System.out.println("Inside /loadupdatealgorithm/{id} in controller");
		ModelAndView mvn = new ModelAndView();//("UpdateAlgorithm","algorithmBean",new AlgorithmBean());
		AlgorithmBean algobean = algoService.getAlgorithmById(id);
		mvn.addObject("algoObj2",algobean);
		
		mvn.setViewName("UpdateAlgorithm");
		return mvn;
	}
	
	@PostMapping(path = {"/updatealgorithm/{id}"})
	public ModelAndView updateAlgorithm(@ModelAttribute("algoObj2") AlgorithmBean algorithmBean ,@PathVariable("id") int id){
		ModelAndView mvn = new ModelAndView("UpdateAlgorithm");
		algoService.updateAlgorithm(algorithmBean);
		mvn.addObject("SuccessMessage","Algorithm has been updated");
		mvn.setViewName("UpdateAlgorithmSuccess");
		return mvn;
	}
	
	
	@GetMapping(path={"/loaddeletealgorithm/{id}"})
	public ModelAndView deleteAlgorithm(@PathVariable("id") int id){
		ModelAndView mvn = new ModelAndView();
		AlgorithmBean algoBean = algoService.getAlgorithmById(id);
		mvn.addObject("algoObj2",algoBean);
		mvn.setViewName("DeleteAlgorithm");
		return mvn;
	}
	
	@PostMapping(path = {"/deletealgorithm/{id}"})
	public ModelAndView deleteAlgorithm(@ModelAttribute("algoObj2") AlgorithmBean algorithmBean ,@PathVariable("id") int id){
		ModelAndView mvn = new ModelAndView();
		algoService.deleteAlgorithm(algorithmBean);
		mvn.addObject("SuccessMessage","Algorithm has been deteted");
		mvn.setViewName("DeleteAlgorithmSuccess");
		return mvn;
	}
	
	@GetMapping(path = {"/getalgorithm/{id}"})
	public ModelAndView getAlgoroithm(@PathVariable("id") int id){
		ModelAndView mvn = new ModelAndView();
		AlgorithmBean algoBean = algoService.getAlgorithmById(id);
		mvn.setViewName("ShowAlgorithm");
		mvn.addObject("algorithm",algoBean.getAlgorithm_data());
		return mvn;
	}
	
	public String get_username(){
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
		    String currentUserName = authentication.getName();
		    return currentUserName;
		}
		return "user not authenticated";
	}

	
}
