package com.example.RvGuide.dao;

import com.example.RvGuide.bean.LinearClassificationBean;
import com.example.RvGuide.bean.LinearClassificationDetailsBean;

public interface MLModelsDao {
	
	public LinearClassificationBean getLCMPrediction(double obp,double slg,double oobp,double oslg);
	public LinearClassificationDetailsBean getLCMDetails();

}
