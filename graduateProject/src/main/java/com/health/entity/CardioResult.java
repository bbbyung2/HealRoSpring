package com.health.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class CardioResult {
	
	@Id
	String userName;
	
	Float recentResult;
	String recentDate;
	Float pastResult;
	String pastDate;
}