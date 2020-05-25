package com.example.RvGuide.dao;

import com.example.RvGuide.bean.TextProcessingBean;

public interface TextProcessingDao {
	
	public TextProcessingBean getCleanData(String txt);

}
