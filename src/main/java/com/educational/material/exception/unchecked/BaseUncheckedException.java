package com.educational.material.exception.unchecked;

public class BaseUncheckedException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	private String type;
    private String stage;
    private String message;
    private String userMessage;
    private String payload;
    private Integer code;
    
	public BaseUncheckedException(Integer code, String type, String stage, String message, String userMessage, String payload) {
		super(message);
		this.type = type;
		this.stage = stage;
		this.message = message;
		this.userMessage = userMessage;
		this.payload = payload;
		this.code = code;
	}
	
	public String getType() {
		return type;
	}
	public String getStage() {
		return stage;
	}
	public String getMessage() {
		return message;
	}
	public String getUserMessage() {
		return userMessage;
	}
	public String getPayload() {
		return payload;
	}
	public Integer getCode() {
		return code;
	}
	public void setType(String type) {
		this.type = type;
	}
	public void setStage(String stage) {
		this.stage = stage;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public void setUserMessage(String userMessage) {
		this.userMessage = userMessage;
	}
	public void setPayload(String payload) {
		this.payload = payload;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
}
