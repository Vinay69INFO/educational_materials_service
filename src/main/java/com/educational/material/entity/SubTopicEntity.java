package com.educational.material.entity;

import java.time.LocalDateTime;

import jakarta.persistence.CascadeType;
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
@Table(name = "sub_topics")
public class SubTopicEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "subtopic_id", unique = true, nullable = false)
	private Long subTopicId;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "topic_id")
	private TopicEntity topicEntity;
	
	@Column(name = "subtopic_title", nullable = false)
	private String subTopicTitle;
	
	@Column(name = "subtopic_navigation_url", nullable = false)
	private String subTopicNavigationUrl;
	
	@Column(name = "subtopic_status", nullable = false)
	private String subtopictatus;
	
	@Column(name = "blog_pagekey", nullable = true)
	private String blogPageKey;
	
	@Column(name= "created_by", nullable = false)
	private Long createdBy;
	
	@Column(name= "created_timestamp", nullable = false)
	private LocalDateTime createdTimeStamp;

	@Column(name= "last_updated_by", nullable = true)
	private Long lastUpdatedBy;

	@Column(name= "last_updated_timestamp", nullable = true)
	private LocalDateTime lastUpdatedTimeStamp;

	public Long getSubTopicId() {
		return subTopicId;
	}

	public TopicEntity getTopicEntity() {
		return topicEntity;
	}

	public String getSubTopicTitle() {
		return subTopicTitle;
	}

	public String getSubTopicNavigationUrl() {
		return subTopicNavigationUrl;
	}

	public String getSubtopictatus() {
		return subtopictatus;
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

	public void setSubTopicId(Long subTopicId) {
		this.subTopicId = subTopicId;
	}

	public void setTopicEntity(TopicEntity topicEntity) {
		this.topicEntity = topicEntity;
	}

	public void setSubTopicTitle(String subTopicTitle) {
		this.subTopicTitle = subTopicTitle;
	}

	public void setSubTopicNavigationUrl(String subTopicNavigationUrl) {
		this.subTopicNavigationUrl = subTopicNavigationUrl;
	}

	public void setSubtopictatus(String subtopictatus) {
		this.subtopictatus = subtopictatus;
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
		return "SubTopicEntity [subTopicId=" + subTopicId + ", topicEntity=" + topicEntity + ", subTopicTitle="
				+ subTopicTitle + ", subTopicNavigationUrl=" + subTopicNavigationUrl + ", subtopictatus="
				+ subtopictatus + ", blogPageKey=" + blogPageKey + ", createdBy=" + createdBy + ", createdTimeStamp="
				+ createdTimeStamp + ", lastUpdatedBy=" + lastUpdatedBy + ", lastUpdatedTimeStamp="
				+ lastUpdatedTimeStamp + "]";
	}

}
