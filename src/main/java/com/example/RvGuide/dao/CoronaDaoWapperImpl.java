package com.example.RvGuide.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.RvGuide.bean.CoronaWorldTotalBean;
import com.example.RvGuide.bean.Countries;
import com.example.RvGuide.rest.CoronaRestController;

@Repository
public class CoronaDaoWapperImpl implements CoronaDao {

	@Autowired
	CoronaRestController consumeCorona;

	@Override
	public CoronaWorldTotalBean getCoronaWorldTotal() {

		return consumeCorona.getCoronaWorldTotal();
	}

	@Override
	public List<Countries> getCoronaCountry() {

		return consumeCorona.getCoronaCountry();
	}

}
