package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
@Entity
public class TestPromotions {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "promotion_id")
    private int promotionId;
    
    @Column(name = "promotion_name")
    private String promotionName;

    @Column(name = "promotion_type")
    private String promotionType;
    
    @ManyToOne
//    @JoinColumn(name = "group_id")
    private Group group;
  
	public TestPromotions(int i, String string, String string2, int j) {
		this.promotionId = i;
		this.promotionName = string;
		this.promotionType = string2;
		this.group = new Group(); // Initialize the group object
	    this.group.setGroupId(j);
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	// Getters and setters
    public int getPromotionId() {
        return promotionId;
    }

    public void setPromotionId(int promotionId) {
        this.promotionId = promotionId;
    }

  
    public String getPromotionName() {
        return promotionName;
    }

    public void setPromotionName(String promotionName) {
        this.promotionName = promotionName;
    }

    public String getPromotionType() {
        return promotionType;
    }

    public void setPromotionType(String promotionType) {
        this.promotionType = promotionType;
    }
}
