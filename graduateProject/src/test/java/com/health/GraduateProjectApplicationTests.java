package com.health;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import com.health.entity.User;
import com.health.repository.UserRepository;
import com.health.run.GraduateProjectApplication;


@SpringBootTest(classes = { GraduateProjectApplicationTests.class, GraduateProjectApplication.class,  })
class GraduateProjectApplicationTests {

	@Autowired
	UserRepository userRepo;
	
	@Test
	void contextLoads() {
		
		User user = new User();
		user.setUserId("test1");
		user.setUserPwd("1234");
		user.setUserName("kim");
		
		userRepo.save(user);
		
		
	}

}
