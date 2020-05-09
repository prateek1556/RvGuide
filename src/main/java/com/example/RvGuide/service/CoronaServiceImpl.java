package com.example.RvGuide.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.RvGuide.bean.CoronaWorldTotalBean;
import com.example.RvGuide.dao.CoronaDao;

@Service
public class CoronaServiceImpl implements CoronaService {

	@Autowired
	CoronaDao dao;

	@Override
	public CoronaWorldTotalBean getCoronaWorldTotal() {
		return dao.getCoronaWorldTotal();
	}
	
	
}
