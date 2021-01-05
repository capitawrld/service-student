package com.student.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.student.domain.CourseMapDetail;
import com.student.domain.CourseMasterDetail;
import com.student.domain.StudentDetail;
import com.student.model.CourseMaster;
import com.student.model.Student;
import com.student.repository.CourseMapDetailRepository;
import com.student.repository.CourseMasterDetailRepository;
import com.student.repository.StudentDetailRepository;
import com.student.service.StudentDetailService;

@Service
@Transactional
public class StudentDetailServiceImpl implements StudentDetailService {

	@Autowired
	private StudentDetailRepository sturepo;

	@Autowired
	private CourseMasterDetailRepository repo;

	@Autowired
	private CourseMapDetailRepository cmaprepo;

	private static final Logger logger = LoggerFactory.getLogger(StudentDetailServiceImpl.class);

	@Override
	public boolean add(Student student, List<Integer> courseIds) {
		try {
			if (student != null) {
				StudentDetail studetail = new StudentDetail();
				BeanUtils.copyProperties(student, studetail);
				studetail = sturepo.save(studetail);
				for (Integer course : courseIds) {
					CourseMapDetail cmap = new CourseMapDetail();
					cmap.setCourseId(new CourseMasterDetail(course));
					cmap.setStudentId(studetail);
					cmaprepo.save(cmap);
				}
			}
			return Boolean.TRUE;
		} catch (Exception e) {
			logger.error("Exception while Add Data ================", e);
			return Boolean.FALSE;
		}
	}

	@Override
	public boolean edit(Student student, List<Integer> course) {
		try {
			if (student != null) {
				StudentDetail studetail = sturepo.getOne(student.getSid());
				BeanUtils.copyProperties(student, studetail);
				studetail = sturepo.save(studetail);
				List<CourseMapDetail> cd = cmaprepo.findAllByStudentId(studetail);
				if (!cd.isEmpty()) {
					cmaprepo.deleteByStudentId(studetail);
				}
				for (Integer courseIds : course) {
					CourseMapDetail cmap = new CourseMapDetail();
					cmap.setCourseId(new CourseMasterDetail(courseIds));
					cmap.setStudentId(studetail);
					cmaprepo.save(cmap);
				}
			}
			return Boolean.TRUE;
		} catch (Exception e) {
			logger.error("Exception while Update Data ================", e);
			return Boolean.FALSE;
		}

	}

	@Override
	public Student getStudent(Long sid) {
		try {
			if (sid != null) {
				StudentDetail studetail1 = sturepo.getOne(sid);
				Student student = new Student();
				BeanUtils.copyProperties(studetail1, student);
				List<CourseMapDetail> cMapDetail = cmaprepo.findAllByStudentId(studetail1);
				if (cMapDetail != null) {
					List<CourseMaster> courseMaster = new ArrayList<CourseMaster>(cMapDetail.size());
					for (CourseMapDetail cmap : cMapDetail) {
						CourseMaster cm = new CourseMaster();
						cm.setId(cmap.getCourseId().getId());
						cm.setName(cmap.getCourseId().getName());
						courseMaster.add(cm);
					}
					student.setCourseMaster(courseMaster);
				}
				return student;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void delete(Long sid) {
		try {
			if (sid != null) {
				Student student = this.getStudent(sid);
				student.setIs_active(false);
				StudentDetail studetail = new StudentDetail();
				BeanUtils.copyProperties(student, studetail);
				sturepo.save(studetail);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<Student> getAllStudent() {
		try {
			List<StudentDetail> sd = sturepo.findAll();
			if (sd.size() == 0) {
				return Collections.emptyList();
			}
			List<Student> stu = new ArrayList<Student>(sd.size());
			for (StudentDetail sd1 : sd) {
				Student student = new Student();
				BeanUtils.copyProperties(sd1, student);
				List<CourseMapDetail> cMapDetail = cmaprepo.findAllByStudentId(sd1);
				List<CourseMaster> courseMaster = new ArrayList<CourseMaster>(cMapDetail.size());
				for (CourseMapDetail cmap : cMapDetail) {
					CourseMaster cm = new CourseMaster();
					cm.setId(cmap.getCourseId().getId());
					cm.setName(cmap.getCourseId().getName());
					courseMaster.add(cm);
				}
				student.setCourseMaster(courseMaster);
				stu.add(student);
			}
			return stu;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<CourseMaster> getAllCourses() {
		try {
			List<CourseMasterDetail> course = repo.findAll();
			if (course.size() == 0) {
				return Collections.emptyList();
			}
			List<CourseMaster> cor = new ArrayList<CourseMaster>(course.size());
			for (CourseMasterDetail c1 : course) {
				CourseMaster course1 = new CourseMaster();
				BeanUtils.copyProperties(c1, course1);
				cor.add(course1);
			}
			return cor;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
