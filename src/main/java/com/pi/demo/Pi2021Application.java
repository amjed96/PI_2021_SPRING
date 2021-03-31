package com.pi.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
@EnableScheduling
@SpringBootApplication
public class Pi2021Application {

	public static void main(String[] args) {
		SpringApplication.run(Pi2021Application.class, args);
	}

}
