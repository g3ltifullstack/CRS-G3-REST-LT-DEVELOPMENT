package com.lt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.lt.*")
public class CrsLtRestDevelopmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrsLtRestDevelopmentApplication.class, args);
	}

}
