package com.employee.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ManagerDetails {
	
	public ManagerDetails() {
		// TODO Auto-generated constructor stub
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer slno;
	private String name;
	private String email;
	private String password;
	private Long Number;
	
	public Integer getSlno() {
		return slno;
	}
	public void setSlno(Integer slno) {
		this.slno = slno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public Long getNumber() {
		return Number;
	}
	public void setNumber(Long number) {
		Number = number;
	}
	
	public ManagerDetails(Integer slno, String name, String email, String password, Long number) {
		super();
		this.slno = slno;
		this.name = name;
		this.email = email;
		this.password = password;
		this.Number = number;
		
	}
	@Override
	public String toString() {
		return "Recuiter [slno=" + slno + ", name=" + name + ", email=" + email + ", password=" + password + ", Number="
				+ Number + "]";
	}
	
	

}
