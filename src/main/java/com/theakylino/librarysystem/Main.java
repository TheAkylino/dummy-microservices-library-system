package com.theakylino.librarysystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.theakylino.librarysystem")
public class Main {

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}

}
