package com.health.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Hospital {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	String hospitalCity;
	String hospitalImg;
	String hospitalName;
	String hospitalAddr;
	String hospitalWeb;
	String hospitalPhone;
	java.math.BigDecimal hospitalLatitude;
	java.math.BigDecimal hospitalLongitude;
	
}
