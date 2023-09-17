package com.educational.material.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="sellers")
public class SellerEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "seller_id", unique = true, nullable = false)
	private Long sellerId;
	private String mobile_number;
	private String email_address;
	private String first_name;
	private String date_of_birth;
	private String gender;
	private String address;
	private String city_id;
	private String state_id;
	private String country_id;
	private String zip_code;
	private String dormant_flag;
	private LocalDateTime mobile_verified_timestamp;
	private LocalDateTime email_verified_timestamp;
	private String media_file;
	private String password_encrypted;
	private String hide_phone_email;
	private String email_last_active;
	private String created_by;
	private String created_timestamp;
	private Integer last_updated_by;
	private LocalDateTime last_updated_timestamp;
	
	
	
	public Long getSellerId() {
		return sellerId;
	}
	public void setSellerId(Long sellerId) {
		this.sellerId = sellerId;
	}
	public String getMobile_number() {
		return mobile_number;
	}
	public String getEmail_address() {
		return email_address;
	}
	public String getFirst_name() {
		return first_name;
	}
	public String getDate_of_birth() {
		return date_of_birth;
	}
	public String getGender() {
		return gender;
	}
	public String getAddress() {
		return address;
	}
	public String getCity_id() {
		return city_id;
	}
	public String getState_id() {
		return state_id;
	}
	public String getCountry_id() {
		return country_id;
	}
	public String getZip_code() {
		return zip_code;
	}
	public String getDormant_flag() {
		return dormant_flag;
	}
	public LocalDateTime getMobile_verified_timestamp() {
		return mobile_verified_timestamp;
	}
	public LocalDateTime getEmail_verified_timestamp() {
		return email_verified_timestamp;
	}
	public String getMedia_file() {
		return media_file;
	}
	public String getPassword_encrypted() {
		return password_encrypted;
	}
	public String getHide_phone_email() {
		return hide_phone_email;
	}
	public String getEmail_last_active() {
		return email_last_active;
	}
	public String getCreated_by() {
		return created_by;
	}
	public String getCreated_timestamp() {
		return created_timestamp;
	}
	public Integer getLast_updated_by() {
		return last_updated_by;
	}
	public LocalDateTime getLast_updated_timestamp() {
		return last_updated_timestamp;
	}
	
	public void setMobile_number(String mobile_number) {
		this.mobile_number = mobile_number;
	}
	public void setEmail_address(String email_address) {
		this.email_address = email_address;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public void setDate_of_birth(String date_of_birth) {
		this.date_of_birth = date_of_birth;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setCity_id(String city_id) {
		this.city_id = city_id;
	}
	public void setState_id(String state_id) {
		this.state_id = state_id;
	}
	public void setCountry_id(String country_id) {
		this.country_id = country_id;
	}
	public void setZip_code(String zip_code) {
		this.zip_code = zip_code;
	}
	public void setDormant_flag(String dormant_flag) {
		this.dormant_flag = dormant_flag;
	}
	public void setMobile_verified_timestamp(LocalDateTime mobile_verified_timestamp) {
		this.mobile_verified_timestamp = mobile_verified_timestamp;
	}
	public void setEmail_verified_timestamp(LocalDateTime email_verified_timestamp) {
		this.email_verified_timestamp = email_verified_timestamp;
	}
	public void setMedia_file(String media_file) {
		this.media_file = media_file;
	}
	public void setPassword_encrypted(String password_encrypted) {
		this.password_encrypted = password_encrypted;
	}
	public void setHide_phone_email(String hide_phone_email) {
		this.hide_phone_email = hide_phone_email;
	}
	public void setEmail_last_active(String email_last_active) {
		this.email_last_active = email_last_active;
	}
	public void setCreated_by(String created_by) {
		this.created_by = created_by;
	}
	public void setCreated_timestamp(String created_timestamp) {
		this.created_timestamp = created_timestamp;
	}
	public void setLast_updated_by(Integer last_updated_by) {
		this.last_updated_by = last_updated_by;
	}
	public void setLast_updated_timestamp(LocalDateTime last_updated_timestamp) {
		this.last_updated_timestamp = last_updated_timestamp;
	}
	@Override
	public String toString() {
		return "SellerEntity [sellerId=" + sellerId + ", mobile_number=" + mobile_number + ", email_address="
				+ email_address + ", first_name=" + first_name + ", date_of_birth=" + date_of_birth + ", gender="
				+ gender + ", address=" + address + ", city_id=" + city_id + ", state_id=" + state_id + ", country_id="
				+ country_id + ", zip_code=" + zip_code + ", dormant_flag=" + dormant_flag
				+ ", mobile_verified_timestamp=" + mobile_verified_timestamp + ", email_verified_timestamp="
				+ email_verified_timestamp + ", media_file=" + media_file + ", password_encrypted=" + password_encrypted
				+ ", hide_phone_email=" + hide_phone_email + ", email_last_active=" + email_last_active
				+ ", created_by=" + created_by + ", created_timestamp=" + created_timestamp + ", last_updated_by="
				+ last_updated_by + ", last_updated_timestamp=" + last_updated_timestamp + "]";
	}	
	
	
}
