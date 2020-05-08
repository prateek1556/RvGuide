package com.example.RvGuide.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.RvGuide.bean.CountryBean;
import com.example.RvGuide.dao.CountryDao;

@Service
public class CountryServiceImpl implements CountryService {

	@Autowired
	CountryDao dao;
	
	@Override
	public List<CountryBean> getCountries() {
		return dao.getCountries();
	}

}
