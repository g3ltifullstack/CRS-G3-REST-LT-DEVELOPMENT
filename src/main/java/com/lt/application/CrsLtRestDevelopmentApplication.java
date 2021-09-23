package com.lt.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@ComponentScan("com.lt.*")

public class CrsLtRestDevelopmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrsLtRestDevelopmentApplication.class, args);
	}

}
