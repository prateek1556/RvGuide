package com.example.RvGuide.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LinearClassificationDetailsBean {
	
	@JsonProperty
	private double intercept;

	public double getIntercept() {
		return intercept;
	}

	public void setIntercept(double intercept) {
		this.intercept = intercept;
	}
	
}
