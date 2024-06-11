package com.ltts.exception;

import java.time.LocalDateTime;

public class ErrorModel {
	
	int errorCode;
	String Description;
	LocalDateTime errordate;
	String RequestedURI;
	
	public int getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public LocalDateTime getErrordate() {
		return errordate;
	}
	public void setErrordate(LocalDateTime errordate) {
		this.errordate = errordate;
	}
	public String getRequestedURI() {
		return RequestedURI;
	}
	public void setRequestedURI(String requestedURI) {
		RequestedURI = requestedURI;
	}
	
	public ErrorModel(int errorCode, String description, LocalDateTime errordate, String requestedURI) {
		super();
		this.errorCode = errorCode;
		Description = description;
		this.errordate = errordate;
		RequestedURI = requestedURI;
	}
	public ErrorModel() {
		super();
	}
	
	@Override
	public String toString() {
		return "ErrorModel [errorCode=" + errorCode + ", Description=" + Description + ", errordate=" + errordate
				+ ", RequestedURI=" + RequestedURI + "]";
	}
}
