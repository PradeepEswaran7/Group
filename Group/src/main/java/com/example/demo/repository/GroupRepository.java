package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Group;


public interface GroupRepository extends JpaRepository<Group, Integer> {
	// Group findByGroupId(int groupId);
    // Add your custom repository methods here
}