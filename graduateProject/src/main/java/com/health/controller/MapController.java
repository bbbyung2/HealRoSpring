package com.health.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.health.entity.Hospital;
import com.health.repository.HospitalRepository;

@Controller
public class MapController {
	
	@Autowired
	HospitalRepository hosRepo;
	
	@GetMapping("/https")
	public ModelAndView https(HttpServletRequest request){
		
		boolean secure= request.isSecure();
		ModelAndView mv = new ModelAndView();
		if(!secure)
		{
			mv.addObject("check", 1);
			mv.setViewName("https");
		}
		else
		{
			mv.setViewName("redirect:/map");
		}
		
		
		return mv;
	}
	
	
	@GetMapping("/map")
	public ModelAndView map() {
		
		List<Hospital> hospList = hosRepo.findAll();
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("map");
		mv.addObject("hospList", hospList);
		
		return mv;
	}
}
