package com.roytuts.spring.mock.autowired.field.value.junit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringMockAutowiredValueApp implements CommandLineRunner {

    @Autowired
    private SpringServiceAutowiredField service;

    public static void main(String[] args) {
        SpringApplication.run(SpringMockAutowiredValueApp.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        service.getValue();
    }

}
