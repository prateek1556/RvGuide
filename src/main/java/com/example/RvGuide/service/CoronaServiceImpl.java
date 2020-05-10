package com.example.RvGuide.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.RvGuide.bean.CoronaWorldTotalBean;
import com.example.RvGuide.bean.Countries;
import com.example.RvGuide.dao.CoronaDao;

@Service
public class CoronaServiceImpl implements CoronaService {

	@Autowired
	CoronaDao dao;

	@Override
	public CoronaWorldTotalBean getCoronaWorldTotal() {
		return dao.getCoronaWorldTotal();
	}

	@Override
	public List<Countries> getCoronaCountry() {
		
		
		List<Countries> country_list = dao.getCoronaCountry();
		for(Countries c : country_list ){
			 c.setActiveCases(c.getTotalConfirmed()-c.getTotalDeaths()-c.getTotalRecovered()); 
		}
		return country_list;
	}
	
	
}
