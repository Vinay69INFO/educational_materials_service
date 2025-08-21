package com.educational.material.vo.auth;

import java.io.Serializable;

public class RegisterVO implements Serializable{
	
	private static final long serialVersionUID = 5919334304651132480L;
	
	private String emailAddress;
	private String instructorFullName;
	private String passwordEncrypted;
	
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getInstructorFullName() {
		return instructorFullName;
	}
	public void setInstructorFullName(String instructorFullName) {
		this.instructorFullName = instructorFullName;
	}
	public String getPasswordEncrypted() {
		return passwordEncrypted;
	}
	public void setPasswordEncrypted(String passwordEncrypted) {
		this.passwordEncrypted = passwordEncrypted;
	}
	
	
	
}
