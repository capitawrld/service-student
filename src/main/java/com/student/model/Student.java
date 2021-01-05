package com.student.model;

import java.util.List;

public class Student {

	private Long sid;
	private String sname;
	private String saddress;
	private String semail;
	private boolean is_active;
	private String gender;
	private List<CourseMaster> courseMaster;
	
	public Student()
	{
	}
	
	public Student(Long sid, String sname, String saddress, String semail, boolean is_active, String gender,
			List<CourseMaster> courseMaster) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.saddress = saddress;
		this.semail = semail;
		this.is_active = is_active;
		this.gender = gender;
		this.courseMaster = courseMaster;
	}

	public Long getSid() {
		return sid;
	}

	public void setSid(Long sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getSaddress() {
		return saddress;
	}

	public void setSaddress(String saddress) {
		this.saddress = saddress;
	}

	public String getSemail() {
		return semail;
	}

	public void setSemail(String semail) {
		this.semail = semail;
	}

	public boolean isIs_active() {
		return is_active;
	}

	public void setIs_active(boolean is_active) {
		this.is_active = is_active;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public List<CourseMaster> getCourseMaster() {
		return courseMaster;
	}

	public void setCourseMaster(List<CourseMaster> courseMaster) {
		this.courseMaster = courseMaster;
	}

	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", saddress=" + saddress + ", semail=" + semail
				+ ", is_active=" + is_active + ", gender=" + gender + ", courseMaster=" + courseMaster + "]";
	}
		
}
