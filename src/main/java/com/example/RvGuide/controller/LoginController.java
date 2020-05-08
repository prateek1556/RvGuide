package com.example.RvGuide.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.example.RvGuide.bean.CountryBean;
import com.example.RvGuide.bean.LoginBean;
import com.example.RvGuide.bean.UserBean;
import com.example.RvGuide.service.CountryService;
import com.example.RvGuide.service.UserService;

@Controller
//@SessionAttributes({"loginBean"})
public class LoginController {
	
	@Autowired
	CountryService cServ;
	
	@Autowired
	UserService userService;

	@GetMapping(value = "/login" )
	public ModelAndView login() {
		ModelAndView mvn = new ModelAndView("login","loginBean",new LoginBean());
		System.out.println("login User++++++++++");
		return mvn;
	}

	
	
	@GetMapping(value = "/home")
	public ModelAndView handleLoginRequest() {
		ModelAndView modelAndView = new ModelAndView();
		//Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		//String currentPrincipalName = authentication.getName();
		String currentPrincipalName = get_username();
		System.out.println("Principle --->"+currentPrincipalName);
		modelAndView.addObject("email",(String) currentPrincipalName);
		UserBean user = userService.getUserByEmail(currentPrincipalName);
		System.out.println("country-----> " +user.getCountry());
		modelAndView.addObject("firstName",user.getFirstName());
		
		
		
		List<CountryBean> countryList = cServ.getCountries();
		String country = user.getCountry();
		int flag=0;
		for(CountryBean c : countryList){
			System.out.println(c.getName());
			System.out.println(c.getFlag());
			if(c.getName().equals(country)){
				System.out.println("-------"+c.getName());
				System.out.println("-------"+c.getFlag());
				modelAndView.addObject("countryImg",c.getFlag());
				flag=1;
				break;
			}
		}
		if (flag==0){
			modelAndView.addObject("countryImg","Image not found");
		}
		modelAndView.setViewName("home");
		
		return modelAndView;
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
