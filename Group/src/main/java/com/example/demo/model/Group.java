package com.example.demo.model;

import java.util.ArrayList;


import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "`groups`")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int groupId;
    
    public int getGroupId() {
		return groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

	private String groupName;
	
	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

//	@OneToMany(cascade = CascadeType.ALL)
//	@JoinColumn(name = "group_id", referencedColumnName = "groupId")
//    private List<Promotions> promotions;

//	public List<Promotions> getPromotions() {
//        return promotions;
//    }
//
//    public void setPromotions(List<Promotions> promotions) {
//        this.promotions = promotions;
//    }

	
}
