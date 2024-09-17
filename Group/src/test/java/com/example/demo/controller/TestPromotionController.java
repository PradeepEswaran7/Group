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

import com.example.demo.model.Promotions;
import com.example.demo.model.TestPromotions;
import com.example.demo.service.PromotionService;
import com.example.demo.service.TestPromotionService;

@RestController
public class TestPromotionController {
	@Autowired
	private TestPromotionService testPromotionService;

	@PostMapping("/addTestPromotion")
	public ResponseEntity<String> addPromotion(@RequestBody TestPromotions promotion) {
	    try {
	    	String result = testPromotionService.addPromotion(promotion);
	    	return ResponseEntity.status(result.contains("successful") ? HttpStatus.OK : HttpStatus.INTERNAL_SERVER_ERROR).body(result);
	    } catch (Exception e) {
	        // Log the error or handle it based on your application's requirements
	        e.printStackTrace();
	        return null;
	    }
	}
	
	@GetMapping("/getTestPromotions")
	public ResponseEntity<List<TestPromotions>> getAllPromotions() {
	    try {
	    	List<TestPromotions> promotions = testPromotionService.getAllpromotions();
	        return ResponseEntity.ok(promotions);
	    } catch (Exception e) {
	        e.printStackTrace();
	
	    }
		return null;
	}
//	@GetMapping("/promotions/{groupId}")
//	public List<Promotions> getAllPromotionsByGroupId(@PathVariable int groupId) {
//	    try {
//	    	List<Promotions> group = promotionService.getAllPromotionsByGroupId(groupId);
//	        return group;
//	    } catch (Exception e) {
//	        e.printStackTrace();
//	        
//	    }
//		return null;
//	}
//	@GetMapping("/promotion/{promotionId}")
//	public Optional<Promotions> getPromotionByGroupIdAndPromotionId(@PathVariable int promotionId) {
//	    try {
//	    	Optional<Promotions> group = promotionService.getPromotionByGroupIdAndPromotionId(promotionId);
//	        return group;
//	    } catch (Exception e) {
//	        e.printStackTrace();
//	        
//	    }
//		return null;
//	}
//	@PutMapping("/updatePromotion/{promotionId}")
//	public ResponseEntity<Promotions> updatePromotion(@RequestBody Promotions promotion, @PathVariable int promotionId) {
//		try {
//	        Promotions result = promotionService.updatePromotion(promotion, promotionId);
//	        return ResponseEntity.ok(result);
//	    } catch (Exception e) {
//	        // Log the error or handle it based on your application's requirements
//	        e.printStackTrace();
//	        return null;
//	    }
//	}
//	@DeleteMapping("/deletePromotion/{promotionId}")
//	public ResponseEntity<String> deletePromotion(@PathVariable int promotionId) {
//		try {
//			String deletePromotionById = promotionService.deletePromotionById(promotionId);
//			return ResponseEntity.status(deletePromotionById.contains("successful") ? HttpStatus.OK : HttpStatus.INTERNAL_SERVER_ERROR).body(deletePromotionById);
//		}catch (Exception e) {
//			e.printStackTrace();
//			
//		}
//		return null;
//	}
}


