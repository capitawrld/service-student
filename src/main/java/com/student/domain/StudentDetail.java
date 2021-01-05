package com.student.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="student")
public class StudentDetail {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="sid")
	private Long sid;
	
	@Column(name="sname")
	private String sname;
	
	@Column(name="saddress")
	private String saddress;
	
	@Column(name="semail")
	private String semail;
	
	@Column(name="is_active")
	private boolean is_active;
	
	@Column(name="gender")
	private String gender;
	
	@Column(name="selectedValue")
	private Integer selectedValue;
	
	public StudentDetail()
	{
	}
	
	public StudentDetail(Long sid)
	{
		this.sid=sid;
	}
	
	
	public StudentDetail(Long sid, String sname, String saddress, String semail,boolean is_active,String gender,Integer selectedValue) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.saddress = saddress;
		this.semail = semail;
		this.is_active= is_active;
		this.gender=gender;
	}
	
	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public boolean isIs_active() {
		return is_active;
	}


	public void setIs_active(boolean is_active) {
		this.is_active = is_active;
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

	@Override
	public String toString() {
		return "StudentDetail [sid=" + sid + ", sname=" + sname + ", saddress=" + saddress + ", semail=" + semail
				+ ", is_active=" + is_active + ", gender=" + gender + "]";
	}

	
			
}
