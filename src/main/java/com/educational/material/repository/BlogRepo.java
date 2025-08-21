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
public interface BlogRepo extends JpaRepository<BlogEntity, Long>{

	
	@Modifying
	@Query("SELECT b FROM BlogEntity b WHERE b.blogStatus = :status") 
	List<BlogEntity> getAllBlogByStatus(@Param("status") String status);
	
	@Query("SELECT b FROM BlogEntity b WHERE b.blogPageKey = :blogPageKey") 
	BlogEntity getBlogByPagekey(@Param("blogPageKey") String blogPageKey);
	
	@Modifying
    @Transactional
	@Query("UPDATE BlogEntity b SET b.blogPageKey = :blogPageKey, b.createdBy = :loginId, b.createdTimeStamp = :localDateTime WHERE b.blogId = :blogId"
			+ " AND b.blogStatus = '"+ InvictusStatus.PENDING_APPROVAL +"'")
	int updateBlogVO(@Param("blogPageKey") String blogPageKey, @Param("loginId") Long loginId, @Param("localDateTime") LocalDateTime localDateTime, @Param("blogId") Long blogId);
	
}
