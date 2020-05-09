package com.example.RvGuide.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class CoronaCountryStatusBean {

	private String Country;
	private int Confirmed;

	public String getCountry() {
		return Country;
	}

	public void setCountry(String country) {
		Country = country;
	}

	public int getConfirmed() {
		return Confirmed;
	}

	public void setConfirmed(int confirmed) {
		Confirmed = confirmed;
	}

}
