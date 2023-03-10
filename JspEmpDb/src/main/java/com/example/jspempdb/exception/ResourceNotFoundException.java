package com.example.jspempdb.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String resourcename;
	private String fieldName;
	private Object fieldValue;
	public ResourceNotFoundException(String resourcename, String fieldName, Object fieldValue) {
		super(resourcename+" not found with the value "+fieldName+" :"+fieldValue);
		this.resourcename = resourcename; //employee
		this.fieldName = fieldName;  //id
		this.fieldValue = fieldValue; //2
	}
	public String getResourcename() {
		return resourcename;
	}
	public void setResourcename(String resourcename) {
		this.resourcename = resourcename;
	}
	public String getFieldName() {
		return fieldName;
	}
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	public Object getFieldValue() {
		return fieldValue;
	}
	public void setFieldValue(Object fieldValue) {
		this.fieldValue = fieldValue;
	}
	

}
