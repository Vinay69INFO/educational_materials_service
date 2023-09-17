package com.educational.material.vo.auth;

import java.io.Serializable;
import java.time.LocalDateTime;

public class InstructorVO implements Serializable{
	
	private static final long serialVersionUID = 0;
	
	private Long instructorId;
	private String emailAddress;
	private String instructorFullName;
	private String mobileNumber;
	private String gender;
	
	private String nationality;
	
	private String dorrmant_flag;
	private String instructorPageKey;
	
	private String instructorDepartment;
	private String passwordEncrypted;
	private String instructorRole;
	
	private LocalDateTime createdTimestamp;
	private LocalDateTime lastUdatedTimestamp;
	
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
	public String getInstructorFullName() {
		return instructorFullName;
	}
	public void setInstructorFullName(String instructorFullName) {
		this.instructorFullName = instructorFullName;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public String getDorrmant_flag() {
		return dorrmant_flag;
	}
	public void setDorrmant_flag(String dorrmant_flag) {
		this.dorrmant_flag = dorrmant_flag;
	}
	public String getInstructorPageKey() {
		return instructorPageKey;
	}
	public void setInstructorPageKey(String instructorPageKey) {
		this.instructorPageKey = instructorPageKey;
	}
	public String getInstructorDepartment() {
		return instructorDepartment;
	}
	public void setInstructorDepartment(String instructorDepartment) {
		this.instructorDepartment = instructorDepartment;
	}
	public String getPasswordEncrypted() {
		return passwordEncrypted;
	}
	public void setPasswordEncrypted(String passwordEncrypted) {
		this.passwordEncrypted = passwordEncrypted;
	}
	public String getInstructorRole() {
		return instructorRole;
	}
	public void setInstructorRole(String instructorRole) {
		this.instructorRole = instructorRole;
	}
	public LocalDateTime getCreatedTimestamp() {
		return createdTimestamp;
	}
	public void setCreatedTimestamp(LocalDateTime createdTimestamp) {
		this.createdTimestamp = createdTimestamp;
	}
	public LocalDateTime getLastUdatedTimestamp() {
		return lastUdatedTimestamp;
	}
	public void setLastUdatedTimestamp(LocalDateTime lastUdatedTimestamp) {
		this.lastUdatedTimestamp = lastUdatedTimestamp;
	}
	@Override
	public String toString() {
		return "InstructorVO [instructorId=" + instructorId + ", emailAddress=" + emailAddress + ", instructorFullName="
				+ instructorFullName + ", mobileNumber=" + mobileNumber + ", gender=" + gender + ", nationality="
				+ nationality + ", dorrmant_flag=" + dorrmant_flag + ", instructorPageKey=" + instructorPageKey
				+ ", instructorDepartment=" + instructorDepartment + ", passwordEncrypted=" + passwordEncrypted
				+ ", instructorRole=" + instructorRole + ", createdTimestamp=" + createdTimestamp
				+ ", lastUdatedTimestamp=" + lastUdatedTimestamp + "]";
	}
		
}
