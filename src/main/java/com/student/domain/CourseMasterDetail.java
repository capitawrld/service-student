package com.student.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="course_master")
public class CourseMasterDetail {
	
	@Id
	@Column(name="id")
	private Integer id;
	
	@Column(name="name")
	private String name;
	
	public CourseMasterDetail() {
		
	}
	
	public CourseMasterDetail(Integer id) {
		this.id = id;
	}
	
	public CourseMasterDetail(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + "]";
	}
}
