package com.educational.material.vo;

import java.time.LocalDateTime;

public class NavigationVO {
	
	private Long navId;
	private String navTitle;
	private String navUrl;
	private String navStatus;
	private Long createdBy;
	private LocalDateTime createdTimeStamp;
	private Long lastUpdatedBy;
	private LocalDateTime lastUpdatedTimeStamp;
	
	public NavigationVO() {
		super();
	}

	public NavigationVO(Long navId, String navTitle, String navUrl, String navStatus, Long createdBy,
			LocalDateTime createdTimeStamp, Long lastUpdatedBy, LocalDateTime lastUpdatedTimeStamp) {
		super();
		this.navId = navId;
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
		return "NavigationVO [navId=" + navId + ", navTitle=" + navTitle + ", navUrl=" + navUrl + ", navStatus="
				+ navStatus + ", createdBy=" + createdBy + ", createdTimeStamp=" + createdTimeStamp + ", lastUpdatedBy="
				+ lastUpdatedBy + ", lastUpdatedTimeStamp=" + lastUpdatedTimeStamp + "]";
	}
	
}
