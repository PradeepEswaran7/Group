package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Promotions;
import com.example.demo.model.TestPromotions;
import com.example.demo.repository.PromotionRepository;
import com.example.demo.repository.TestPromotionRepository;
@Service
public class TestPromotionService {
	
	@Autowired
	private TestPromotionRepository testPromotionRepository;
	
	public String addPromotion(TestPromotions promotion) {
		try {
			testPromotionRepository.save(promotion);
	        return "Added successful!";
		}catch (Exception e) {
	        e.printStackTrace();
	        return "Failed!";
		}   
    }
	
	public List<TestPromotions> getAllpromotions() {
		try {
			return testPromotionRepository.findAll();
		}catch (Exception e) {
	        e.printStackTrace();
	        return null;
		}
    	
    }
	public List<TestPromotions> getAllPromotionsByGroupId(int groupId) {
		try {
			return testPromotionRepository.findByGroupGroupId(groupId);
		}catch (Exception e) {
	        e.printStackTrace();
	        return null;
		}
    	
    }
	public Optional<TestPromotions> getPromotionByGroupIdAndPromotionId(int promotionId) {
		try {
			return testPromotionRepository.findById(promotionId);
		}catch (Exception e) {
	        e.printStackTrace();
	        return null;
		}
    	
    }
//	public Promotions updatePromotion(Promotions promotion, int promotionId) {
//        try {
//        	Optional<Promotions> findById = promotionRepository.findById(promotionId);
//        	if(findById.isPresent()) {
//        		Promotions findById1 = findById.get();
//        		findById1.setPromotionId(promotionId);
//        		findById1.setPromotionName(promotion.getPromotionName());
//        		findById1.setPromotionType(promotion.getPromotionType());
//        		findById1.setGroup(promotion.getGroup());
//        		return promotionRepository.save(findById1);
//        	}
//            
//        } catch (Exception e) {
//            e.printStackTrace();
//            
//        }
//		return null;
//    }
//	public String deletePromotionById(int promotionId) {
//		try {
//			Optional<Promotions> findById = promotionRepository.findById(promotionId);
//        	if(findById.isPresent()) {
//        		promotionRepository.deleteById(promotionId);
//        		return "Deleted Successfully";
//        	}else {
//        		return "Failed";
//        	}
//		}catch (Exception e) {
//	        e.printStackTrace();
//	         
//		}
//		return null;
//	}
}

