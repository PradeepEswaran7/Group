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
import com.example.demo.service.PromotionService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PromotionController {
	@Autowired
	private PromotionService promotionService;

	@PostMapping("/addPromotion")
	public ResponseEntity<Promotions> addPromotion(@RequestBody Promotions promotion) {
	    try {
	    	Promotions result = promotionService.addPromotion(promotion);
	    	return ResponseEntity.ok(result);
	    } catch (Exception e) {
	        // Log the error or handle it based on your application's requirements
	        e.printStackTrace();
	        return null;
	    }
	}
	
	@GetMapping("/getPromotions")
	public ResponseEntity<List<Promotions>> getAllPromotions() {
	    try {
	        List<Promotions> promotions = promotionService.getAllpromotions();
	        return ResponseEntity.ok(promotions);
	    } catch (Exception e) {
	        e.printStackTrace();
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
	    }
	}
	
	@GetMapping("/promotions/{groupId}")
	public List<Promotions> getAllPromotionsByGroupId(@PathVariable int groupId) {
	    try {
	    	List<Promotions> group = promotionService.getAllPromotionsByGroupId(groupId);
	        return group;
	    } catch (Exception e) {
	        e.printStackTrace();
	        
	    }
		return null;
	}
	@GetMapping("/promotion/{promotionId}")
	public Optional<Promotions> getPromotionByGroupIdAndPromotionId(@PathVariable int promotionId) {
	    try {
	    	Optional<Promotions> group = promotionService.getPromotionByGroupIdAndPromotionId(promotionId);
	        return group;
	    } catch (Exception e) {
	        e.printStackTrace();
	        
	    }
		return null;
	}
	@PutMapping("/updatePromotion/{promotionId}")
	public ResponseEntity<Promotions> updatePromotion(@RequestBody Promotions promotion, @PathVariable int promotionId) {
		try {
	        Promotions result = promotionService.updatePromotion(promotion, promotionId);
	        return ResponseEntity.ok(result);
	    } catch (Exception e) {
	        // Log the error or handle it based on your application's requirements
	        e.printStackTrace();
	        return null;
	    }
	}
	@DeleteMapping("/deletePromotion/{promotionId}")
	public ResponseEntity<String> deletePromotion(@PathVariable int promotionId) {
		try {
			String deletePromotionById = promotionService.deletePromotionById(promotionId);
			return ResponseEntity.status(deletePromotionById.contains("Deleted Successfully") ? HttpStatus.OK : HttpStatus.INTERNAL_SERVER_ERROR).body(deletePromotionById);
		}catch (Exception e) {
			e.printStackTrace();
			
		}
		return null;
	}
}
