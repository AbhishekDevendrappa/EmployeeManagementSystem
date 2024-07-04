package com.employee.repo;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.employee.model.EmployeeDetails;

@Repository
public interface EmployeeDetailsRepo extends CrudRepository<EmployeeDetails, Integer> {
	
	@Query(" from  EmployeeDetails where employeeRegister.slno=:uid")
	public EmployeeDetails getByemploeeid(Integer uid);

	@Query("select count(*) from com.employee.model.EmployeeDetails where employeeRegister.slno=:uid" )
    public Integer total(Integer uid);
	
	@Query("from EmployeeDetails where employeerole Like %:employeerole% OR employeedepartment Like %:employeerole%")
	public List<EmployeeDetails> findByTitle(String employeerole);

}
