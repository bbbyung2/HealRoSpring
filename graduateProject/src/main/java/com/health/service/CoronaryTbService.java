package com.health.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.health.entity.CoronaryTb;
import com.health.repository.CommentRepository;
import com.health.repository.CoronaryTbRepository;


@Service
public class CoronaryTbService {

	@Autowired
	CoronaryTbRepository coronaryRepo;
	@Autowired
	CommentRepository comRepo;
	
	public void create(CoronaryTb coro)
	{
		coronaryRepo.save(coro);
	}
	
	public void delete(int id)
	{
		comRepo.deleteComment(1, id);
		CoronaryTb co = coronaryRepo.findById(id).get();
		String path = System.getProperty("user.dir")+"/src/main/resources/templates/files/img/" + co.getImg();
		coronaryRepo.deleteById(id);
		System.out.println("PATH "+path);
		try {
			File file = new File(path);
			file.delete();
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	public List<CoronaryTb> findCoronaryTb()
	{
		List<CoronaryTb> list = new ArrayList<>();
		list = coronaryRepo.findAll();
		return list;
		
	}
	public CoronaryTb findCoronaryTbById(int id)
	{
		Optional<CoronaryTb> co = coronaryRepo.findById(id);
		return co.get();
	}
}
