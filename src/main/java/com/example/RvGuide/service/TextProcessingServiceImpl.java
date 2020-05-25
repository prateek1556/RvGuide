package com.example.RvGuide.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.RvGuide.bean.TextProcessingBean;
import com.example.RvGuide.dao.TextProcessingDao;

@Service
public class TextProcessingServiceImpl implements TextProcessingService {
	
	@Autowired
	TextProcessingDao dao;
	
	@Override
	public TextProcessingBean getCleanData(String txt) {
		return dao.getCleanData(txt);
	}

}
