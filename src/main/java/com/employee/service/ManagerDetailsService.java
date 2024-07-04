package com.employee.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.model.ManagerDetails;
import com.employee.repo.ManagerDetailsrRepo;


@Service
public class ManagerDetailsService {
	
	@Autowired
	ManagerDetailsrRepo recuiterrepo;

	public void saveRecuiter(ManagerDetails r) {
		recuiterrepo.save(r);
	}

	public ManagerDetails getrecuiter(String email, String password) {
		System.out.println(recuiterrepo.getManager(email,password)+" in service");
		return recuiterrepo.getManager(email,password);
	}

	public ManagerDetails getRecruiterById(Integer slno) {
		Optional<ManagerDetails> r = recuiterrepo.findById(slno);
		if(r.isPresent()) {
			return r.get();
		}
		return null;
	}

}
