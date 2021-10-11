package com.roytuts.spring.junit.namedparameterjdbctemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.roytuts.spring.junit.namedparameterjdbctemplate.dao.UserDao;
import com.roytuts.spring.junit.namedparameterjdbctemplate.model.User;

@SpringBootApplication
public class NamedParameterJdbcTemplateApp implements CommandLineRunner {

	@Autowired
	private UserDao dao;

	public static void main(String[] args) {
		SpringApplication.run(NamedParameterJdbcTemplateApp.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		dao.addUser(new User(1, "Soumitra", "soumitra@roytuts.com", "43256789", "Earth"));

		User user = new User();
		user.setName("Soumitra");
		System.out.println("Number of Users: " + dao.countByName(user));
	}

}
