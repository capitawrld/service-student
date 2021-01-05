package com.student.model;

import java.util.List;

public class FullData {
	
	private Student student;
	private List<Integer> course;
	
	public FullData() {}
	public FullData(Student student, List<Integer> course) {
		super();
		this.student = student;
		this.course = course;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public List<Integer> getCourse() {
		return course;
	}

	public void setCourse(List<Integer> course) {
		this.course = course;
	}

	@Override
	public String toString() {
		return "FullData [student=" + student + ", course=" + course + "]";
	}
	
	
}
