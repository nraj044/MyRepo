package com.example.demo.Exceptions;

import java.util.Date;

public class ExceptionDetails {
	
	private Date timeStamp;
	private String msg;
	private String details;
	public Date getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public ExceptionDetails(Date timeStamp, String msg, String details) {
		super();
		this.timeStamp = timeStamp;
		this.msg = msg;
		this.details = details;
	}
	
	public ExceptionDetails() {
		
	}

}
