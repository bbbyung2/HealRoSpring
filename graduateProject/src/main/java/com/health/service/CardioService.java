package com.health.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.health.entity.CardioTb;
import com.health.entity.DiabetesTb;
import com.health.repository.CardioRepository;
import com.health.repository.CommentRepository;


@Service
public class CardioService {
	@Autowired
	CardioRepository cardioRepo;
	@Autowired
	CommentRepository comRepo;
	
	public void create(CardioTb cardio)
	{
		cardioRepo.save(cardio);
	}
	
	public void delete(int id)
	{
		comRepo.deleteComment(3, id);
		CardioTb ca = cardioRepo.findById(id).get();
		String path = System.getProperty("user.dir")+"/src/main/resources/templates/files/img/" + ca.getImg();
		cardioRepo.deleteById(id);
		System.out.println("PATH "+path);
		try {
			File file = new File(path);
			file.delete();
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	public List<CardioTb> findCardioTb()
	{
		List<CardioTb> list = new ArrayList<>();
		list = cardioRepo.findAll();
		return list;
		
	}
	public CardioTb findCardioTbById(int id)
	{
		Optional<CardioTb> co = cardioRepo.findById(id);
		return co.get();
	}
}
