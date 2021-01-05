package com.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.student.domain.CourseMasterDetail;

public interface CourseMasterDetailRepository extends JpaRepository<CourseMasterDetail, Integer>{

}
