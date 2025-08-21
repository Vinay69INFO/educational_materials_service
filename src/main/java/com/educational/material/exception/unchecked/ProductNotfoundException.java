package com.educational.material.exception.unchecked;

import com.educational.material.utils.AppCodes;

public class ProductNotfoundException extends BaseUncheckedException {
	   private static final long serialVersionUID = 1L;
	   
	    public ProductNotfoundException(String stage, String message, String userMessage) {
	        super(AppCodes.APP_CODE_LOGOUT, "Error with propertity file", stage, message, userMessage, null);  
	    }
}
