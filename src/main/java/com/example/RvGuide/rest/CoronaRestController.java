package com.example.RvGuide.rest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.RvGuide.bean.CoronaCountryStatusBean;
import com.example.RvGuide.bean.CoronaWorldTotalBean;
import com.example.RvGuide.bean.CountryBean;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/coronaapi")
public class CoronaRestController implements CommandLineRunner{

	@Autowired
	public RestTemplate restTemplate; 
	
//	
//	public static final String REST_WORLD_CORONA_URI = "https://api.covid19api.com/world/total";
//	@RequestMapping(value="/coronavirus/world", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<CoronaWorldTotalBean> getCountryList() {
//		CoronaWorldTotalBean total = restTemplate.getForObject(REST_WORLD_CORONA_URI, CoronaWorldTotalBean.class);
//		System.out.println("CoronaWorldTotalBean --->"+total.getTotalConfirmed());
//		total.setTotalConfirmed(1000);
//		return new ResponseEntity<CoronaWorldTotalBean>(total,HttpStatus.OK);
//		
//	}
	

	public static final String REST_WORLD_CORONA_URI = "https://api.covid19api.com/world/total";
	@GetMapping(value="/coronavirus/world")
	public CoronaWorldTotalBean getCoronaWorldTotal() {
		CoronaWorldTotalBean total = restTemplate.getForObject(REST_WORLD_CORONA_URI, CoronaWorldTotalBean.class);
		System.out.println("CoronaWorldTotalBean --->"+total.getTotalConfirmed());
		return total;
		
	}
	@Override
	public void run(String... args) throws Exception {
		getCoronaWorldTotal();
		
	}
	
	

	
}
