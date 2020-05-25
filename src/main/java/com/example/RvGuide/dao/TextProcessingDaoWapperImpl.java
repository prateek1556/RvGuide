package com.example.RvGuide.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.RvGuide.bean.TextProcessingBean;
import com.example.RvGuide.rest.TextProcessingRestController;

@Repository
public class TextProcessingDaoWapperImpl implements TextProcessingDao {

	@Autowired
	TextProcessingRestController txtProcessConsume;
	
	@Override
	public TextProcessingBean getCleanData(String txt) {
		
		return txtProcessConsume.getCleanData(txt);
	}

}
