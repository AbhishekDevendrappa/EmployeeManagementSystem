package com.employee.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.model.EmployeeRegister;
import com.employee.repo.EmployeeRegisterRepo;


@Service
public class EmployeeRegisterService {
	@Autowired
	EmployeeRegisterRepo registerRepo;

	public void saveUser(EmployeeRegister u) {
		registerRepo.save(u);
	}

	public EmployeeRegister getEmployee(String email, String password) {
		return registerRepo.findByUsernameAndPassword(email, password);
	}
	
	public EmployeeRegister getEmployeeById(Integer id) {
		Optional<EmployeeRegister> o= registerRepo.findById(id);
		if(o.isPresent())
			return o.get();
		return null;
	}	 

	
}
