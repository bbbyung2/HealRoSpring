package com.health.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.health.entity.CardioResult;

public interface CardioResultRepository extends JpaRepository<CardioResult,String>{
	
	@Query(value = "SELECT * FROM cardio_result A"
			+ "  WHERE A.USER_NAME IN (:userName)", 
			nativeQuery = true)
	CardioResult findByUserName(@Param("userName")String userName);
	
	@Transactional
	@Modifying
	@Query(value = "UPDATE cardio_result A"
			+" SET A.RECENT_RESULT = (:odd), A.RECENT_DATE = (:date)"
			+" WHERE A.USER_NAME = (:userName)",nativeQuery = true)
	void recordResultCardio(@Param("odd")Float odd, @Param("userName")String userName, @Param("date")String date);
	
	@Transactional
	@Modifying
	@Query(value = "UPDATE cardio_result A"
			+" SET A.PAST_RESULT = (:odd), A.PAST_DATE = (:date)"
			+" WHERE A.USER_NAME = (:userName)",nativeQuery = true)
	void recordResultCardioPast(@Param("odd")Float odd, @Param("userName")String userName, @Param("date")String date);
}
