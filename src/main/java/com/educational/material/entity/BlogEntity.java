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
@Table(name = "blogs")
public class BlogEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "blog_id", unique = true, nullable = false)
	private Long blogId;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "nav_id", nullable = true, insertable = true, updatable = true)
	private NavigationEntity navigationEntity;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "topic_id", nullable = true, insertable = true, updatable = true)
	private TopicEntity topicEntity;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "subtopic_id", nullable = true, insertable = true, updatable = true)
	private SubTopicEntity subTopicEntity;
	
	@Column(name = "blog_title", nullable = false)
	private String blogTitle;
	
	@Column(name = "blog_pagekey", nullable = true)
	private String blogPageKey;
	
	@Column(name = "blog_body", nullable = false)
	private String blogBody;
	
	@Column(name = "blog_status", nullable = false)
	private String blogStatus;
	
	@Column(name= "created_by", nullable = false)
	private Long createdBy;
	
	@Column(name= "created_timestamp", nullable = false)
	private LocalDateTime createdTimeStamp;

	@Column(name= "last_updated_by", nullable = true)
	private Long lastUpdatedBy;

	@Column(name= "last_updated_timestamp", nullable = true)
	private LocalDateTime lastUpdatedTimeStamp;
	

	public Long getBlogId() {
		return blogId;
	}

	public TopicEntity getTopicEntity() {
		return topicEntity;
	}

	public SubTopicEntity getSubTopicEntity() {
		return subTopicEntity;
	}

	public String getBlogTitle() {
		return blogTitle;
	}

	public String getBlogPageKey() {
		return blogPageKey;
	}

	public String getBlogBody() {
		return blogBody;
	}

	public String getBlogStatus() {
		return blogStatus;
	}

	public long getCreatedBy() {
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

	public void setTopicEntity(TopicEntity topicEntity) {
		this.topicEntity = topicEntity;
	}

	public void setSubTopicEntity(SubTopicEntity subTopicEntity) {
		this.subTopicEntity = subTopicEntity;
	}

	public void setBlogTitle(String blogTitle) {
		this.blogTitle = blogTitle;
	}

	public void setBlogPageKey(String blogPageKey) {
		this.blogPageKey = blogPageKey;
	}

	public void setBlogBody(String blogBody) {
		this.blogBody = blogBody;
	}

	public void setBlogStatus(String blogStatus) {
		this.blogStatus = blogStatus;
	}

	public void setCreatedBy(long createdBy) {
		this.createdBy = createdBy;
	}

	public void setCreatedTimeStamp(LocalDateTime createdTimeStamp) {
		this.createdTimeStamp = createdTimeStamp;
	}

	public void setLastUpdatedBy(long lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}

	public void setLastUpdatedTimeStamp(LocalDateTime lastUpdatedTimeStamp) {
		this.lastUpdatedTimeStamp = lastUpdatedTimeStamp;
	}

	public NavigationEntity getNavigationEntity() {
		return navigationEntity;
	}

	public void setNavigationEntity(NavigationEntity navigationEntity) {
		this.navigationEntity = navigationEntity;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	public void setLastUpdatedBy(Long lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}

	@Override
	public String toString() {
		return "BlogEntity [blogId=" + blogId + ", topicEntity=" + topicEntity + ", subTopicEntity=" + subTopicEntity
				+ ", blogTitle=" + blogTitle + ", blogPageKey=" + blogPageKey + ", blogBody=" + blogBody
				+ ", blogStatus=" + blogStatus + ", createdBy=" + createdBy + ", createdTimeStamp=" + createdTimeStamp
				+ ", lastUpdatedBy=" + lastUpdatedBy + ", lastUpdatedTimeStamp=" + lastUpdatedTimeStamp + "]";
	}

}
