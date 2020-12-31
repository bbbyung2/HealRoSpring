package com.health.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.health.entity.CoronaryResult;

public interface CoronaryResultRepository extends JpaRepository<CoronaryResult,String>{
	
	@Query(value = "SELECT * FROM coronary_result A"
			+ "  WHERE A.USER_NAME IN (:userName)", 
			nativeQuery = true)
	CoronaryResult findByUserName(@Param("userName")String userName);
	
	@Transactional
	@Modifying
	@Query(value = "UPDATE coronary_result A"
			+" SET A.RECENT_RESULT = (:odd), A.RECENT_DATE = (:date)"
			+" WHERE A.USER_NAME = (:userName)",nativeQuery = true)
	void recordResultCoronary(@Param("odd")Float odd, @Param("userName")String userName, @Param("date")String date);
	
	@Transactional
	@Modifying
	@Query(value = "UPDATE coronary_result A"
			+" SET A.PAST_RESULT = (:odd), A.PAST_DATE = (:date)"
			+" WHERE A.USER_NAME = (:userName)",nativeQuery = true)
	void recordResultCoronaryPast(@Param("odd")Float odd, @Param("userName")String userName, @Param("date")String date);
	
}
