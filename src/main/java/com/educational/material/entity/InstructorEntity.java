package com.educational.material.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "instructors")
public class InstructorEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "instructor_id", unique = true, nullable = false)
	private Long instructorId;
	
	@Column(name = "email_address")
	private String emailAddress;
	@Column(name = "full_name")
	private String instructorFullName;
	@Column(name = "mobile_number")
	private String mobileNumber;
	private String gender;
	
	private String nationality;
	
	@Column(name = "dormant_flag")
	private String dorrmantFlag;
	@Column(name = "page_key")
	private String instructorPageKey;
	@Column(name = "instructor_department")
	private String instructorDepartment;
	@Column(name = "password_encrypted")
	private String passwordEncrypted;
	@Column(name = "instructor_role")
	private String instructorRole;
	@Column(name = "created_timestamp")
	private LocalDateTime createdTimestamp;
	@Column(name = "last_updated_timestamp")
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
	public String getDorrmantFlag() {
		return dorrmantFlag;
	}
	public void setDorrmantFlag(String dorrmantFlag) {
		this.dorrmantFlag = dorrmantFlag;
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
		return "InstructorEntity [instructorId=" + instructorId + ", emailAddress=" + emailAddress
				+ ", instructorFullName=" + instructorFullName + ", mobileNumber=" + mobileNumber + ", gender=" + gender
				+ ", nationality=" + nationality + ", dorrmantFlag=" + dorrmantFlag + ", instructorPageKey="
				+ instructorPageKey + ", instructorDepartment=" + instructorDepartment + ", passwordEncrypted="
				+ passwordEncrypted + ", instructorRole=" + instructorRole + ", createdTimestamp=" + createdTimestamp
				+ ", lastUdatedTimestamp=" + lastUdatedTimestamp + "]";
	}
	
}
