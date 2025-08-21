package com.educational.material.vo.auth;

import java.io.Serializable;

public class LoggedInUserVO implements Serializable{
	
	private static final long serialVersionUID = -7253249856744431250L;
	
	private Long instructorId;
	private String emailAddress;
	private String instructorPageKey;
	private String instructorFullName;
	private String loggedInToken;
    private Long authenticationPartnerId;

	
	public Long getInstructorId() {
		return instructorId;
	}
	public void setInstructorId(Long instructorId) {
		this.instructorId = instructorId;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getInstructorPageKey() {
		return instructorPageKey;
	}
	public void setInstructorPageKey(String instructorPageKey) {
		this.instructorPageKey = instructorPageKey;
	}
	public String getInstructorFullName() {
		return instructorFullName;
	}
	public void setInstructorFullName(String instructorFullName) {
		this.instructorFullName = instructorFullName;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getLoggedInToken() {
		return loggedInToken;
	}
	public void setLoggedInToken(String loggedInToken) {
		this.loggedInToken = loggedInToken;
	}
	public Long getAuthenticationPartnerId() {
		return authenticationPartnerId;
	}
	public void setAuthenticationPartnerId(Long authenticationPartnerId) {
		this.authenticationPartnerId = authenticationPartnerId;
	}
	
	@Override
	public String toString() {
		return "LoggedInUserVO [instructorId=" + instructorId + ", emailAddress=" + emailAddress
				+ ", instructorPageKey=" + instructorPageKey + ", instructorFullName=" + instructorFullName
				+ ", loggedInToken=" + loggedInToken + ", authenticationPartnerId=" + authenticationPartnerId + "]";
	}
	
}
