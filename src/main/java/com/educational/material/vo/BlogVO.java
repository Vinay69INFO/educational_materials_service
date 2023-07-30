package com.educational.material.vo;

import java.time.LocalDateTime;

public class BlogVO {
	private Long blogId;
	private String blogTitle;
	private String blogBody;
	private String blogPageKey;
	private String blogStatus;
	private Long navId;
	private String navName;
	private Long topicId;
	private String topicName;
	private Long subTopicId;
	private String subTopicName;
	private Long createdBy;
	private LocalDateTime createdTimeStamp;
	private Long lastUpdatedBy;
	private LocalDateTime lastUpdatedTimeStamp;
	
	public BlogVO() {
		super();
	}	
	
	public BlogVO(Long blogId, String blogTitle, String blogBody, String blogPageKey, String blogStatus, Long createdBy,
			LocalDateTime createdTimeStamp, Long lastUpdatedBy, LocalDateTime lastUpdatedTimeStamp) {
		super();
		this.blogId = blogId;
		this.blogTitle = blogTitle;
		this.blogBody = blogBody;
		this.blogPageKey = blogPageKey;
		this.blogStatus = blogStatus;
		this.createdBy = createdBy;
		this.createdTimeStamp = createdTimeStamp;
		this.lastUpdatedBy = lastUpdatedBy;
		this.lastUpdatedTimeStamp = lastUpdatedTimeStamp;
	}
	
	

	public BlogVO(Long blogId, String blogTitle, String blogBody, String blogPageKey, String blogStatus, Long navId,
			String navName, Long topicId, String topicName, Long subTopicId, String subTopicName, Long lastUpdatedBy,
			LocalDateTime lastUpdatedTimeStamp) {
		super();
		this.blogId = blogId;
		this.blogTitle = blogTitle;
		this.blogBody = blogBody;
		this.blogPageKey = blogPageKey;
		this.blogStatus = blogStatus;
		this.navId = navId;
		this.navName = navName;
		this.topicId = topicId;
		this.topicName = topicName;
		this.subTopicId = subTopicId;
		this.subTopicName = subTopicName;
		this.lastUpdatedBy = lastUpdatedBy;
		this.lastUpdatedTimeStamp = lastUpdatedTimeStamp;
	}

	public Long getBlogId() {
		return blogId;
	}

	public String getBlogTitle() {
		return blogTitle;
	}

	public String getBlogBody() {
		return blogBody;
	}

	public String getBlogPageKey() {
		return blogPageKey;
	}

	public String getBlogStatus() {
		return blogStatus;
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

	public void setBlogId(Long blogId) {
		this.blogId = blogId;
	}

	public void setBlogTitle(String blogTitle) {
		this.blogTitle = blogTitle;
	}

	public void setBlogBody(String blogBody) {
		this.blogBody = blogBody;
	}

	public void setBlogPageKey(String blogPageKey) {
		this.blogPageKey = blogPageKey;
	}

	public void setBlogStatus(String blogStatus) {
		this.blogStatus = blogStatus;
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

	public Long getTopicId() {
		return topicId;
	}

	public Long getSubTopicId() {
		return subTopicId;
	}

	public void setTopicId(Long topicId) {
		this.topicId = topicId;
	}

	public void setSubTopicId(Long subTopicId) {
		this.subTopicId = subTopicId;
	}

	public Long getNavId() {
		return navId;
	}

	public String getNavName() {
		return navName;
	}

	public String getTopicName() {
		return topicName;
	}

	public String getSubTopicName() {
		return subTopicName;
	}

	public void setNavId(Long navId) {
		this.navId = navId;
	}

	public void setNavName(String navName) {
		this.navName = navName;
	}

	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}

	public void setSubTopicName(String subTopicName) {
		this.subTopicName = subTopicName;
	}

	@Override
	public String toString() {
		return "BlogVO [blogId=" + blogId + ", blogTitle=" + blogTitle + ", blogBody=" + blogBody + ", blogPageKey="
				+ blogPageKey + ", blogStatus=" + blogStatus + ", navId=" + navId + ", navName=" + navName
				+ ", topicId=" + topicId + ", topicName=" + topicName + ", subTopicId=" + subTopicId + ", subTopicName="
				+ subTopicName + ", createdBy=" + createdBy + ", createdTimeStamp=" + createdTimeStamp
				+ ", lastUpdatedBy=" + lastUpdatedBy + ", lastUpdatedTimeStamp=" + lastUpdatedTimeStamp + "]";
	}
	
}
