package com.employee.controler;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.employee.model.EmployeeDetails;
import com.employee.model.EmployeeRegister;
import com.employee.repo.EmployeeDetailsRepo;
import com.employee.service.EmployeeDetailsService;
import com.employee.service.EmployeeRegisterService;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import jakarta.servlet.http.HttpSession;

@Controller
public class EmployeeController {

	@Autowired
	EmployeeRegisterService registerService;

	@Autowired
	EmployeeDetailsService detailsService;

	@Autowired
	HttpSession httpsession;

	@Autowired
	EmployeeDetailsRepo detailsRepo;

	@SuppressWarnings("unused")
	@GetMapping("fill1")
	public String fillDetails(HttpSession s, ModelMap m) {
		EmployeeRegister e = (EmployeeRegister) s.getAttribute("id");
		Integer id = e.getSlno();
		Integer count = detailsRepo.total(id);
		if (e == null) {
			return "errorpage";
		}
		if (count != 0) {
			m.put("msg", "Form already filled");
			return "Employee";
		}
		return "EmployeeMain";

	}

	@PostMapping("fill2")
	public String fillDetails2(@ModelAttribute("m") EmployeeDetails r, HttpSession s, Model m) {

		EmployeeRegister id = (EmployeeRegister) s.getAttribute("id");
		EmployeeRegister u = registerService.getEmployeeById(id.getSlno());
		r.setEmployeeRegister(u);
		detailsService.saveEmployee(r);
		return "Employee";
	}

	@SuppressWarnings("unused")
	@GetMapping("/view")
	public String viewDetails(Model model, HttpSession s) {
		EmployeeRegister id = (EmployeeRegister) s.getAttribute("id");
		Integer i = id.getSlno();
		System.out.println(id + "  ........id " + i + " ....slno");
		if (id == null) {
			return "errorpage";
		} else {
			EmployeeDetails r2 = detailsService.getbyId(id.getSlno());
			System.out.println(r2 + " .............r2");
			model.addAttribute("model", r2);
			return "EmployeeView";
		}

	}

	@GetMapping("update")
	public ModelAndView update(@RequestParam("no") Integer slno) {
		System.out.println("slno " + slno);
		Optional<EmployeeDetails> EmployeeDetails = detailsService.getbyIdd(slno);
		EmployeeDetails details = EmployeeDetails.get();
		ModelAndView mv = new ModelAndView();
		mv.addObject("r", details);
		mv.setViewName("EmployeeUpdate");
		return mv;
	}

	@PostMapping("updatepage")
	public ModelAndView main(EmployeeDetails details) {
		detailsService.update(details);
		ModelAndView mv = new ModelAndView();
		mv.addObject("msg", details.getEmployeename() + " updated successfully");
		EmployeeRegister id = (EmployeeRegister) httpsession.getAttribute("id");
		EmployeeDetails r2 = detailsService.getbyId(id.getSlno());
		mv.addObject("model", r2);
		mv.setViewName("EmployeeView");
		return mv;
	}

	@GetMapping("/delete")
	public String deleteuserdetails(@RequestParam Integer no, ModelMap model) {
		System.out.println(no);
		if (no == null) {
			System.out.println("nono");
			model.put("del", "there is nothing to delete");
			return "EmployeeView";
		} else {
			detailsService.Deleteuser(no);
			return "Employee";
		}
	}

	@GetMapping("loglout")
	public String logout(HttpSession s) {
		s.invalidate();
		return "Home";
	}

	@GetMapping("back")
	public String uback() {
		return "Employee";
	}

	@GetMapping("download")
	public ResponseEntity<InputStreamResource> downloadData(@RequestParam Integer no)
			throws IOException, DocumentException {
		Optional<EmployeeDetails> EmployeeDetails = detailsService.getbyIdd(no);
		EmployeeDetails details = EmployeeDetails.get();

		Document document = new Document();
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		PdfWriter.getInstance(document, out);
		document.open();

		document.add(new Paragraph(details.toString()));

		document.close();

		ByteArrayInputStream in = new ByteArrayInputStream(out.toByteArray());
		InputStreamResource resource = new InputStreamResource(in);

		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", "inline; filename=EmployeeDetails.pdf");

		return ResponseEntity
				.ok()
				.headers(headers)
				.contentType(MediaType.APPLICATION_PDF)
				.body(resource);
	}

}