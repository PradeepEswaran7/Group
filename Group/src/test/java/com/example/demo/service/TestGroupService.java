package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.TestGroup;

import com.example.demo.repository.TestGroupRepository;
@Service
public class TestGroupService {
	 @Autowired
	    private TestGroupRepository testGroupRepo;
	    
	    public String addGroup(TestGroup group) {
	        try {
	            testGroupRepo.save(group);
	            return "Added successful!";
	        } catch (Exception e) { 
	            e.printStackTrace();
	            return "Failed!";
	        }
	    }

	public List<TestGroup> getAllGroup() {
		try {
			return testGroupRepo.findAll();
		}catch (Exception e) {
	        e.printStackTrace();
	        return null;
		}
    	
    }
	public Optional<TestGroup> getGroupById(int groupId) {
		try {
			return testGroupRepo.findById(groupId);
		}catch (Exception e) {
	        e.printStackTrace();
	        return null;
		}
    	
    }
	public String deleteGroupById(int groupId) {
		try {
			 Optional<TestGroup> existingGroupOptional = testGroupRepo.findById(groupId);
             if (existingGroupOptional.isPresent()) {
            	 testGroupRepo.deleteById(groupId);
            	 return "Deleted Successfully";
         	}else {
         		return "Failed";
         	}
		}catch (Exception e) {
	        e.printStackTrace();	         
		}
		return null;
	}
	public TestGroup updateGroup(TestGroup group, int groupId) {
        try {
        	 Optional<TestGroup> existingGroupOptional = testGroupRepo.findById(groupId);
             if (existingGroupOptional.isPresent()) {
                 TestGroup existingGroup = existingGroupOptional.get();
//                 existingGroup.setGroupId(groupId);
                 existingGroup.setGroupName(group.getGroupName());
                 // Update other fields as needed
                 System.out.println(group.getGroupName());
                 return testGroupRepo.save(existingGroup);
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
