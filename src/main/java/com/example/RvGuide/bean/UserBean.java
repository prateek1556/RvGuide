package com.example.RvGuide.bean;

import java.util.Set;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.example.RvGuide.model.Role;

public class UserBean {

	
	private int id;
	
	@NotEmpty(message="Please enter your first name")
	@Size(min=3,message="Your first name should have atlest 3 characters")
	private String firstName;
	
	@NotEmpty(message="Please enter your last name")
	@Size(min=3,message="Your last name should have atlest 3 characters")
	private String lastName;

	@NotEmpty(message="Please enter your email")
	private String email;

	@NotEmpty(message="Please select your country")
	private String country;

	@NotEmpty(message="Please enter your password")
	private String password;

	private String status;

	private Set<Role> roles;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "UserBean [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", country=" + country + ", password=" + password + ", status=" + status + ", roles=" + roles + "]";
	}
	
	

}
