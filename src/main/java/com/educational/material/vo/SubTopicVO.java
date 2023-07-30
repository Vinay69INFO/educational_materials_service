package com.educational.material.vo;

import java.time.LocalDateTime;
import java.util.Date;

import org.hibernate.annotations.ColumnDefault;

import com.educational.material.entity.TopicEntity;

import jakarta.persistence.Column;

public class SubTopicVO {
	private Long subTopicID;
	private Long topicId;
	private String subTopicTitle;
	private String subTopicNavigationUrl;
	private String subtopicStatus;
	private String blogPageKey;
	private Long createdBy;
	private LocalDateTime createdTimeStamp;
	private Long lastUpdatedBy;
	private LocalDateTime lastUpdatedTimeStamp;
	
	public SubTopicVO() {
		super();
	}

	public SubTopicVO(Long subTopicID, Long topicId, String subTopicTitle, String subTopicNavigationUrl, String subtopicStatus,
			String blogPageKey, Long createdBy, LocalDateTime createdTimeStamp, Long lastUpdatedBy,
			LocalDateTime lastUpdatedTimeStamp) {
		super();
		this.subTopicID = subTopicID;
		this.topicId = topicId;
		this.subTopicTitle = subTopicTitle;
		this.subTopicNavigationUrl = subTopicNavigationUrl;
		this.subtopicStatus = subtopicStatus;
		this.blogPageKey = blogPageKey;
		this.createdBy = createdBy;
		this.createdTimeStamp = createdTimeStamp;
		this.lastUpdatedBy = lastUpdatedBy;
		this.lastUpdatedTimeStamp = lastUpdatedTimeStamp;
	}
	
	public Long getSubTopicID() {
		return subTopicID;
	}

	public Long getTopicId() {
		return topicId;
	}

	public void setTopicId(Long topicId) {
		this.topicId = topicId;
	}

	public String getSubTopicTitle() {
		return subTopicTitle;
	}

	public String getSubTopicNavigationUrl() {
		return subTopicNavigationUrl;
	}

	public String getSubtopicStatus() {
		return subtopicStatus;
	}

	public String getBlogPageKey() {
		return blogPageKey;
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

	public void setSubTopicID(Long subTopicID) {
		this.subTopicID = subTopicID;
	}

	public void setSubTopicTitle(String subTopicTitle) {
		this.subTopicTitle = subTopicTitle;
	}

	public void setSubTopicNavigationUrl(String subTopicNavigationUrl) {
		this.subTopicNavigationUrl = subTopicNavigationUrl;
	}

	public void setSubtopicStatus(String subtopicStatus) {
		this.subtopicStatus = subtopicStatus;
	}

	public void setBlogPageKey(String blogPageKey) {
		this.blogPageKey = blogPageKey;
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
		return "SubTopicVO [subTopicID=" + subTopicID + ", topicId=" + topicId + ", subTopicTitle=" + subTopicTitle
				+ ", subTopicNavigationUrl=" + subTopicNavigationUrl + ", subtopicStatus=" + subtopicStatus
				+ ", blogPageKey=" + blogPageKey + ", createdBy=" + createdBy + ", createdTimeStamp=" + createdTimeStamp
				+ ", lastUpdatedBy=" + lastUpdatedBy + ", lastUpdatedTimeStamp=" + lastUpdatedTimeStamp + "]";
	}

	
	
}
