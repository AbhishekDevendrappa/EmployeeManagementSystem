package com.employee.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.employee.model.EmployeeRegister;
import com.employee.model.ManagerDetails;
import com.employee.service.EmployeeRegisterService;
import com.employee.service.ManagerDetailsService;

import jakarta.servlet.http.HttpSession;

 

@Controller
public class LoginAndRegisterController {
	
	@Autowired
	EmployeeRegisterService registerService;
	
	@Autowired
	HttpSession httpsession;
	
	
	@Autowired
	ManagerDetailsService managerDetailsService ;
	
	@GetMapping
	public String home()
	{
		return "Home";
	}
	
	@GetMapping("register")
	public String showregister()
	{
		return "EmployeeRegister";
	}
	
	@GetMapping("alogin")
	public String show_admin_login()
	{
		return "Adminlogin";
	}
	
	@GetMapping("elogin")
	public String show_user_login()
	{
		return "Employeelogin";
	}
	
	@GetMapping("mlogin")
	public String show_recuiter_login() {
		return "Managerlogin";
	}
	
	@GetMapping("forpass")
	public String Forgotpassword() {
		return "Fpassword";
	}
	
	@GetMapping("gohome")
	public String  gohome() {
		return "Home";
	}
	
	
	@GetMapping("managerregister")
	public String recuiterregister() {
		return "Managerregister";
	}
	
	@PostMapping("adminlogin")
	public String Admin_Login(ModelMap model, @RequestParam String Adminname, @RequestParam String Password) {
		if(Adminname.equals("admin") && Password.equals("123"))
		{		
				return "AdminMain";
		}else{
			model.put("errorMsg", "Invalid username or password");
			return "Adminlogin";
		}
	}
	
	@PostMapping("add")
	public String register_user(@ModelAttribute("e") EmployeeRegister e,ModelMap model) {
		registerService.saveUser(e);
			model.put("registerMsg", "Employee registered successfully");
		return "Employeelogin";
	}
	
	@PostMapping("addmanager")
	public String register_recuiter(@ModelAttribute("r") ManagerDetails m,ModelMap model) {
		System.out.println(m);
		managerDetailsService.saveRecuiter(m);
			model.put("registerMsg", "Manager registered successfully");
		return "Managerlogin";
	}
	
	@PostMapping("login")
	public String Mainpage(ModelMap model, @RequestParam String email, @RequestParam String password,HttpSession s) {
		System.out.println(email+" "+password);
		EmployeeRegister employee = registerService.getEmployee(email, password);
		
		if(employee==null) {	
			model.put("errorMsg", "Invalid username or password");
			return "Employeelogin";
		}else{
			String a = employee.getUsername();
			model.put("um", a);
			s.setAttribute("id", employee);
				return "Employee";
		}
	}
	
	@PostMapping("recuiterlogin")
	public String Recuiter_Mainpage(ModelMap model, @RequestParam String email, @RequestParam String password,HttpSession s) {
		System.out.println(email+" "+password);
		ManagerDetails manager = managerDetailsService.getrecuiter(email, password);
		System.out.println(manager+" r");
		if(manager!=null) {		
			String a = manager.getName();
			model.put("um", a);
			s.setAttribute("id", manager);
				return "ManagerMain";
		}else{
			model.put("errorMsg", "Invalid username or password");
			return "Managerlogin";
		}
	}
	
//	@PostMapping("change")
//	public ModelAndView changePass(PasswordReset password) {
//	System.out.println("change"+password.getUsername());
//	EmployeeRegister details=userservice.findByname(password.getUsername());
//	ModelAndView  mv=new ModelAndView();
//	if(details!=null) {
//	details.setPassword(password.getNewpassword());
//	userservice.saveUser(details);
//	mv.addObject("msg","Password Updated Successfully");
//	mv.setViewName("home");
//	return mv;
//	}
//	else {
//	mv.addObject("msg","User Not Found");
//	mv.setViewName("Fpassword");
//	return mv;
//	}
//	}
	


}
