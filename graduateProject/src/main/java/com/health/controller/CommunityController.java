package com.health.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.health.entity.CardioTb;
import com.health.entity.Comment;
import com.health.entity.CoronaryTb;
import com.health.entity.DiabetesTb;
import com.health.service.CardioService;
import com.health.service.CommentService;
import com.health.service.CoronaryTbService;
import com.health.service.DiabeteService;

@Controller
public class CommunityController {
	
	@Autowired
	CoronaryTbService coronaryService;
	@Autowired
	CardioService cardioService;
	@Autowired
	DiabeteService diaService;
	@Autowired
	CommentService commentService;
	
	
	@GetMapping("/community")
	public ModelAndView community(@RequestParam(value = "type", defaultValue="1") int type)
	{	
		List<CoronaryTb> coronaryList = coronaryService.findCoronaryTb();
		List<CardioTb> cardioList = cardioService.findCardioTb();
		List<DiabetesTb> diabetesList = diaService.findDiabetesTb();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("community");
		mv.addObject("type",type);
		mv.addObject("coronaryList",coronaryList);
		mv.addObject("cardioList",cardioList);
		mv.addObject("diabetesList",diabetesList);
		return mv;
		
	}
	
	
	@GetMapping("/coronaryView")
	public ModelAndView coronaryView(@RequestParam("id") int id)
	{	
		List<Comment> commentList = commentService.coronaryComment(id);
		CoronaryTb coronary = coronaryService.findCoronaryTbById(id);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("view");
		mv.addObject("img",coronary.getImg());
		mv.addObject("title",coronary.getTitle());
		mv.addObject("content",coronary.getContent());
		mv.addObject("nickname",coronary.getNickname());
		mv.addObject("id",coronary.getId());
		mv.addObject("type",1);
		mv.addObject("commentList",commentList);
		return mv;
		
	}
	
	@GetMapping("/diabeteView")
	public ModelAndView diabeteView(@RequestParam("id") int id)
	{	
		
		List<Comment> commentList = commentService.diabetesComment(id);
		DiabetesTb dia = diaService.findDiabetesTbById(id);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("view");
		mv.addObject("title",dia.getTitle());
		mv.addObject("img",dia.getImg());
		
		mv.addObject("content",dia.getContent());
		mv.addObject("nickname",dia.getNickname());
		mv.addObject("id",dia.getId());
		mv.addObject("type",2);
		mv.addObject("commentList",commentList);
		return mv;
		
	}
	
	@GetMapping("/cardioView")
	public ModelAndView cardioView(@RequestParam("id") int id)
	{	
		List<Comment> commentList = commentService.cardioComment(id);
		CardioTb cardio = cardioService.findCardioTbById(id);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("view");
		mv.addObject("title",cardio.getTitle());
		mv.addObject("img",cardio.getImg());
		
		mv.addObject("content",cardio.getContent());
		mv.addObject("nickname",cardio.getNickname());
		mv.addObject("id",cardio.getId());
		mv.addObject("type",3);
		mv.addObject("commentList",commentList);
		return mv;
		
	}
	
	@GetMapping("/deleteCoronaryPost")
	public ModelAndView deleteCoronaryPost(@RequestParam("id") int id)
	{	
		coronaryService.delete(id);
		List<CoronaryTb> coronaryList = coronaryService.findCoronaryTb();
		List<DiabetesTb> diabetesList = diaService.findDiabetesTb();
		List<CardioTb> cardioList = cardioService.findCardioTb();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("community");
		mv.addObject("type",1);
		mv.addObject("coronaryList",coronaryList);
		mv.addObject("diabetesList",diabetesList);
		mv.addObject("cardioList",cardioList);
		return mv;
		
	}
	
	@GetMapping("/deleteDiabetePost")
	public ModelAndView deleteDiabetePost(@RequestParam("id") int id)
	{	
		diaService.delete(id);
		List<CoronaryTb> coronaryList = coronaryService.findCoronaryTb();
		List<DiabetesTb> diabetesList = diaService.findDiabetesTb();
		List<CardioTb> cardioList = cardioService.findCardioTb();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("community");
		mv.addObject("type",2);
		mv.addObject("coronaryList",coronaryList);
		mv.addObject("diabetesList",diabetesList);
		mv.addObject("cardioList",cardioList);
		return mv;
		
	}
	
	@GetMapping("/deleteCardioPost")
	public ModelAndView deleteCardioPost(@RequestParam("id") int id)
	{	
		cardioService.delete(id);
		List<CoronaryTb> coronaryList = coronaryService.findCoronaryTb();
		List<DiabetesTb> diabetesList = diaService.findDiabetesTb();
		List<CardioTb> cardioList = cardioService.findCardioTb();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("community");
		mv.addObject("type",3);
		mv.addObject("coronaryList",coronaryList);
		mv.addObject("diabetesList",diabetesList);
		mv.addObject("cardioList",cardioList);
		return mv;
		
	}
	
	
	
	
	
	
}
