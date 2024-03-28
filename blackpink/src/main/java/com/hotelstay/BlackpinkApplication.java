package com.hotelstay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication (exclude = SecurityAutoConfiguration.class)
public class BlackpinkApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlackpinkApplication.class, args);
	}

}
