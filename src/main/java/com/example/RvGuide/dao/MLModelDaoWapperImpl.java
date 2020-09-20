package com.example.RvGuide.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.RvGuide.bean.LinearClassificationBean;
import com.example.RvGuide.bean.LinearClassificationDetailsBean;
import com.example.RvGuide.rest.MLModelsRestController;

@Repository
public class MLModelDaoWapperImpl implements MLModelsDao {

	@Autowired
	MLModelsRestController ml_rest;
	
	public LinearClassificationBean getLCMPrediction(double obp,double slg,double oobp,double oslg){
		return ml_rest.getLCMPrediction(obp, slg, oobp, oslg);
	}
	public LinearClassificationDetailsBean getLCMDetails(){
		return ml_rest.getLCMDetails();
	}
	
}
