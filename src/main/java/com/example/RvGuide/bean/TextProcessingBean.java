package com.example.RvGuide.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties
public class TextProcessingBean {

	@JsonProperty
	private String text;

	@JsonProperty
	public String Sentiment;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getSentiment() {
		return Sentiment;
	}

	public void setSentiment(String sentiment) {
		Sentiment = sentiment;
	}

}
