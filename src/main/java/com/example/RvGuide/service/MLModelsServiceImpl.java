package com.example.RvGuide.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.RvGuide.bean.LinearClassificationBean;
import com.example.RvGuide.bean.LinearClassificationDetailsBean;
import com.example.RvGuide.dao.MLModelsDao;

@Service
public class MLModelsServiceImpl implements MLModelsService{

	@Autowired
	MLModelsDao ml_dao;
	
	public LinearClassificationBean getLCMPrediction(double obp,double slg,double oobp,double oslg){
		return ml_dao.getLCMPrediction(obp, slg, oobp, oslg);
	}
	
	public LinearClassificationDetailsBean getLCMDetails(){
		return ml_dao.getLCMDetails();
	}
	
	
	
}
