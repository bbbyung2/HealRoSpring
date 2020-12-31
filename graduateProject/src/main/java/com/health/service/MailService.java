package com.health.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.health.entity.CardioResult;
import com.health.entity.CoronaryResult;
import com.health.entity.DiabetesResult;
import com.health.entity.User;
import com.health.repository.CardioResultRepository;
import com.health.repository.CoronaryResultRepository;
import com.health.repository.DiabetesResultRepository;

@Service
public class MailService {
	
	@Autowired
	CoronaryResultRepository corepo;
	@Autowired
	DiabetesResultRepository diarepo;
	@Autowired
	CardioResultRepository carepo;
	
	
	public String greetingMessage(User user){
		
		String message = "To, " + user.getUserName() + "\n"
				+ "Hi. This is HealRo. We are sending you the results of the disease prediction at your request.\n"
				+ "This results are predicted through machine learning and have more than 80% accuracy.\n"
				+ "If the results are close to average, maintain your current lifestyle,\n"
				+ "or get some advice from the results guide on HealRo MyPage to improve your lifestyle.\n"
				+ "However, if the results are higher than expected or worse,\n"
				+ "you should visit the hospital and consult with a professional doctor.\n"
				+ "HealRo offers a service that recommends a professional hospital close to you.\n"
				+ "And you can get information from similar people through the HealRo community.\n"
				+ "Share your health tips through the community and try to improve your health status which is result recorded on MyPage.\n\n"
				+ "For more information and details about health guideline, please visit MyPage in HealRo.\n"
				+ "Thank you for using the HealRo service!\n";
		return message;
	}
	
	public String coronaryContent(User user){
		
		CoronaryResult core = corepo.findByUserName(user.getUserName());
		Float result = core.getRecentResult();
		String message;
		String prevention;
		
		if(result != null){
			message = "# percentage of getting a Coronary Artery disease in the future : " + result +" %\n"
					+ "- Health Advice -\n";
			if(result > 30) {
				prevention = "If the risk of coronary artery disease is relatively high, the following preventions are taken:\n\n"
						+ "1. Stop smoking\n"
						+ "2. Blood pressure control\n"
						+ "3. Diet management\n"
						+ "4. Exercise and weight control\n"
						+ "5. Diabetes management\n"
						+ "6. Medication\n";
			}else {
				prevention = "Heart disease is such a scary disease that it ranks second in Korea as the cause of death.\n"
						+ "Therefore, it is important to prevent it, and it can be fully effective just by managing your blood pressure and improving your lifestyle.\n"
						+ "Let's find out four ways to prevent heart disease introduced by the Korean Heart Association. \n\n" +  
						"1.You have to keep your blood pressure under control.\n" + 
						"2. Reduce fast food intake.\n" + 
						"3. Continuous exercise is essential.\n" + 
						"4. Stop Smoking or abstaining from drinking.\n";
			}
			message += prevention;
		}else {
			message = "No results for Coronary Artery disease.\n" + 
				"Get prediction service through the HealRo.\n";
		}
		return message;
	}
	
	public String diabeteContent(User user){
		
		DiabetesResult diare = diarepo.findByUserName(user.getUserName());
		Float result = diare.getRecentResult();
		String message;
		String prevention;
		
		if(diare.getRecentResult() != null){
			message = "# percentage of getting a Diabetes disease in the future : " + diare.getRecentResult() +" %\n" 
					+ "- Health Advice -\n";
			if(result > 30) {
				prevention = "If the probability of developing diabetes is high, the following precautions are needed.\n"
						+ "The focus is on reducing complications and applying effective strategies can reduce the risk of macrophage complications by up to 50%.\n\n"
						+ "1. Blood glucose control\n" + 
						"2. Treatment of lipid diseases\n" + 
						"3. Blood pressure control\n" + 
						"4. Eye Examination\n" + 
						"5. Health Care\n";
			}else {
				prevention = "\n1. Maintain proper weight and waist circumference.\n" + 
						"2. To increase regular exercise or physical activity.\n" + 
						"3. Eat on time evenly with a healthy diet.\n" + 
						"4. Have a good lifestyle.\n" + 
						"5. Risk factors are identified through regular checkups.\n";
			}
			message += prevention;
		}else {
			message = "No results for Diabetes disease.\n" + 
		"Get prediction service through the HealRo.\n";
		}
		return message;
	}
	
	public String cadioContent(User user){
		
		CardioResult care = carepo.findByUserName(user.getUserName());
		Float result = care.getRecentResult();
		String message;
		String prevention;
		
		if(result != null){
			message = "# percentage of getting a Cardiovascular disease in the future : " + result +" %\n" 
					+ "- Health Advice -\n";
			if(result > 30) {
				prevention = "If the risk of cardiovascular disease is relatively high, there are the following precautions:\n\n" + 
						"1. Stop smoking\n" + 
						"2. Blood pressure control\n" + 
						"3. Diet management\n" + 
						"4. Exercise and weight control\n" + 
						"5. Diabetes management\n" + 
						"6. Medication\n";
			}else {
				prevention = "The most important way to prevent cardiovascular disease in the first place is to promote a healthy lifestyle throughout life.\n\n" +  
						"1. Diet management\n" + 
						"2. Exercise\n" + 
						"3. Stop smoking\n" + 
						"4. Medication\n";
			}
			message += prevention;
		}else {
			message = "No results for Cardiovascular disease.\n" + 
		"Get prediction service through the HealRo.\n";
		}
		return message;
	}

}
