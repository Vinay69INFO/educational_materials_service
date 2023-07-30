package com.educational.material.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.educational.material.entity.BlogEntity;
import com.educational.material.entity.TopicEntity;
import com.educational.material.utils.InvictusStatus;

@Repository
public interface TopicRepo extends JpaRepository<TopicEntity, Integer> {

	@Query("SELECT t FROM TopicEntity t WHERE t.topicStatus = :status AND t.addSubTopicStatus = 'Y'") 
	List<TopicEntity> getAllNavigationLinkByStatus(@Param("status") String status);
	
	@Query("SELECT t FROM TopicEntity t WHERE t.topicStatus = :status") 
	List<TopicEntity> getAllNavItemByStatus(@Param("status") String status);
	
	@Query("SELECT t FROM TopicEntity t WHERE t.navigationEntity.navId = :navId") 
	List<TopicEntity> getNavigationLinkByNavId(@Param("navId") Long navId);

	@Query("SELECT t FROM TopicEntity t WHERE t.topicId = :topicId") 
	TopicEntity getTopicById(@Param("topicId") Long topicId);
	
	@Modifying
    @Transactional
    @Query("UPDATE TopicEntity n SET n.topicTitle = :title, n.topicNavigationUrl = :topicNavigationLink, n.lastUpdatedTimeStamp = :localDateTime WHERE n.topicId = :topicId " +
            "AND n.navigationEntity.navId = :navId AND n.topicStatus = '"+ InvictusStatus.PENDING_APPROVAL +"'")  
	int updateTopicVO(int i, Long navId, String title, String topicNavigationLink, LocalDateTime now);
	
	@Modifying
    @Transactional
	@Query("UPDATE TopicEntity t SET t.blogPageKey = :blogPageKey, t.createdBy = :loginId, t.createdTimeStamp = :localDateTime WHERE t.topicId = :topicId"
			+ " AND t.topicStatus = '"+ InvictusStatus.PENDING_APPROVAL +"'")
	int updateTopicVO(@Param("blogPageKey") String blogPageKey, @Param("loginId") Long loginId, @Param("localDateTime") LocalDateTime localDateTime, @Param("topicId") Long topicId);
	
}
