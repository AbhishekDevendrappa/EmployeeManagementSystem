package com.employee.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.employee.model.EmployeeRegister;

@Repository
public interface EmployeeRegisterRepo extends CrudRepository<EmployeeRegister ,Integer> {
     
	@Query("from EmployeeRegister where email=:email and password=:password")
	public EmployeeRegister findByUsernameAndPassword(String email, String password);

	public EmployeeRegister findByusername(String username);

	
}

