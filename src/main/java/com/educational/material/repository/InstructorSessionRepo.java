package com.educational.material.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.educational.material.entity.InstructorEntity;
import com.educational.material.entity.InstructorSessionEntity;
import com.educational.material.entity.pk.InstructorSessionPK;

@Repository
public interface InstructorSessionRepo extends JpaRepository<InstructorSessionEntity, InstructorSessionPK>{

	@Query("SELECT st FROM InstructorSessionEntity st WHERE st.sessionToken = :token AND st.instructorSessionPK.deviceId = :deviceId")
	InstructorSessionEntity getByTokenAndDevideId(@Param("token") String token, @Param("deviceId") String deviceId);
	
	
}
