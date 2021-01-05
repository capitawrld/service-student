package com.student.model;

public class CommonRes {

	private Integer status;

	private String message;

	private Boolean flag;

	private Object data;

	public CommonRes() {
		super();
	}

	public CommonRes(Integer status, String message) {
		super();
		this.status = status;
		this.message = message;
	}

	public CommonRes(Integer status, String message, Boolean flag) {
		super();
		this.status = status;
		this.message = message;
		this.flag = flag;
	}
	
	public CommonRes(Integer status, String message, Boolean flag, Object data) {
		super();
		this.status = status;
		this.message = message;
		this.flag = flag;
		this.data = data;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Boolean getFlag() {
		return flag;
	}

	public void setFlag(Boolean flag) {
		this.flag = flag;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}
