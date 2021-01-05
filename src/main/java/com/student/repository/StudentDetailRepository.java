package com.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.student.domain.StudentDetail;

public interface StudentDetailRepository extends JpaRepository<StudentDetail, Long>{
	
}