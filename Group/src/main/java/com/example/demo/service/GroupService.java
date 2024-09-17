package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.demo.model.Group;
import com.example.demo.model.Promotions;
import com.example.demo.repository.GroupRepository;
import com.example.demo.repository.PromotionRepository;


@Service
public class GroupService {
	@Autowired
	private GroupRepository groupRepository;
	
	
	public Group addGroup(Group group) {
	    try {
	        Group groupSave = groupRepository.save(group);
	        return groupSave;
	    } catch (Exception e) {
	        e.printStackTrace();
	        return null;
	    }
	}
	public List<Group> getAllGroup() {
		try {
			return groupRepository.findAll();
		}catch (Exception e) {
	        e.printStackTrace();
	        return null;
		}
    	
    }
	public Optional<Group> getGroupById(int groupId) {
		try {
			return groupRepository.findById(groupId);
		}catch (Exception e) {
	        e.printStackTrace();
	        return null;
		}
    	
    }
	public String deleteGroupById(int groupId) {
		try {
			 Optional<Group> existingGroupOptional = groupRepository.findById(groupId);
             if (existingGroupOptional.isPresent()) {
            	 groupRepository.deleteById(groupId);
            	 return "Deleted Successfully";
         	}else {
         		return "Failed";
         	}
		}catch (Exception e) {
	        e.printStackTrace();	         
		}
		return null;
	}
	public Group updateGroup(Group group, int groupId) {
        try {
        	 Optional<Group> existingGroupOptional = groupRepository.findById(groupId);
             if (existingGroupOptional.isPresent()) {
                 Group existingGroup = existingGroupOptional.get();
                 existingGroup.setGroupId(groupId);
                 existingGroup.setGroupName(group.getGroupName());
                 // Update other fields as needed

                 return groupRepository.save(existingGroup);
             }
        	
            
        } catch (Exception e) {
            e.printStackTrace();
            
        }
		return null;
    }
//	public Group getGroupByGroupId(int groupId) {
//        return groupRepository.findByGroupId(groupId);
//    }
//
//    public Group updateGroup(Group group) {
//        return groupRepository.save(group);
//    }
}
