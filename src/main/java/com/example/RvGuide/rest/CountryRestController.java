package com.example.RvGuide.rest;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.RvGuide.bean.CountryBean;


@RestController
@RequestMapping("/countryapi")
public class CountryRestController {

	@Autowired
	public RestTemplate restTemplate; 
	public static final String REST_COUNTRY_URI = "https://restcountries.eu/rest/v2/all";
	@GetMapping("/countries")
	public List<CountryBean> getCountryList() {

		CountryBean[] country = restTemplate.getForObject(REST_COUNTRY_URI, CountryBean[].class);
		
		return Arrays.asList(country);
		
	}
	
	
	
	
}