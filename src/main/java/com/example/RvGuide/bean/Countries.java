package com.example.RvGuide.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Countries {

	@JsonProperty("Country")
	private String country;

	@JsonProperty("TotalConfirmed")
	private int totalConfirmed;

	@JsonProperty("TotalDeaths")
	private int totalDeaths;

	@JsonProperty("TotalRecovered")
	private int totalRecovered;

	@JsonProperty("NewConfirmed")
	private int newConfirmed;

	@JsonProperty("NewDeaths")
	private int newDeaths;

	@JsonProperty("NewRecovered")
	private int newRecovered;

	private int activeCases;

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getTotalConfirmed() {
		return totalConfirmed;
	}

	public void setTotalConfirmed(int totalConfirmed) {
		this.totalConfirmed = totalConfirmed;
	}

	public int getTotalDeaths() {
		return totalDeaths;
	}

	public void setTotalDeaths(int totalDeaths) {
		this.totalDeaths = totalDeaths;
	}

	public int getTotalRecovered() {
		return totalRecovered;
	}

	public void setTotalRecovered(int totalRecovered) {
		this.totalRecovered = totalRecovered;
	}

	public int getNewConfirmed() {
		return newConfirmed;
	}

	public void setNewConfirmed(int newConfirmed) {
		this.newConfirmed = newConfirmed;
	}

	public int getNewDeaths() {
		return newDeaths;
	}

	public void setNewDeaths(int newDeaths) {
		this.newDeaths = newDeaths;
	}

	public int getNewRecovered() {
		return newRecovered;
	}

	public void setNewRecovered(int newRecovered) {
		this.newRecovered = newRecovered;
	}

	public int getActiveCases() {
		return activeCases;
	}

	public void setActiveCases(int activeCases) {
		this.activeCases = activeCases;
	}

}
