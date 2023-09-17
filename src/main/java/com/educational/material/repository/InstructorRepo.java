package com.educational.material.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educational.material.entity.InstructorEntity;

public interface InstructorRepo extends JpaRepository<InstructorEntity, Long>{

}
