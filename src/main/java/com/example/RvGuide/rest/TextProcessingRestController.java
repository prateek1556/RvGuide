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

import com.example.RvGuide.bean.TextProcessing;

@RestController
@RequestMapping("/textprocessingapi")
public class TextProcessingRestController implements CommandLineRunner {
	
	@Autowired
	public RestTemplate restTemplate;
	

	public static final String REST_TEXT_PROCESS = "http://127.0.0.1:5000/cleandata";
	
	@PostMapping(value="/cleandata")
	public String getCleanData(){
		System.out.println("Inside getCleanData");
		String text="nd scale.#$@#$[5]Observed temperature from NASA[6]"
				+ " vs the 1850–1900 average used by "
				+ "the IPCC as a pre-industrial baseline.[7] "
				+ "The primary driver for increased global temperatures "
				+ "in the industrial era is human activity, with natural "
				+ "forces adding variability.[8]The Intergovernmental "
				+ "Panel on Climate Change (IPCC) concluded that human influence "
				+ "on climate has been the dominant cause of observed warming since "
				+ "the mid-20th century .[9] These";
		
		System.out.println("Print original data -> "+ text);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		TextProcessing obj = new TextProcessing();
		obj.setText(text);
		
		
		System.out.println("line 45  obj"+obj);
		HttpEntity<TextProcessing> httpEntity =  new HttpEntity<>(obj, headers);
		System.out.println("line 47 httpEntity"+httpEntity);
		TextProcessing gettext = restTemplate.postForObject(REST_TEXT_PROCESS, httpEntity, TextProcessing.class);
		System.out.println("Printing Clean Text"+gettext.getText());
		
		
		return null;
	}

	@Override
	public void run(String... args) throws Exception {
		getCleanData();
		
	}

}
