package com.educational.material.exception.unchecked;

public class InvalidAuthTokenException extends BaseUncheckedException {
	
	private static final long serialVersionUID = -3064708809197663067L;

	public InvalidAuthTokenException(Integer code, String type, String stage, String message, String userMessage,
			String payload) {
		super(code, type, stage, message, userMessage, payload);
	}

}
