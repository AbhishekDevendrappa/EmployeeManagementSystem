package com.employee.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class EmployeeRegister {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer slno;
	private String username;
	private String email;
	private String password;
	private Long number;
	
	public EmployeeRegister(Integer slno, String username, String email, String password, Long number) {
		super();
		this.slno = slno;
		this.username = username;
		this.email = email;
		this.password = password;
		this.number = number;
	}
	public Long getNumber() {
		return number;
	}
	public void setNumber(Long number) {
		this.number = number;
	}
	
	public Integer getSlno() {
		return slno;
	}
	public void setSlno(Integer slno) {
		this.slno = slno;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public EmployeeRegister() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "User [slno=" + slno + ", username=" + username + ", email=" + email + ", password=" + password
				+ ", number=" + number + "]";
	}
	
	
	
	

}
