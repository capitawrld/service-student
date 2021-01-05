package com.student.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "student_course_mapping")
public class CourseMapDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "student_id")
	private StudentDetail studentId;

	@ManyToOne
	@JoinColumn(name = "course_id")
	private CourseMasterDetail courseId;

	public CourseMapDetail() {}	
	
	public CourseMapDetail(Long id, StudentDetail studentId, CourseMasterDetail courseId) {
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

}
