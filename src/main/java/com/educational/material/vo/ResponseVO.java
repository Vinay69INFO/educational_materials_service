package com.educational.material.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.educational.material.utils.AppCodes;

@Component
public class ResponseVO implements Serializable{
	
	private static final long serialVersionUID = -7066500305551066304L;
	
	private Object payload;
    private int appStatusCode = AppCodes.APP_CODE_SUCESS;
	private List<String> message = new ArrayList<>();
	private Object error;
	
	private String mes;
	
	
	public String getMes() {
		return mes;
	}
	public void setMes(String mes) {
		this.mes = mes;
	}
	public Object getPayload() {
		return payload;
	}
	public int getAppStatusCode() {
		return appStatusCode;
	}
	public List<String> getMessage() {
		return message;
	}
	public Object getError() {
		return error;
	}
	public void setPayload(Object payload) {
		this.payload = payload;
	}
	public void setAppStatusCode(int appStatusCode) {
		this.appStatusCode = appStatusCode;
	}
	public void setMessage(List<String> message) {
		this.message = message;
	}
	public void setError(Object error) {
		this.error = error;
	}
	
	
}
