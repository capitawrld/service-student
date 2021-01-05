package com.student.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.student.domain.CourseMapDetail;
import com.student.domain.StudentDetail;

@Repository
public interface CourseMapDetailRepository extends JpaRepository<CourseMapDetail, Long>{

//	@Modifying
//	@Query("delete from coursemap where student_id=:sid")
//	void deleteByStudentId(@Param("sid")Long sid);
	public int deleteByStudentId(StudentDetail student);

	List<CourseMapDetail> findAllByStudentId(StudentDetail student);

}
