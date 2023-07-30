package com.educational.material.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "navigation_links")
public class NavigationEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "nav_id", unique = true, nullable = false)
	private Long navId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "seller_id", nullable = false, insertable = true, updatable = true)
	private SellerEntity sellerEntity;
	
	@Column(name= "nav_title", nullable = false)
	private String navTitle;
	
	@Column(name= "nav_url", nullable = false)
	private String navUrl;
	
	@Column(name= "nav_status", nullable = false)
	private String navStatus;
	
	@Column(name= "created_by", nullable = false)
	private Long createdBy;
	
	@Column(name= "created_timestamp", nullable = false)
	private LocalDateTime createdTimeStamp;

	@Column(name= "last_updated_by", nullable = true)
	private Long lastUpdatedBy;

	@Column(name= "last_updated_timestamp", nullable = true)
	private LocalDateTime lastUpdatedTimeStamp;	
	
	public NavigationEntity() {
		super();
	}

	public NavigationEntity(Long navId, SellerEntity sellerEntity, String navTitle, String navUrl, String navStatus,
			Long createdBy, LocalDateTime createdTimeStamp, Long lastUpdatedBy,
			LocalDateTime lastUpdatedTimeStamp) {
		super();
		this.navId = navId;
		this.sellerEntity = sellerEntity;
		this.navTitle = navTitle;
		this.navUrl = navUrl;
		this.navStatus = navStatus;
		this.createdBy = createdBy;
		this.createdTimeStamp = createdTimeStamp;
		this.lastUpdatedBy = lastUpdatedBy;
		this.lastUpdatedTimeStamp = lastUpdatedTimeStamp;
	}



	public Long getNavId() {
		return navId;
	}
	
	public SellerEntity getSellerEntity() {
		return sellerEntity;
	}

	public String getNavTitle() {
		return navTitle;
	}

	public String getNavUrl() {
		return navUrl;
	}

	public String getNavStatus() {
		return navStatus;
	}

	public Long getCreatedBy() {
		return createdBy;
	}

	public LocalDateTime getCreatedTimeStamp() {
		return createdTimeStamp;
	}

	public Long getLastUpdatedBy() {
		return lastUpdatedBy;
	}

	public LocalDateTime getLastUpdatedTimeStamp() {
		return lastUpdatedTimeStamp;
	}

	public void setNavId(Long navId) {
		this.navId = navId;
	}

	public void setSellerEntity(SellerEntity sellerEntity) {
		this.sellerEntity = sellerEntity;
	}

	public void setNavTitle(String navTitle) {
		this.navTitle = navTitle;
	}

	public void setNavUrl(String navUrl) {
		this.navUrl = navUrl;
	}

	public void setNavStatus(String navStatus) {
		this.navStatus = navStatus;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	public void setCreatedTimeStamp(LocalDateTime createdTimeStamp) {
		this.createdTimeStamp = createdTimeStamp;
	}

	public void setLastUpdatedBy(Long lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}

	public void setLastUpdatedTimeStamp(LocalDateTime lastUpdatedTimeStamp) {
		this.lastUpdatedTimeStamp = lastUpdatedTimeStamp;
	}

	@Override
	public String toString() {
		return "NavigationEntity [navId=" + navId + ", sellerEntity=" + sellerEntity + ", navTitle=" + navTitle
				+ ", navUrl=" + navUrl + ", navStatus=" + navStatus + ", createdBy=" + createdBy + ", createdTimeStamp="
				+ createdTimeStamp + ", lastUpdatedBy=" + lastUpdatedBy + ", lastUpdatedTimeStamp="
				+ lastUpdatedTimeStamp + "]";
	}

	
	
	
}
