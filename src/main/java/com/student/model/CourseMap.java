package com.student.model;

import com.student.domain.CourseMasterDetail;
import com.student.domain.StudentDetail;

public class CourseMap {
	private Long id;
	private StudentDetail studentId;
	private CourseMasterDetail courseId;
	
	public CourseMap() {
		
	}
	
	public CourseMap(Long id, StudentDetail studentId, CourseMasterDetail courseId) {
		super();
		this.id = id;
		this.studentId = studentId;
		this.courseId = courseId;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public StudentDetail getStudentId() {
		return studentId;
	}
	public void setStudentId(StudentDetail studentId) {
		this.studentId = studentId;
	}
	public CourseMasterDetail getCourseId() {
		return courseId;
	}
	public void setCourseId(CourseMasterDetail courseId) {
		this.courseId = courseId;
	}
	
	@Override
	public String toString() {
		return "CourseMap [id=" + id + ", studentId=" + studentId + ", courseId=" + courseId + "]";
	}
	
	
	
	
}
