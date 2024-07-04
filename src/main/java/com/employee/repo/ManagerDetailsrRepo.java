package com.employee.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.employee.model.ManagerDetails;


public interface ManagerDetailsrRepo extends CrudRepository<ManagerDetails, Integer> {

	@Query("from ManagerDetails where email=:email and password=:password")
	public ManagerDetails getManager(String email, String password);

}
