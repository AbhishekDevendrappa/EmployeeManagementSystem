package com.employee.controler;


import com.employee.model.EmployeeDetails;
import com.employee.model.ManagerDetails;
import com.employee.repo.EmployeeDetailsRepo;
import com.employee.repo.ManagerDetailsrRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminController {

    @Autowired
    ManagerDetailsrRepo detailsrRepo;

    @Autowired
    EmployeeDetailsRepo detailsRepo;


    @GetMapping("getallemp")
    public String GetAllEmployee(ModelMap m) {
        Iterable<EmployeeDetails> e =  detailsRepo.findAll();
        m.put("emsg", e);
        return "AdminMain";
    }

    @GetMapping("getallman")
    public String GetAllManager(ModelMap m) {
        Iterable<ManagerDetails> man =  detailsrRepo.findAll();
        m.put("manmsg", man);
        return "AdminMain";
    }

    @GetMapping("logout")
    public String Logout(){
        return "Home";
    }

	
}
