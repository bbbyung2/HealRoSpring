package com.health.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.health.entity.Comment;
import com.health.repository.CommentRepository;


@Service
public class CommentService {

	@Autowired
	CommentRepository comrepo;
	
	public void create(Comment co)
	{
		comrepo.save(co);
	}
	
	public void deleteByid(int id)
	{
		comrepo.deleteById(id);
	}
	
	public List<Comment> coronaryComment(int id)
	{
		List<Comment> list = comrepo.findBynum(id);
		List<Comment> result = new ArrayList<>();
		for( Comment c : list)
		{
			if(c.getType() == 1)
			{
				result.add(c);
			}
		}
		return result;
		
	}
	
	public List<Comment> diabetesComment(int id)
	{
		List<Comment> list = comrepo.findBynum(id);
		List<Comment> result = new ArrayList<>();
		for( Comment c : list)
		{
			if(c.getType() == 2)
			{
				result.add(c);
			}
		}
		return result;
	}
	
	public List<Comment> cardioComment(int id)
	{
		List<Comment> list = comrepo.findBynum(id);
		List<Comment> result = new ArrayList<>();
		for( Comment c : list)
		{
			if(c.getType() == 3)
			{
				result.add(c);
			}
		}
		return result;
	}
}
