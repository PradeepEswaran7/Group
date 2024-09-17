package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.TestGroup;

import com.example.demo.service.TestGroupService;

@RestController
public class TestGroupController {
	@Autowired
	private TestGroupService testGroupService;
	
//	@PostMapping("/addTestGroup")
//	public ResponseEntity<String> addGroups(@RequestBody TestGroup group) {
//	    try {
//	        String result = testGroupService.addGroup(group);
//	        return ResponseEntity.status(result.contains("Added successful!") ? HttpStatus.OK : HttpStatus.INTERNAL_SERVER_ERROR).body(result);
//	    } catch (Exception e) {
//	        // Log the error or handle it based on your application's requirements
//	        e.printStackTrace();
//	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to add groups");
//	    }
//	}
	@GetMapping("/getTestGroups")
	public ResponseEntity<List<TestGroup>> getAllGroup() {
	    try {
	    	List<TestGroup> group = testGroupService.getAllGroup();
	        return ResponseEntity.ok(group);
	    } catch (Exception e) {
	        e.printStackTrace();
	        
	    }
		return null;
	}
//	@GetMapping("/getGroup/{groupId}")
//	public Optional<TestGroup> getGroupById(@PathVariable int groupId) {
//	    try {
//	    	Optional<TestGroup> group = testGroupService.getGroupById(groupId);
//	        return group;
//	    } catch (Exception e) {
//	        e.printStackTrace();
//	        
//	    }
//		return null;
//	}
//	@DeleteMapping("/deleteGroup/{groupId}")
//	public ResponseEntity<String> deleteGroup(@PathVariable int groupId) {
//	    try {
//	        String deleteGroupById = testGroupService.deleteGroupById(groupId);
//	        return ResponseEntity.status(deleteGroupById.contains("successful") ? HttpStatus.OK : HttpStatus.INTERNAL_SERVER_ERROR).body(deleteGroupById);
//	    } catch (Exception e) {
//	        e.printStackTrace();
//	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete group");
//	    }
//	}
//	
//	@PutMapping("/updateGroup/{groupId}")
//	public ResponseEntity<TestGroup> updateGroup(@RequestBody TestGroup group, @PathVariable int groupId) {
//		try {
//	        TestGroup result = testGroupService.updateGroup(group, groupId);
//	        return ResponseEntity.ok(result);
//	    } catch (Exception e) {
//	        // Log the error or handle it based on your application's requirements
//	        e.printStackTrace();
//	        return null;
//	    }
//	}
}
	
	
