package com.student.service;

import java.util.List;

import com.student.model.CourseMaster;
import com.student.model.Student;

public interface StudentDetailService {
	
	public boolean add(Student student,List<Integer> course);
	
	public boolean edit(Student student,List<Integer> course);
	
	public Student getStudent(Long sid);
	
	public void delete(Long sid);
	
	public List<Student> getAllStudent();
	
	public List<CourseMaster> getAllCourses();
}
