package com.example.demo;

import liquibase.integration.spring.SpringLiquibase;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class Application
        implements CommandLineRunner {

    @Autowired
    private SpringLiquibase liquibase;

    public static void main(String[] args) {
        app().run(args);

    }

    public static SpringApplication app() {
        return new SpringApplication(Application.class);
    }


    @Override
    public void run(String... args) throws Exception {
        log.info("Liquibase changelog:{}", liquibase.getChangeLog());
    }
}
