package com.educational.material.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.educational.material.entity.NavigationEntity;
import com.educational.material.utils.InvictusStatus;

@Repository
public interface NavigationLinkRepo extends JpaRepository<NavigationEntity, Integer>{
	
	@Query("SELECT n FROM NavigationEntity n WHERE n.navStatus = :status") 
	List<NavigationEntity> getAllNavigationLinkByStatus(@Param("status") String status);

	@Query("SELECT n FROM NavigationEntity n WHERE n.navTitle = :title") 
	NavigationEntity getNavigationEntityByTtile(@Param("title") String title);
	
	@Query("SELECT n FROM NavigationEntity n WHERE n.sellerEntity.sellerId = :loginId") 
	List<NavigationEntity> getNavigationLinkByLogedInUser(@Param("loginId") Long navId);
	
	@Modifying
    @Transactional
    @Query("UPDATE NavigationEntity n SET n.navTitle = :title, n.navUrl = :navigationLink, n.lastUpdatedTimeStamp = :localDateTime WHERE n.navId = :navId " +
            "AND n.sellerEntity.sellerId = :loginId AND n.navStatus = '"+ InvictusStatus.PENDING_APPROVAL +"'")
    int updateNavigationLink(@Param("loginId") Integer loginId, @Param("navId") Long navId, @Param("title") String title, @Param("navigationLink") String navigationLink, @Param("localDateTime") LocalDateTime localDateTime );
}

