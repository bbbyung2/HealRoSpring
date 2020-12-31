package com.health.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.health.entity.DiabetesResult;

public interface DiabetesResultRepository extends JpaRepository<DiabetesResult,String>{
	
	@Query(value = "SELECT * FROM diabetes_result A"
			+ "  WHERE A.USER_NAME IN (:userName)", 
			nativeQuery = true)
	DiabetesResult findByUserName(@Param("userName")String userName);
	
	@Transactional
	@Modifying
	@Query(value = "UPDATE diabetes_result A"
			+" SET A.RECENT_RESULT = (:odd), A.RECENT_DATE = (:date)"
			+" WHERE A.USER_NAME = (:userName)",nativeQuery = true)
	void recordResultDiabetes(@Param("odd")Float odd, @Param("userName")String userName, @Param("date")String date);
	
	@Transactional
	@Modifying
	@Query(value = "UPDATE diabetes_result A"
			+" SET A.PAST_RESULT = (:odd), A.PAST_DATE = (:date)"
			+" WHERE A.USER_NAME = (:userName)",nativeQuery = true)
	void recordResultDiabetesPast(@Param("odd")Float odd, @Param("userName")String userName, @Param("date")String date);
}
