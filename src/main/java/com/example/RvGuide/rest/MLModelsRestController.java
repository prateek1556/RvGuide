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

import com.example.RvGuide.bean.LinearClassificationBean;
import com.example.RvGuide.bean.LinearClassificationDetailsBean;

@RestController
@RequestMapping("/mlmodelsapi")
public class MLModelsRestController implements CommandLineRunner{

	
	@Autowired
	public RestTemplate restTemplate;
	
	public static final String REST_LINEAR_CLASSIFICATION_MODEL = "http://127.0.0.1:5000/lcmodel";
	
	@PostMapping("/linearclassification")
	public LinearClassificationBean getLCMPrediction(double obp,double slg,double oobp,double oslg){
		System.out.println("Inside getLCMPrediction");
		
		System.out.println("Print original data -> "+ obp);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		LinearClassificationBean obj = new LinearClassificationBean();
		obj.setOBP(obp);
		obj.setSLG(oslg);
		obj.setOOBP(oobp);
		obj.setOSLG(oslg);
		
		
		System.out.println("line 40  obj"+obj);
		HttpEntity<LinearClassificationBean> httpEntity =  new HttpEntity<>(obj, headers);
		System.out.println("line 42 httpEntity"+httpEntity);
		LinearClassificationBean getdata = restTemplate.postForObject(REST_LINEAR_CLASSIFICATION_MODEL, httpEntity, LinearClassificationBean.class);
		System.out.println("QualifyingPercentage --->"+getdata.getQualifyingPercentage());
		System.out.println("Wins --> "+getdata.getWins());
		
		return getdata;
	}
	
	public static final String REST_LINEAR_CLASSIFICATION_DETAILS = "http://127.0.0.1:5000/lcmodel";
	
	@GetMapping("/linearclassificationdetails")
	public LinearClassificationDetailsBean getLCMDetails(){
		System.out.println("Inside LinearClassificationDetailsBean");
		LinearClassificationDetailsBean details = restTemplate.getForObject(REST_LINEAR_CLASSIFICATION_DETAILS, LinearClassificationDetailsBean.class);
		System.out.println("LC Details --->" + details.getIntercept());
		return details;
	}
	
	
	@Override
	public void run(String... args) throws Exception {
		getLCMPrediction(0.33,0.44,0.33,0.44);
		getLCMDetails();
		
	}

}
