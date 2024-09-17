package com.example.demo.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Group;
import com.example.demo.model.Promotions;
import com.example.demo.repository.PromotionRepository;


@Service
public class PromotionService {

	@Autowired
	private PromotionRepository promotionRepository;
	
	public Promotions addPromotion(Promotions promotion) {
		try {
			Promotions promotionSave = promotionRepository.save(promotion);
	        return promotionSave;
		}catch (Exception e) {
	        e.printStackTrace();
	        return null;
		}   
    }
	

	
	public List<Promotions> getAllpromotions() {
	    try {
	        return promotionRepository.findAll();
	    } catch (Exception e) {
	        e.printStackTrace();
	        return Collections.emptyList(); // Return an empty list or handle the error according to your application's requirements
	    }
	}
	public List<Promotions> getAllPromotionsByGroupId(int groupId) {
		try {
			return promotionRepository.findByGroupGroupId(groupId);
		}catch (Exception e) {
	        e.printStackTrace();
	        return null;
		}
    	
    }
	public Optional<Promotions> getPromotionByGroupIdAndPromotionId(int promotionId) {
		try {
			return promotionRepository.findById(promotionId);
		}catch (Exception e) {
	        e.printStackTrace();
	        return null;
		}
    	
    }
	public Promotions updatePromotion(Promotions promotion, int promotionId) {
        try {
        	Optional<Promotions> findById = promotionRepository.findById(promotionId);
        	if(findById.isPresent()) {
        		Promotions findById1 = findById.get();
        		findById1.setPromotionId(promotionId);
        		findById1.setPromotionName(promotion.getPromotionName());
        		findById1.setPromotionType(promotion.getPromotionType());
        		findById1.setGroup(promotion.getGroup());
        		return promotionRepository.save(findById1);
        	}
            
        } catch (Exception e) {
            e.printStackTrace();
            
        }
		return null;
    }
	
	public String deletePromotionById(int promotionId) {
		try {
			Optional<Promotions> findById = promotionRepository.findById(promotionId);
        	if(findById.isPresent()) {
        		promotionRepository.deleteById(promotionId);
        		return "Deleted Successfully";
        	}else {
        		return "Failed";
        	}
		}catch (Exception e) {
	        e.printStackTrace();
	         
		}
		return null;
	}
}

