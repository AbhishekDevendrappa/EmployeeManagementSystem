package com.employee.controler;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.employee.model.EmployeeDetails;
import com.employee.service.EmployeeDetailsService;



@Controller
public class ManagerController {
	
	@Autowired
	EmployeeDetailsService detailsService; 
	
	@GetMapping("search")
	public String search1(@RequestParam String employeerole,Model m) {
		System.out.println(employeerole+" .....emploeerole");
		List<EmployeeDetails> employee = detailsService.getByTitle(employeerole);
	
		System.out.println(employee+"  ........employee");
		m.addAttribute("Employee", employee);
		return "ManagerMain";
	}

}
