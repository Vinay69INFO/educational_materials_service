package com.educational.material.vo.auth;

import java.time.LocalDateTime;

public class InstructorSessionVO {
	private long loginId;
	private String deviceId;
	private String sessionToken;
	private String status;
	
	private LocalDateTime loginDateTime;
	private String loginClassification;
	private LocalDateTime logoutOrInvalidationDateTime;
	
	public long getLoginId() {
		return loginId;
	}
	public void setLoginId(long loginId) {
		this.loginId = loginId;
	}
	public String getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
	public String getSessionToken() {
		return sessionToken;
	}
	public void setSessionToken(String sessionToken) {
		this.sessionToken = sessionToken;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public LocalDateTime getLoginDateTime() {
		return loginDateTime;
	}
	public void setLoginDateTime(LocalDateTime loginDateTime) {
		this.loginDateTime = loginDateTime;
	}
	public String getLoginClassification() {
		return loginClassification;
	}
	public void setLoginClassification(String loginClassification) {
		this.loginClassification = loginClassification;
	}
	public LocalDateTime getLogoutOrInvalidationDateTime() {
		return logoutOrInvalidationDateTime;
	}
	public void setLogoutOrInvalidationDateTime(LocalDateTime logoutOrInvalidationDateTime) {
		this.logoutOrInvalidationDateTime = logoutOrInvalidationDateTime;
	}
	
	@Override
	public String toString() {
		return "instructor_session [loginId=" + loginId + ", deviceId=" + deviceId + ", sessionToken=" + sessionToken
				+ ", status=" + status + ", loginDateTime=" + loginDateTime + ", loginClassification="
				+ loginClassification + ", logoutOrInvalidationDateTime=" + logoutOrInvalidationDateTime + "]";
	}
	
}
