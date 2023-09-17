package com.educational.material.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.educational.material.entity.pk.InstructorSessionPK;

@Entity
@Table(name = "instructor_session")
public class InstructorSessionEntity implements Serializable{

	private static final long serialVersionUID = 0; 
	
	
	private InstructorSessionPK instructorSessionPK;
	private InstructorEntity instructorEntity;
	
	@Column(name = "session_token")
	private String sessionToken;
	
	private String status;
	
	@Column(name = "login_timestamp")
	private LocalDateTime loginTimestamp;
	@Column(name = "login_classfication")
	private String loginClassification;
	@Column(name = "logout_or_invalidation_timestamp")
	private LocalDateTime logoutOrInvalidationDateTime;
	
	@EmbeddedId
	@AttributeOverrides({
		@AttributeOverride(name = "instructorId", column = @Column(name = "instructor_id", nullable = false)),
		@AttributeOverride(name = "deviceId", column = @Column(name = "device_id", nullable = false, length = 128))
	})
	public InstructorSessionPK getInstructorSessionPK() {
		return instructorSessionPK;
	}
	public void setInstructorSessionPK(InstructorSessionPK instructorSessionPK) {
		this.instructorSessionPK = instructorSessionPK;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "instructor_id", nullable = false, insertable = false, updatable = false)
	public InstructorEntity getInstructorEntity() {
		return instructorEntity;
	}
	public void setInstructorEntity(InstructorEntity instructorEntity) {
		this.instructorEntity = instructorEntity;
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
	public LocalDateTime getLoginTimestamp() {
		return loginTimestamp;
	}
	public void setLoginTimestamp(LocalDateTime loginTimestamp) {
		this.loginTimestamp = loginTimestamp;
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
		return "InstructorSessionEntity [instructorSessionPK=" + instructorSessionPK + ", instructorEntity="
				+ instructorEntity + ", sessionToken=" + sessionToken + ", status=" + status + ", loginTimestamp="
				+ loginTimestamp + ", loginClassification=" + loginClassification + ", logoutOrInvalidationDateTime="
				+ logoutOrInvalidationDateTime + "]";
	}
	
}
