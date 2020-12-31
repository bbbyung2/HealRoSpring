package com.health.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Comment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	
	
	//게시판 종류 
	int type;
	//해당 게시판의 글 ID
	int num;
	
	Date time;
	String nickname;
	String comment;
}
