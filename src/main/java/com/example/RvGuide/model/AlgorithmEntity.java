package com.example.RvGuide.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_algorithm")
public class AlgorithmEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "algorithm_id", unique = true, nullable = false)
	private int algorithm_id;

	@Column(name = "email")
	private String email;

	@Column(name = "algorithm_title")
	private String title;

	@Column(name = "algorithm_data")
	private String algorithm_data;

	public int getAlgorithm_id() {
		return algorithm_id;
	}

	public void setAlgorithm_id(int algorithm_id) {
		this.algorithm_id = algorithm_id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAlgorithm_data() {
		return algorithm_data;
	}

	public void setAlgorithm_data(String algorithm_data) {
		this.algorithm_data = algorithm_data;
	}

}
