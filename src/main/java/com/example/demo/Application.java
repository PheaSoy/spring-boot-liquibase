package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class Application{

    public static void main(String[] args) {
        app().run(args);

    }

    public static SpringApplication app() {
        return new SpringApplication(Application.class);
    }

}
