package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		app().run(args);

	}

	public static SpringApplication app(){
		return new SpringApplication(Application.class);
	}

}
