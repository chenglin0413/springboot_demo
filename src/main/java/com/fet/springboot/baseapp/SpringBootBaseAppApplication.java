package com.fet.springboot.baseapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fet.springboot.baseapp.web.controller.CustomerController;

@SpringBootApplication
public class SpringBootBaseAppApplication {
	

	public static void main(String[] args) {

		SpringApplication.run(SpringBootBaseAppApplication.class, args);
	}

}
