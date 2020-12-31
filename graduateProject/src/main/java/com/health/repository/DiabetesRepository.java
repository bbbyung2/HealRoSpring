package com.health.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.health.entity.CoronaryTb;
import com.health.entity.DiabetesTb;

public interface DiabetesRepository  extends JpaRepository<DiabetesTb, Integer>{

} 