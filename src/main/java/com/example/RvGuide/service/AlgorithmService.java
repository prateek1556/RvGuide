package com.example.RvGuide.service;

import java.util.List;

import com.example.RvGuide.bean.AlgorithmBean;
import com.example.RvGuide.bean.UserBean;

public interface AlgorithmService {

	
	public void saveAlgorithm(AlgorithmBean algorithmBean);
	
	public List<AlgorithmBean> getAlgorithmByEmail(String email);
	
	public AlgorithmBean getAlgorithmById(int id);
	
	public void updateAlgorithm(AlgorithmBean algorithmBean);
	
	public void deleteAlgorithm(AlgorithmBean algorithmBean);
	
}
