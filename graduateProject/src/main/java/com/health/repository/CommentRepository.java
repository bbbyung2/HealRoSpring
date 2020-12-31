package com.health.repository;

import java.util.List;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.health.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment, Integer>{

	List<Comment> findBynum(int num);

	@Transactional
    @Modifying
    @Query(value = "delete from comment where type =:type and num =:num", nativeQuery = true)
	void deleteComment(@Param("type")int type , @Param("num") int num);
}
