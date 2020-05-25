package com.example.RvGuide.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.RvGuide.bean.TextProcessingBean;

@RestController
@RequestMapping("/textprocessingapi")
public class TextProcessingRestController implements CommandLineRunner {
	
	@Autowired
	public RestTemplate restTemplate;
	

	public static final String REST_TEXT_PROCESS = "http://127.0.0.1:5000/cleandata";
	
	@PostMapping(value="/cleandata")
	public TextProcessingBean getCleanData(String text){
		System.out.println("Inside getCleanData");
		
		System.out.println("Print original data -> "+ text);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		TextProcessingBean obj = new TextProcessingBean();
		obj.setText(text);
		
		
		System.out.println("line 45  obj"+obj);
		HttpEntity<TextProcessingBean> httpEntity =  new HttpEntity<>(obj, headers);
		System.out.println("line 47 httpEntity"+httpEntity);
		TextProcessingBean gettext = restTemplate.postForObject(REST_TEXT_PROCESS, httpEntity, TextProcessingBean.class);
		System.out.println("Printing Clean Text"+gettext.getText());
		System.out.println("Sentiment --> "+gettext.getSentiment());
		
		
		return gettext;
	}

	@Override
	public void run(String... args) throws Exception {
		//getCleanData(null);
		
	}

}
