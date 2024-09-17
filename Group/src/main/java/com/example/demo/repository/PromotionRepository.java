package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Promotions;



public interface PromotionRepository extends JpaRepository<Promotions, Integer> {
	List<Promotions> findByGroupGroupId(int groupId);
}
