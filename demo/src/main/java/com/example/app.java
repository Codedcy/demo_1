package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
//@EnableAutoConfiguration
//@ComponentScan("com.example.controller")
public class app {

	public static void main(String[] args) {
		SpringApplication.run(app.class, args);
	}

}
