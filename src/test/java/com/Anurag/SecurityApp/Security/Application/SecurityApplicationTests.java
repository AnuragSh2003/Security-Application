package com.Anurag.SecurityApp.Security.Application;

import com.Anurag.SecurityApp.Security.Application.entities.User;
import com.Anurag.SecurityApp.Security.Application.services.JWTService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SecurityApplicationTests {

	@Autowired
	private JWTService jwtService;



	@Test
	void contextLoads() {

		User user = new User(4L,"anurag@gmail.com","1234");

		String token = jwtService.generateToken(user);

		System.out.println(token);

		Long id = jwtService.getUserIdFromToken(token);
		System.out.println(id);

	}

}
