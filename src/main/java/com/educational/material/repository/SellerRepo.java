package com.educational.material.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.educational.material.entity.SellerEntity;

@Repository
public interface SellerRepo extends JpaRepository<SellerEntity, Integer> {

}
