package com.example.RvGuide.service;

import java.util.List;

import com.example.RvGuide.bean.CoronaWorldTotalBean;
import com.example.RvGuide.bean.Countries;

public interface CoronaService {

	public CoronaWorldTotalBean getCoronaWorldTotal();
	
	public List<Countries> getCoronaCountry();
	
}
