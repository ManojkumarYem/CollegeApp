package com.college.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.college.dao.DAOServices;
@CrossOrigin
@RestController
public class DashBoardController {
	
	@Autowired
	DAOServices daoService;

	public DashBoardController() {
		System.out.println("DashBoardController");
	}
	
	@GetMapping("/totalNoOfStudents")
	public String totalNoOfStudents() {
		String totalStudents=daoService.totalNoOfStudents();
		
		
		return  totalStudents;
	}
	
	@GetMapping("/totalNoOfAdmissions")
	public String totalNoOfAdmissions() {
		
		String totalAdmission=daoService.totalActiveStudents();
		return totalAdmission;
		
	}
	@GetMapping("/noOfStudentsDiscontinued")
	public String noOfStudentsDiscontinued() {
		String totalDiscontinued=daoService.inActiveStudents();
		return totalDiscontinued;
		
	}

}
