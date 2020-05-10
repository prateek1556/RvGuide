package com.example.RvGuide.dao;

import java.util.List;

import com.example.RvGuide.bean.CoronaWorldTotalBean;
import com.example.RvGuide.bean.Countries;

public interface CoronaDao {
	
	public CoronaWorldTotalBean getCoronaWorldTotal();
	
	public List<Countries> getCoronaCountry();
}
