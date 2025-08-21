package com.educational.material.vo;

import java.time.LocalDateTime;
import java.util.List;

public class TopicVO {
	
	private Long topicId;
	private long navId;
	private String topicTitle;
	private String topicNavigationUrl;
	private String topicStatus;
	private String subTopicStatus;
	private String blogPageKey;
	private Long createdBy;
	private LocalDateTime createdTimeStamp;
	private Long lastUpdatedBy;
	private LocalDateTime lastUpdatedTimeStamp;
	
	private List<SubTopicVO> subTopicVOs;

	public TopicVO() {
		super();
	}

	public TopicVO(Long topicId, String topicTitle, String topicNavigationUrl, String topicStatus, String subTopicStatus, String blogPageKey,
			Long createdBy, LocalDateTime createdTimeStamp, Long lastUpdatedBy, LocalDateTime lastUpdatedTimeStamp	) {
		super();
		this.topicId = topicId;
		this.topicTitle = topicTitle;
		this.topicNavigationUrl = topicNavigationUrl;
		this.topicStatus = topicStatus;
		this.subTopicStatus = subTopicStatus;
		this.blogPageKey = blogPageKey;
		this.createdBy = createdBy;
		this.createdTimeStamp = createdTimeStamp;
		this.lastUpdatedBy = lastUpdatedBy;
		this.lastUpdatedTimeStamp = lastUpdatedTimeStamp;
	
	}

	public Long getTopicId() {
		return topicId;
	}	

	public long getNavId() {
		return navId;
	}

	public void setNavId(long navId) {
		this.navId = navId;
	}

	public String getTopicTitle() {
		return topicTitle;
	}

	public String getTopicNavigationUrl() {
		return topicNavigationUrl;
	}

	public String getTopicStatus() {
		return topicStatus;
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

	public List<SubTopicVO> getSubTopicVOs() {
		return subTopicVOs;
	}

	public void setTopicId(Long topicId) {
		this.topicId = topicId;
	}

	public void setTopicTitle(String topicTitle) {
		this.topicTitle = topicTitle;
	}

	public void setTopicNavigationUrl(String topicNavigationUrl) {
		this.topicNavigationUrl = topicNavigationUrl;
	}

	public void setTopicStatus(String topicStatus) {
		this.topicStatus = topicStatus;
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

	public void setSubTopicVOs(List<SubTopicVO> subTopicVOs) {
		this.subTopicVOs = subTopicVOs;
	}

	public String getSubTopicStatus() {
		return subTopicStatus;
	}

	public void setSubTopicStatus(String subTopicStatus) {
		this.subTopicStatus = subTopicStatus;
	}

	@Override
	public String toString() {
		return "TopicVO [topicId=" + topicId + ", navId=" + navId + ", topicTitle=" + topicTitle
				+ ", topicNavigationUrl=" + topicNavigationUrl + ", topicStatus=" + topicStatus + ", blogPageKey="
				+ blogPageKey + ", createdBy=" + createdBy + ", createdTimeStamp=" + createdTimeStamp
				+ ", lastUpdatedBy=" + lastUpdatedBy + ", lastUpdatedTimeStamp=" + lastUpdatedTimeStamp
				+ ", subTopicVOs=" + subTopicVOs + "]";
	}

	
	
}
