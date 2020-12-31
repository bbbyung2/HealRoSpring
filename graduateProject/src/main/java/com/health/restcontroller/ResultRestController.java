package com.health.restcontroller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.health.service.ResultService;

@RestController
public class ResultRestController {
	
	@Autowired
	ResultService resultService;
	
	@PostMapping("/recordResult")
	public String recordResult(@RequestBody Map<String,String> info, HttpSession session, HttpServletResponse response)
	{
		String userNickName = (String) session.getAttribute("userNickName");
		String diseaseName = info.get("disease");
		String odd = info.get("odd");
		Float result = Float.valueOf(odd).floatValue();
		int diseaseType = -1;
		Float past = null;
		String pastDate;
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date time = new Date();
		String date = format.format(time);
		
		System.out.println(userNickName);
		System.out.println(diseaseName);
		System.out.println(result);
		System.out.println(date);
		
		if(diseaseName.equals("cardio")) {
			diseaseType = 0;
			past = (Float) session.getAttribute("cardio");
			if(past != null) {
				pastDate = (String) session.getAttribute("cardioDate");
				session.setAttribute("cardioPast", past);
				session.setAttribute("cardioPastDate", pastDate);
				resultService.recordResult(10,past,userNickName,pastDate);
			}
			session.setAttribute("cardio", result);
			session.setAttribute("cardioDate", date);
		}
		else if(diseaseName.equals("coronary")) {
			diseaseType = 1;
			past = (Float) session.getAttribute("coronary");
			if(past != null) {
				pastDate = (String) session.getAttribute("coronaryDate");
				session.setAttribute("coronaryPast", past);
				session.setAttribute("coronaryPastDate", pastDate);
				resultService.recordResult(11,past,userNickName,pastDate);
			}
			session.setAttribute("coronary", result);
			session.setAttribute("coronaryDate", date);
		}
		else if(diseaseName.equals("diabetes")) {
			diseaseType = 2;
			past = (Float) session.getAttribute("diabetes");
			if(past != null) {
				pastDate = (String) session.getAttribute("diabetesDate");
				session.setAttribute("diabetesPast", past);
				session.setAttribute("diabetesPastDate", pastDate);
				resultService.recordResult(12,past,userNickName,pastDate);
			}
			session.setAttribute("diabetes", result);
			session.setAttribute("diabetesDate", date);
		}
		
		resultService.recordResult(diseaseType,result,userNickName,date);
		return userNickName;
		
	}
	
}
