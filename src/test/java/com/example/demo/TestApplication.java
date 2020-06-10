package com.example.demo;

import org.springframework.boot.SpringApplication;

public class TestApplication {

    public static void main(String args[]){
        SpringApplication application = Application.app();
        application.addInitializers(new AbstractIntegrationTestOld.Initializer());
        application.run();

    }
}
