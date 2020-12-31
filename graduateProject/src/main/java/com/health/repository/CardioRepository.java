package com.health.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.health.entity.CardioTb;
import com.health.entity.CoronaryTb;

public interface CardioRepository  extends JpaRepository<CardioTb, Integer>{

}
