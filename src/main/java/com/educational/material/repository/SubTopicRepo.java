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
import com.educational.material.entity.SubTopicEntity;
import com.educational.material.entity.TopicEntity;
import com.educational.material.utils.InvictusStatus;

@Repository
public interface SubTopicRepo extends JpaRepository<SubTopicEntity, Integer>{

	@Query("SELECT st FROM SubTopicEntity st WHERE st.topicEntity.topicId = :topicId AND st.subtopictatus = :status") 
	List<SubTopicEntity> getAllSubTopicByTopicId(@Param("topicId") Long topicId, @Param("status") String status);
	
	@Query("SELECT st FROM SubTopicEntity st WHERE st.subtopictatus = :status") 
	List<SubTopicEntity> getAllSubTopicByStatus(@Param("status") String status);
	
	@Query("SELECT st FROM SubTopicEntity st WHERE st.subTopicTitle = :title") 
	SubTopicEntity getSubTopicByTitle(@Param("title") String title);

	@Modifying
    @Transactional
    @Query("UPDATE SubTopicEntity n SET n.subTopicTitle = :title, n.subTopicNavigationUrl = :subTopicNavigationLink, n.lastUpdatedTimeStamp = :localDateTime WHERE n.subTopicId = :subTopicId " +
            "AND n.topicEntity.topicId = :loginId AND n.subtopictatus = '"+ InvictusStatus.PENDING_APPROVAL +"'")
	int updateSubTopicVOBytopicId(int i, Long subTopicId, String title, String subTopicNavigationLink, LocalDateTime now);
	//int updateSubTopicVOBytopicId(@Param("sellerId") int i, @Param("subTopicId") Long subTopicId,  @Param("subTopicId") String title, @Param("subTopicNavigationLink") String subTopicNavigationLink, @Param("now") LocalDateTime now);


	@Query("SELECT t FROM SubTopicEntity t WHERE t.topicEntity.topicId = :topicId") 
	List<SubTopicEntity> getAllSubTopicByStatus(@Param("topicId") Long topicId);
	
	@Query("SELECT t FROM SubTopicEntity t WHERE t.subTopicId = :subTopicId") 
	SubTopicEntity getSubTopicById(@Param("subTopicId") Long subTopicId);
	
	@Modifying
    @Transactional
	@Query("UPDATE SubTopicEntity s SET s.blogPageKey = :blogPageKey, s.createdBy = :loginId, s.createdTimeStamp = :localDateTime WHERE s.subTopicId = :subTopicId"
			+ " AND s.subtopictatus = '"+ InvictusStatus.PENDING_APPROVAL +"'")
	int updateSubTopicVO(@Param("blogPageKey") String blogPageKey, @Param("loginId") Long loginId, @Param("localDateTime") LocalDateTime localDateTime, @Param("subTopicId") Long subTopicId);
	
}
