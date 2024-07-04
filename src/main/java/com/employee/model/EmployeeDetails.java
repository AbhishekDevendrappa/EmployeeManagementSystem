package com.employee.model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class EmployeeDetails {
	
	public EmployeeDetails() {
		// TODO Auto-generated constructor stub
	}
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer slno;
	private String employeename;
	private String email;
	private Long contactnumber;
	private Date dateofbirth;
	private String gender;
	private String employeerole;
	private String employeedepartment;
	private Integer age;
	
	@OneToOne
	private EmployeeRegister employeeRegister;
	
	
	public EmployeeRegister getEmployeeRegister() {
		return employeeRegister;
	}
	public void setEmployeeRegister(EmployeeRegister employeeRegister) {
		this.employeeRegister = employeeRegister;
	}
	public Integer getSlno() {
		return slno;
	}
	public void setSlno(Integer slno) {
		this.slno = slno;
	}
	public String getEmployeename() {
		return employeename;
	}
	public void setEmployeename(String employeename) {
		this.employeename = employeename;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getContactnumber() {
		return contactnumber;
	}
	public void setContactnumber(Long contactnumber) {
		this.contactnumber = contactnumber;
	}
	public Date getDateofbirth() {
		return dateofbirth;
	}
	public void setDateofbirth(Date dateofbirth) {
		this.dateofbirth = dateofbirth;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmployeerole() {
		return employeerole;
	}
	public void setEmployeerole(String employeerole) {
		this.employeerole = employeerole;
	}
	public String getEmployeedepartment() {
		return employeedepartment;
	}
	public void setEmployeedepartment(String employeedepartment) {
		this.employeedepartment = employeedepartment;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public EmployeeDetails(Integer slno, String employeename,String email, Long contactnumber,
			Date dateofbirth, String gender, String employeerole, String employeedepartment, Integer age) {
		super();
		this.slno = slno;
		this.employeename = employeename;
		this.email = email;
		this.contactnumber = contactnumber;
		this.dateofbirth = dateofbirth;
		this.gender = gender;
		this.employeerole = employeerole;
		this.employeedepartment = employeedepartment;
		this.age = age;
	}
	@Override
	public String toString() {
		return "EmployeeDetails [slno=" + slno + ", employeename=" + employeename +  ", email="
				+ email + ", contactnumber=" + contactnumber + ", dateofbirth=" + dateofbirth + ", gender=" + gender
				+ ", employeerole=" + employeerole + ", employeedepartment=" + employeedepartment + ", age=" + age
				+ "]";
	}
	
	
	
}

