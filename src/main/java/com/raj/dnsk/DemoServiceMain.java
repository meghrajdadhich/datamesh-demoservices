package com.raj.dnsk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class DemoServiceMain {

	public static void main(String[] args) {
		SpringApplication.run(DemoServiceMain.class, args);
	}

}
