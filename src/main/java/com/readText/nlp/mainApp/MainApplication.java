package com.readText.nlp.mainApp;

import com.readText.nlp.mainApp.controller.MainController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author Samiksha Deshmukh
 */
@SpringBootApplication
@ComponentScan(basePackageClasses = MainController.class)
public class MainApplication {
    public static void main(String[] args) {

        SpringApplication.run(MainApplication.class,args);
    }
}
