package com.example.RvGuide.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.RvGuide.bean.CountryBean;

public interface CountryDao {
	
	List<CountryBean> getCountries();
}
