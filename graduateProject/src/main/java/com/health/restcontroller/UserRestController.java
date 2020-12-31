package com.health.restcontroller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.health.entity.User;
import com.health.service.ResultService;
import com.health.service.UserService;

@RestController
public class UserRestController {

	@Autowired
	UserService userService;
	@Autowired
	ResultService resultService;
	
	/**
	 * 
	 * @param user
	 * @return
	 * 1 : success
	 * 2 : Already Exist
	 * 3 : Fail / Maybe Not English NickName
	 */
	
	@PostMapping("/signUp")
	public int signUp(@RequestBody User user)
	{
		int response = 0;
		if(userService.searchId(user.getUserId()))
		{
			response += 2;
		}
		if(userService.searchName(user.getUserName()))
		{
			response += 3;
		}
		
		if(response != 0) {
			return response;
		}
		
		boolean check = userService.create(user);
		if(check)
		{
			return 1;
		}
		else {
			return 0;
		}
	}
	
	@PostMapping("/signIn")
	public int signIn(@RequestBody User user, HttpSession session, HttpServletResponse response)
	{
		int check = userService.login(user);
		if(check == 1)
		{
			String userNickName = userService.searchObj(user.getUserId()).getUserName();
			session.setAttribute("userNickName", userNickName);
			session.setAttribute("coronary", resultService.searchCoronary(userNickName).getRecentResult());
			session.setAttribute("coronaryDate", resultService.searchCoronary(userNickName).getRecentDate());
			session.setAttribute("coronaryPast", resultService.searchCoronary(userNickName).getPastResult());
			session.setAttribute("coronaryPastDate", resultService.searchCoronary(userNickName).getPastDate());
			session.setAttribute("cardio", resultService.searchCardio(userNickName).getRecentResult());
			session.setAttribute("cardioDate", resultService.searchCardio(userNickName).getRecentDate());
			session.setAttribute("cardioPast", resultService.searchCardio(userNickName).getPastResult());
			session.setAttribute("cardioPastDate", resultService.searchCardio(userNickName).getPastDate());
			session.setAttribute("diabetes", resultService.searchDiabetes(userNickName).getRecentResult());
			session.setAttribute("diabetesDate", resultService.searchDiabetes(userNickName).getRecentDate());
			session.setAttribute("diabetesPast", resultService.searchDiabetes(userNickName).getPastResult());
			session.setAttribute("diabetesPastDate", resultService.searchDiabetes(userNickName).getPastDate());
			
		}
		return check;
		
	}
	
	
	@PostMapping("/findPwd")
	public int findPwd(@RequestBody User user)
	{
		return userService.findPwd(user);
		
	}
	
	@PostMapping("/changePwd")
	public void changePwd(@RequestBody User user) {
		userService.changePwd(user);
	}
	
}