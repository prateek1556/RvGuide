package com.example.RvGuide.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.RvGuide.bean.CountryBean;
import com.example.RvGuide.rest.CountryRestController;

@Repository
public class CountryDaoWapperImpl implements CountryDao {

	@Autowired
	CountryRestController consumeCountry;
	
	@Override
	public List<CountryBean> getCountries() {
		// TODO Auto-generated method stub
		return consumeCountry.getCountryList();
	}

}
