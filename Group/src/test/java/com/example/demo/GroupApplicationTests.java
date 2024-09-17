package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.example.demo.controller.TestGroupController;
import com.example.demo.model.TestGroup;
import com.example.demo.model.TestPromotions;
import com.example.demo.repository.GroupRepository;
import com.example.demo.repository.TestGroupRepository;
import com.example.demo.service.GroupService;
import com.example.demo.service.TestGroupService;
import com.example.demo.service.TestPromotionService;

@SpringBootTest
@AutoConfigureMockMvc
class GroupApplicationTests {

    @MockBean
    private TestGroupService testGroupService;
    @MockBean
    private TestPromotionService testPromotionService;

    @Test
    public void testAddGroup() {
        TestGroup group = new TestGroup("Test Group");
        when(testGroupService.addGroup(group)).thenReturn("Added Successfully");
        String result = testGroupService.addGroup(group);
        assertThat(result).isEqualTo("Added Successfully");
    }
    
    @Test
    public void testAddPromotion() {
    	TestPromotions promotion = new TestPromotions(1,"Diwali","Discount",1);
    	when(testPromotionService.addPromotion(promotion)).thenReturn("Added successful!");
    	String result = testPromotionService.addPromotion(promotion);
    	assertThat(result).isEqualTo("Added successful!");
	}
    
    @Test
    void testGetAllGroups() {
        List<TestGroup> groups = new ArrayList<>();
        groups.add(new TestGroup("Test Group"));
        when(testGroupService.getAllGroup()).thenReturn(groups);

        List<TestGroup> result = testGroupService.getAllGroup();

        assertThat(result).isNotEmpty();
        assertThat(result).hasSize(1);
        assertThat(result.get(0).getGroupName()).isEqualTo("Test Group");
    }
    
    @Test
    void testGetAllpromotions() {
        List<TestPromotions> promotions = new ArrayList<>();
        promotions.add(new TestPromotions(1,"Diwali","Discount",1));
        when(testPromotionService.getAllpromotions()).thenReturn(promotions);

        List<TestPromotions> result = testPromotionService.getAllpromotions();

        assertThat(result).isNotEmpty();
        assertThat(result).hasSize(1);
    }
    
    @Test
    public void testGetGroupById() {
        int groupId = 1;
        TestGroup group = new TestGroup("Test Group");
        Optional<TestGroup> optional = Optional.of(group);

        when(testGroupService.getGroupById(groupId)).thenReturn(optional);

        Optional<TestGroup> result = testGroupService.getGroupById(groupId);

        assertThat(result).isPresent();
        assertThat(result.get().getGroupName()).isEqualTo("Test Group");
    }
    
    @Test
    public void testGetAllPromotionByGroupId() {
    	int groupId = 1;
    	List<TestPromotions> promotions = new ArrayList<>();
        promotions.add(new TestPromotions(1,"Diwali","Discount",1));
    	when(testPromotionService.getAllPromotionsByGroupId(groupId)).thenReturn(promotions);
    	List<TestPromotions> result = testPromotionService.getAllPromotionsByGroupId(groupId);
    	assertThat(result).isNotEmpty();
    	
    	
	}
    
    @Test
    public void testGetPromotionByGroupIdAndPromotionId() {
    	int promotionId = 1;
    	TestPromotions promotions = new TestPromotions(1,"Diwali","Discount",1);
    	Optional<TestPromotions> optional = Optional.of(promotions);
    	when(testPromotionService.getPromotionByGroupIdAndPromotionId(promotionId)).thenReturn(optional);
    	Optional<TestPromotions> result = testPromotionService.getPromotionByGroupIdAndPromotionId(promotionId);
    	assertThat(result).isNotEmpty();
    	
    	
	}
    
    @Test
    public void testDeleteGroupById() {
        int groupId = 1;
        when(testGroupService.deleteGroupById(groupId)).thenReturn("Deleted Successfully");

        String result = testGroupService.deleteGroupById(groupId);

        assertThat(result).isEqualTo("Deleted Successfully");
    }

    @Test
    public void testUpdateGroup() {
        int groupId = 1;
        TestGroup updatedGroup = new TestGroup("Updated Group");
        when(testGroupService.updateGroup(updatedGroup, groupId)).thenReturn(updatedGroup);

        TestGroup result = testGroupService.updateGroup(updatedGroup, groupId);

        assertThat(result).isNotNull();
        assertThat(result.getGroupName()).isEqualTo("Updated Group");
    }

}
