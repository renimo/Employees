package com.employees_DB;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

@SpringBootApplication(exclude={MongoAutoConfiguration.class})
public class EmployeesDbApplication {
	public static void main(String[] args) {
		System.out.println("RENANA");
		SpringApplication.run(EmployeesDbApplication.class, args);
	}

	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
		return String.format("Hello %s!", name);
	}
}


//import org.springframework.boot.autoconfigure;
//@EnableAutoConfiguration(exclude={MongoAutoConfiguration.class})