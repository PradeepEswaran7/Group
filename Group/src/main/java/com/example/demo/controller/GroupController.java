package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Group;
import com.example.demo.model.Promotions;
import com.example.demo.service.GroupService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class GroupController {
	@Autowired
	private GroupService groupService;
	
	@PostMapping("/addGroup")
	public ResponseEntity<Group> addGroup(@RequestBody Group group) {
	    try {
	        Group result = groupService.addGroup(group);
	        return ResponseEntity.ok(result);
	    } catch (Exception e) {
	        // Log the error or handle it based on your application's requirements
	        e.printStackTrace();
	        return null;
	    }
	}
	
	@GetMapping("/getGroups")
	public ResponseEntity<List<Group>> getAllPromotions() {
	    try {
	    	List<Group> group = groupService.getAllGroup();
	        return ResponseEntity.ok(group);
	    } catch (Exception e) {
	        e.printStackTrace();
	        
	    }
		return null;
	}
	@GetMapping("/getGroup/{groupId}")
	public Optional<Group> getGroupById(@PathVariable int groupId) {
	    try {
	    	Optional<Group> group = groupService.getGroupById(groupId);
	        return group;
	    } catch (Exception e) {
	        e.printStackTrace();
	        
	    }
		return null;
	}
	@DeleteMapping("/delete/{groupId}")
	public ResponseEntity<String> deletePromotion(@PathVariable int groupId) {
		try {
			String deleteGroupById = groupService.deleteGroupById(groupId);
			return ResponseEntity.status(deleteGroupById.contains("Deleted Successfully") ? HttpStatus.OK : HttpStatus.INTERNAL_SERVER_ERROR).body(deleteGroupById);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@PutMapping("/updateGroup/{groupId}")
	public ResponseEntity<Group> updateGroup(@RequestBody Group group, @PathVariable int groupId) {
		try {
	        Group result = groupService.updateGroup(group, groupId);
	        return ResponseEntity.ok(result);
	    } catch (Exception e) {
	        // Log the error or handle it based on your application's requirements
	        e.printStackTrace();
	        return null;
	    }
	}
	
	
//	@PutMapping("/groups/{groupId}")
//    public ResponseEntity<Group> updateGroup(@PathVariable int groupId, @RequestBody Group updatedGroup) {
//        Group group = groupService.getGroupByGroupId(groupId);
//        if (group != null) {
//            group.setName(updatedGroup.getName());
//            Group savedGroup = groupService.updateGroup(group);
//            return ResponseEntity.ok(savedGroup);
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
}
