 package com.employee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.model.EmployeeDetails;
import com.employee.model.EmployeeRegister;
import com.employee.repo.EmployeeDetailsRepo;


import jakarta.servlet.http.HttpSession;


@Service
public class EmployeeDetailsService {
	
	@Autowired
	EmployeeDetailsRepo detailsRepo;
	
	@Autowired
	HttpSession httpsession;
	
	public  void  saveEmployee(EmployeeDetails u) {
		detailsRepo.save(u);
	}
	
	public EmployeeDetails getbyId(Integer id){
		return detailsRepo.getByemploeeid(id);
	}

	public void Deleteuser(Integer id) {
		detailsRepo.deleteById(id);
	 }

	public Optional<EmployeeDetails> getbyIdd(Integer id) {
		return detailsRepo.findById(id);
	}
	
	public EmployeeDetails update(EmployeeDetails details) {
		details.setEmployeeRegister((EmployeeRegister)httpsession.getAttribute("id"));
		return detailsRepo.save(details);
	}
	
	public List<EmployeeDetails> getByTitle(String employeerole){
		return (List<EmployeeDetails>)detailsRepo.findByTitle(employeerole);
	}

}
