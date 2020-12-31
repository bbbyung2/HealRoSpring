package com.health.restcontroller;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.health.entity.User;
import com.health.repository.UserRepository;
import com.health.service.MailService;
import com.health.service.UserService;


@RestController
public class MailRestController {

	@Autowired
	UserRepository userRepo;

	@Autowired 
	private MailSender sender;
	@Autowired
	MailService mailService;

	@Autowired
	JavaMailSender jmsender;
	
	@GetMapping("/mail")
	public String sendMail( HttpSession session, HttpServletResponse response) 
	{ 
		String nickname = (String) session.getAttribute("userNickName");
		User user = userRepo.findByUserName(nickname); 
		String m = mailService.greetingMessage(user)+ "\n\n"
				+ mailService.coronaryContent(user) +"\n"
				+ mailService.diabeteContent(user) + "\n"
				+ mailService.cadioContent(user);
				
		
		MimeMessage msg = jmsender.createMimeMessage();
		try {
	    msg.setFrom("HealRo@noreply"); 
	    msg.addRecipient(RecipientType.TO, new InternetAddress(user.getUserEmail(), user.getUserName(), "euc-kr"));

	    msg.setSubject("HealRo service report.","euc-kr"); 
	    msg.setText(m,"euc-kr"); 
	    jmsender.send(msg); 
		}
		catch (MessagingException e) {
	        e.printStackTrace();
	    } catch (UnsupportedEncodingException e) {
	        e.printStackTrace();
	    }
	    return "";
	    
	}
}
