package com.student.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.student.model.CommonRes;
import com.student.model.FullData;
import com.student.model.Student;
import com.student.service.StudentDetailService;

@RestController()
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/v1")
public class StudentController {

	@Autowired
	private StudentDetailService studentDetailService;

	private static final Logger logger = LoggerFactory.getLogger(StudentController.class);

	/*
	 * Getting all data
	 * 
	 * @return List of Student Objects
	 */
//	@GetMapping(value="/all")
	@RequestMapping(value = "/all", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	public @ResponseBody ResponseEntity<CommonRes> showStudents() {
		try {
			List<Student> student = studentDetailService.getAllStudent();
			if (student.size() == 0) {
				return new ResponseEntity<CommonRes>(
						new CommonRes(HttpStatus.OK.value(), "No data found !!", Boolean.FALSE), HttpStatus.OK);
			} else {
				return new ResponseEntity<CommonRes>(
						new CommonRes(HttpStatus.OK.value(), "Successfully get data!!!", Boolean.TRUE, student),
						HttpStatus.OK);
			}
		} catch (Exception e) {
			logger.error("Exception while Get All List of Students ======>", e);
			return new ResponseEntity<CommonRes>(
					new CommonRes(HttpStatus.INTERNAL_SERVER_ERROR.value(),
							"The application has encounteredsome error, please try after some time", Boolean.FALSE),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/*
	 * Getting all data By studentId
	 * 
	 * @return Student Object
	 */

	// @GetMapping(value="/getOne")
	@RequestMapping(value = "/getOne", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	public @ResponseBody ResponseEntity<CommonRes> getStudent(@RequestParam("sid") Long sid) {
		try {
			Student student = studentDetailService.getStudent(sid);
			if (student == null) {
				return new ResponseEntity<CommonRes>(
						new CommonRes(HttpStatus.OK.value(), "No data found!!!", Boolean.FALSE), HttpStatus.OK);
			} else {
				return new ResponseEntity<CommonRes>(
						new CommonRes(HttpStatus.OK.value(), "Successfully get data!!!", Boolean.TRUE, student),
						HttpStatus.OK);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	/*
	 * Add Student
	 * 
	 * @return List of Student Objects with last added student
	 */

	// @PostMapping(value="/add",consumes = MediaType.APPLICATION_JSON_VALUE,
	// produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "/add", method = RequestMethod.POST, consumes = {
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
	public @ResponseBody ResponseEntity<CommonRes> addStudent(@RequestBody FullData fd) {
		try {
			if (fd != null) {
				boolean result = studentDetailService.add(fd.getStudent(), fd.getCourse());
				if (result) {
					return new ResponseEntity<CommonRes>(new CommonRes(HttpStatus.OK.value(), "Successfully get data!!",
							Boolean.TRUE), HttpStatus.OK);
				}
				return new ResponseEntity<CommonRes>(
						new CommonRes(HttpStatus.OK.value(), "Data Not Saved Properly !!", Boolean.FALSE),
						HttpStatus.OK);
			} else {
				return new ResponseEntity<CommonRes>(
						new CommonRes(HttpStatus.OK.value(), "Data not getting properly!!!!", Boolean.FALSE),
						HttpStatus.OK);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<CommonRes>(
					new CommonRes(HttpStatus.INTERNAL_SERVER_ERROR.value(),
							"The application has encountered some error, please try after some time", Boolean.FALSE),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/*
	 * Update Student By taking Student Object
	 * 
	 * @return List of Student Objects with updated student object
	 */

	@PostMapping(value = "/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "/update", method = RequestMethod.POST, consumes = {
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
	public @ResponseBody ResponseEntity<CommonRes> updateStudent(@RequestBody FullData fd) {
		try {
			if (fd != null) {
				boolean result = studentDetailService.edit(fd.getStudent(), fd.getCourse());
				if (result) {
					return new ResponseEntity<CommonRes>(new CommonRes(HttpStatus.OK.value(), "Successfully get data!!",
							Boolean.TRUE), HttpStatus.OK);
				}
				return new ResponseEntity<CommonRes>(new CommonRes(HttpStatus.OK.value(),
						"Data Not Updated Properly !!", Boolean.FALSE, studentDetailService.getAllStudent()),
						HttpStatus.OK);
			}
			return new ResponseEntity<CommonRes>(new CommonRes(HttpStatus.OK.value(), "Data not getting properly!!",
					Boolean.FALSE, studentDetailService.getAllStudent()), HttpStatus.OK);
		} catch (Exception e) {
			logger.error("Exception while Save Data =========>", e);
			return new ResponseEntity<CommonRes>(
					new CommonRes(HttpStatus.INTERNAL_SERVER_ERROR.value(),
							"The application has encountered some error, please try after some time", Boolean.FALSE),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/*
	 * Delete Student By taking StudentId
	 * 
	 * @return List Of Student objects without deleted student
	 */
	// @GetMapping(value="/delete")
	@RequestMapping(value = "/delete", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	public @ResponseBody ResponseEntity<CommonRes> deleteStudent(@RequestParam("sid") Long sid) {
		try {
			if (sid != null) {
				studentDetailService.delete(sid);
				return new ResponseEntity<CommonRes>(new CommonRes(HttpStatus.OK.value(), "Successfully delete data!!",
						Boolean.TRUE, studentDetailService.getAllStudent()), HttpStatus.OK);
			} else {
				return new ResponseEntity<CommonRes>(new CommonRes(HttpStatus.OK.value(), "Id is maybe null !!",
						Boolean.FALSE), HttpStatus.OK);
			}
		} catch (Exception e) {
			logger.error("Exception while Get List =========>", e);
			return new ResponseEntity<CommonRes>(
					new CommonRes(HttpStatus.INTERNAL_SERVER_ERROR.value(),
							"The application has encountered some error, please try after some time", Boolean.FALSE),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
