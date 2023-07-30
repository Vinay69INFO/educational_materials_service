package com.educational.material.entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "topics")
public class TopicEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "topic_id", unique = true, nullable = false)
	private Long topicId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "seller_id", nullable = true, insertable = true, updatable = true)
	private SellerEntity sellerEntity;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "nav_id", nullable = true, insertable = true, updatable = true)
	private NavigationEntity navigationEntity;
	
	//@OneToMany(fetch=FetchType.LAZY, mappedBy="subTopicEntity")
	//@JoinColumn(name = "subtopic_id", nullable = false, insertable = true, updatable = true)
	//private List<SubTopicEntity> subTopicEntity;
	
	@Column(name = "topic_title", nullable = false)
	private String topicTitle;
	
	@Column(name = "topic_navigation_url", nullable = false)
	private String topicNavigationUrl;
	
	@Column(name = "topic_status", nullable = false)
	private String topicStatus;
	
	@Column(name = "subtopic_status", nullable = false)
	private String addSubTopicStatus;
	
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

	public TopicEntity() {
		super();
	}

	public TopicEntity(Long topicId, SellerEntity sellerEntity, NavigationEntity navigationEntity, String topicTitle,
			String topicNavigationUrl, String topicStatus, String addSubTopicStatus, String blogPageKey, Long createdBy,
			LocalDateTime createdTimeStamp, Long lastUpdatedBy, LocalDateTime lastUpdatedTimeStamp) {
		super();
		this.topicId = topicId;
		this.sellerEntity = sellerEntity;
		this.navigationEntity = navigationEntity;
		this.topicTitle = topicTitle;
		this.topicNavigationUrl = topicNavigationUrl;
		this.topicStatus = topicStatus;
		this.addSubTopicStatus = addSubTopicStatus;
		this.blogPageKey = blogPageKey;
		this.createdBy = createdBy;
		this.createdTimeStamp = createdTimeStamp;
		this.lastUpdatedBy = lastUpdatedBy;
		this.lastUpdatedTimeStamp = lastUpdatedTimeStamp;
	}

	
	
	public String getAddSubTopicStatus() {
		return addSubTopicStatus;
	}

	public void setAddSubTopicStatus(String addSubTopicStatus) {
		this.addSubTopicStatus = addSubTopicStatus;
	}

	public Long getTopicId() {
		return topicId;
	}

	public SellerEntity getSellerEntity() {
		return sellerEntity;
	}

	public NavigationEntity getNavigationEntity() {
		return navigationEntity;
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

	public void setTopicId(Long topicId) {
		this.topicId = topicId;
	}

	public void setSellerEntity(SellerEntity sellerEntity) {
		this.sellerEntity = sellerEntity;
	}

	public void setNavigationEntity(NavigationEntity navigationEntity) {
		this.navigationEntity = navigationEntity;
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

	@Override
	public String toString() {
		return "TopicEntity [topicId=" + topicId + ", sellerEntity=" + sellerEntity + ", navigationEntity="
				+ navigationEntity + ", topicTitle=" + topicTitle + ", topicNavigationUrl=" + topicNavigationUrl
				+ ", topicStatus=" + topicStatus + ", blogPageKey=" + blogPageKey + ", createdBy=" + createdBy
				+ ", createdTimeStamp=" + createdTimeStamp + ", lastUpdatedBy=" + lastUpdatedBy
				+ ", lastUpdatedTimeStamp=" + lastUpdatedTimeStamp + "]";
	}
	
}
