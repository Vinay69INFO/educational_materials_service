package com.educational.material.utils;

import org.springframework.stereotype.Component;

@Component
public class DataParser {
	public String getTrimmedStringValue(String obj) { 
		return getTrimmedStringValue(obj, Constants.EMPTY_STRING);
	}
	
	public String getTrimmedStringValue(String obj, String defaultStr) {
		String objString = defaultStr;
		if(obj != null) {
			objString = obj.trim();
		}
		return objString;
	}
}
