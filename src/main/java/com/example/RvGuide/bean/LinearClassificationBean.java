package com.example.RvGuide.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties
public class LinearClassificationBean {

	@JsonProperty
	private double OBP;
	
	@JsonProperty
	private double SLG;
	
	@JsonProperty
	private double OOBP;
	
	@JsonProperty
	private double OSLG;
	
	@JsonProperty
	private double QualifyingPercentage;
	
	@JsonProperty
	private double wins;

	public double getOBP() {
		return OBP;
	}

	public void setOBP(double oBP) {
		OBP = oBP;
	}

	public double getSLG() {
		return SLG;
	}

	public void setSLG(double sLG) {
		SLG = sLG;
	}

	public double getOOBP() {
		return OOBP;
	}

	public void setOOBP(double oOBP) {
		OOBP = oOBP;
	}

	public double getOSLG() {
		return OSLG;
	}

	public void setOSLG(double oSLG) {
		OSLG = oSLG;
	}

	public double getQualifyingPercentage() {
		return QualifyingPercentage;
	}

	public void setQualifyingPercentage(double qualifyingPercentage) {
		QualifyingPercentage = qualifyingPercentage;
	}

	public double getWins() {
		return wins;
	}

	public void setWins(double wins) {
		this.wins = wins;
	}

	
	
	
	
	
}
