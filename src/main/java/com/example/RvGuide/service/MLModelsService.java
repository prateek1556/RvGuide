package com.example.RvGuide.service;

import com.example.RvGuide.bean.LinearClassificationBean;
import com.example.RvGuide.bean.LinearClassificationDetailsBean;

public interface MLModelsService {

	public LinearClassificationBean getLCMPrediction(double obp,double slg,double oobp,double oslg);
	public LinearClassificationDetailsBean getLCMDetails();
	
}
