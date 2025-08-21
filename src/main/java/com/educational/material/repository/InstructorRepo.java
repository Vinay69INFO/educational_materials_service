package com.educational.material.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.educational.material.entity.InstructorEntity;

@Repository
public interface InstructorRepo extends JpaRepository<InstructorEntity, Long>{
	
	@Query("SELECT i.instructorId FROM InstructorEntity i WHERE i.emailAddress = :emailAddress")
	Long getInstructorByEmail(@Param("emailAddress") String emailAddress);
	
	@Query("SELECT i FROM InstructorEntity i WHERE i.emailAddress = :emailAddress")
	InstructorEntity getInstructorEntityByEmail(@Param("emailAddress") String emailAddress);
	
	@Query("SELECT i FROM InstructorEntity i WHERE i.instructorId = :instructorId")
	InstructorEntity getByInstructorId(@Param("instructorId") Long instructorId);
}
