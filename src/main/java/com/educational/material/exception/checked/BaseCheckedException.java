package com.educational.material.exception.checked;

public class BaseCheckedException extends Exception{

	private static final long serialVersionUID = -3465929663447893616L;

	private Integer code;
	
	BaseCheckedException(String message) {
		super(message);
	}
	
	BaseCheckedException(Integer code, String message) {
		super(message);
		this.code = code;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

}
