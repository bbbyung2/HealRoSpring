package com.health.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.health.entity.CardioTb;
import com.health.entity.CoronaryTb;
import com.health.entity.DiabetesTb;
import com.health.repository.CardioRepository;
import com.health.repository.CommentRepository;
import com.health.repository.DiabetesRepository;

@Service
public class DiabeteService {
	
	@Autowired
	DiabetesRepository diabeteRepo;
	@Autowired
	CommentRepository comRepo;
	
	public void create(DiabetesTb dia)
	{
		diabeteRepo.save(dia);
	}
	
	public void delete(int id)
	{
		comRepo.deleteComment(2,id);
		DiabetesTb dia = diabeteRepo.findById(id).get();
		String path = System.getProperty("user.dir")+"/src/main/resources/templates/files/img/" + dia.getImg();
		diabeteRepo.deleteById(id);
		System.out.println("PATH "+path);
		try {
			File file = new File(path);
			file.delete();
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	public List<DiabetesTb> findDiabetesTb()
	{
		List<DiabetesTb> list = new ArrayList<>();
		list = diabeteRepo.findAll();
		return list;
		
	}
	public DiabetesTb findDiabetesTbById(int id)
	{
		Optional<DiabetesTb> co = diabeteRepo.findById(id);
		return co.get();
	}

	
}
