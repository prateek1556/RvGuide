package com.example.RvGuide.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.RvGuide.bean.CoronaSummaryBean;
import com.example.RvGuide.bean.CoronaWorldTotalBean;
import com.example.RvGuide.bean.Countries;

@RestController
@RequestMapping("/coronaapi")
public class CoronaRestController implements CommandLineRunner {

	@Autowired
	public RestTemplate restTemplate;

	public static final String REST_WORLD_CORONA_URI = "https://api.covid19api.com/world/total";

	@GetMapping(value = "/world")
	public CoronaWorldTotalBean getCoronaWorldTotal() {
		CoronaWorldTotalBean world_total = restTemplate.getForObject(REST_WORLD_CORONA_URI, CoronaWorldTotalBean.class);
		System.out.println("CoronaWorldTotalBean --->" + world_total.getTotalConfirmed());
		return world_total;

	}
	
	public static final String REST_COUNTRY_CORONA_URI = "https://api.covid19api.com/summary";
	
	@GetMapping(value="/countries")
	public List<Countries> getCoronaCountry(){
		//ObjectMapper mapper = new ObjectMapper();
		CoronaSummaryBean countries_summary = restTemplate.getForObject(REST_COUNTRY_CORONA_URI, CoronaSummaryBean.class);
		
		
		System.out.println("countries_summary----> "+countries_summary.getCountries());
		
		List<Countries> list = new ArrayList<>(); 
		
		for(Countries c:countries_summary.getCountries()){
			System.out.println(c.getNewConfirmed());
			list.add(c);
		}
		return list;//Arrays.asList(countries_summary.getCountries());
	}

	@Override
	public void run(String... args) throws Exception {
		//getCoronaCountry();

	}

}
