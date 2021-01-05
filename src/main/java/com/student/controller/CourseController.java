package com.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student.model.CourseMaster;
//import com.student.model.CourseMap;
import com.student.service.StudentDetailService;

@RestController()
@RequestMapping("/v2")

public class CourseController {
	
	@Autowired
	StudentDetailService studentDetailService;
	
	@GetMapping(value="/allCourse")
	public List<CourseMaster> getAll(){
			
		return studentDetailService.getAllCourses();		
	}
	
//	@GetMapping(value="/getAllChecked")
//	public List<CourseMap>getAllChecked(){
//		return null;
//	}
}
