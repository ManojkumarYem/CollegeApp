package com.auth.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin // for save from crossError
@RestController
public class PageController {

	@GetMapping("/AdmissionFormPage")
	public String AdmissionAddFormPage() {
		System.out.println("Page");
		return "Success";

	}
	
	@GetMapping("/screens/admissionForm.html")
	public String AdmissionAddFormPageGo() {
		System.out.println("Page2");
		return "Success";

	}
	
}
