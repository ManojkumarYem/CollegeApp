package com.college.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.college.model.StudentApplication;
import com.college.service.CollegeServices;

@CrossOrigin // for save from crossError
@RestController
public class CollegeController {
	public CollegeController() {
		System.out.println("Controller Object Created");
	}

	@Autowired
	CollegeServices service;

//	Application Form add in Database:

	@PostMapping("/saveApplicationID")
	public String saveStudents(StudentApplication stu) {

		try {
			service.saveInDB(stu);
		} catch (Exception e) {
			e.getMessage();
		}
		return "Success";
	}

//	view Application Records from Database:

	@GetMapping("/viewStudentRecords")
	public List<StudentApplication> viewStudentRecords() {
		List<StudentApplication> studentDetails = null;
		try {
			studentDetails = service.getAllStudents();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return studentDetails;

	}

	/************************ Fetching Student Details Function ************************/
	
	@GetMapping("/ApplicationForm")
	public StudentApplication getStudentByRegisterId(@RequestParam ("registerId") String id) {
		StudentApplication studentDetails = service.getStudentById(id);
		return studentDetails;

	}

	@GetMapping("/getLastStudentRegisterId")
	public String getLastStudentRegId() {

		String lastRegId = service.getLastStudentRegId();

		return lastRegId;
	}

	
	
	
	// get specific column:
	@GetMapping("/getAllRegisterId")
	public List<String> getAllRegisterId() {
		List<String> allList = null;
		allList = service.getAllRegistertId();
		return allList;

	}

}





















//@GetMapping("/getLastStudentRegisterId")
//public  List<StudentApplication> getLastStudentRegisterId() {
//	
//	 List<StudentApplication>lastRegId = service.getLastRegisterId();
//
//	return lastRegId;
//}
//