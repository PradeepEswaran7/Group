package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Promotions;
import com.example.demo.model.TestPromotions;

public interface TestPromotionRepository extends JpaRepository<TestPromotions, Integer> {
	List<TestPromotions> findByGroupGroupId(int groupId);
}
