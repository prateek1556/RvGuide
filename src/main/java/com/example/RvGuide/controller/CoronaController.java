package com.example.RvGuide.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.RvGuide.bean.CoronaWorldTotalBean;
import com.example.RvGuide.bean.Countries;
import com.example.RvGuide.bean.CountryBean;
import com.example.RvGuide.service.CoronaService;
import com.example.RvGuide.service.CountryService;

@Controller
@RequestMapping("/coronavirus")
public class CoronaController {
	
	@Autowired
	CoronaService coronaService;
	
	@Autowired
	CountryService cServ;
	
	@GetMapping
	public ModelAndView coconaVirus() {
		System.out.println("Inside Test");
		ModelAndView mvn = new ModelAndView();
		
		CoronaWorldTotalBean bean = coronaService.getCoronaWorldTotal();
		List<Countries> country_list = coronaService.getCoronaCountry();
		
		mvn.addObject("list",country_list);
		mvn.addObject("corona",bean);
		System.out.println("Showing page");
		mvn.setViewName("CoronaVirus");
		return mvn;
	}
	
	@GetMapping(path = {"/{coutnry}"})
	public ModelAndView getDetailsByCountry(@PathVariable("coutnry") String country){
		System.out.println("Enter into get details by country");
		ModelAndView mvn = new ModelAndView();
		List<Countries> corona_country_list = coronaService.getCoronaCountry();
		Countries getCountry = new Countries();
		for(Countries c: corona_country_list){
			if(c.getCountry().equalsIgnoreCase(country)){
				getCountry = c;
				break;
			}
		}
		
		List<CountryBean> countryList = cServ.getCountries();
		String flag = new String();
		for(CountryBean c : countryList){
			if(c.getName().equalsIgnoreCase(country)){
				flag = c.getFlag();
			}
		}
		
		mvn.addObject("countryImg",flag);
		mvn.addObject("country",getCountry);
		mvn.setViewName("CounrtyDetails");
		return mvn;
		
	}

}
