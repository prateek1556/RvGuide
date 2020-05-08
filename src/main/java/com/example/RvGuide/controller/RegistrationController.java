package com.example.RvGuide.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.RvGuide.bean.CountryBean;
import com.example.RvGuide.bean.UserBean;
import com.example.RvGuide.service.CountryService;
import com.example.RvGuide.service.UserService;

@Controller
public class RegistrationController {

	@Autowired
	CountryService cServ;
	
	@Autowired
	UserService userService;
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder){
		
		StringTrimmerEditor ste = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, ste);
		
	}
	
	@GetMapping(value = "/loadregistration")
	public ModelAndView register() {
		System.out.println("Regestration Iniciated");
		ModelAndView modelAndView = new ModelAndView("register","userBean",new UserBean());
		
		List<CountryBean> countryList = cServ.getCountries();
		List<String> countries_name = new ArrayList<String>();
		
		for(CountryBean c : countryList){
			countries_name.add(c.getName());
		}
		
		
		modelAndView.addObject("countries",countries_name);
		
		System.out.println("Returning Regestration page");
		return modelAndView;
	}

	

	@PostMapping(value="/registration")
	public ModelAndView registerUser(@ModelAttribute("userBean") @Valid UserBean userBean,BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView();
		System.out.println("Regestration form filling started");
		System.out.println("Printing BindingResults ---->"+bindingResult.getErrorCount()+"++++++ "+bindingResult.getAllErrors());
		if(bindingResult.hasErrors()) {
			modelAndView.addObject("successMessage", "Please correct the errors in form!");
			System.out.println("Inside hasError registeration");
			//modelMap.addAttribute("bindingResult", bindingResult);
		}
		else if(userService.isUserAlreadyPresent(userBean)){
			modelAndView.addObject("successMessage", "user already exists!");
			System.out.println("Inside user not exist");
		}
		else {
			userService.saveUser(userBean);
			System.out.println("User is registered successfully!");
			modelAndView.addObject("successMessage", "User is registered successfully!");
			
		}
		
		List<CountryBean> countryList = cServ.getCountries();
		List<String> countries_name = new ArrayList<String>();
		
		for(CountryBean c : countryList){
			countries_name.add(c.getName());
		}
		
		modelAndView.addObject("countries",countries_name);
		
		//modelAndView.addObject("userBean", new UserBean());
		modelAndView.setViewName("register");
		System.out.println("finally registration result posting user in data base");
		return modelAndView;
	}
	
	@ModelAttribute("countryList")
	public List<CountryBean> getCountries(){
		System.out.println("Inside model attribute countryList");
		List<CountryBean> c = new ArrayList<CountryBean>();
		c = cServ.getCountries();
		return c;
	}
	
}
