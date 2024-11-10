package com.pankajsoftware.book_networkooo;


import java.time.LocalDateTime;
import java.time.Month;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;

// @EnableJpaAuditing //isn=
// @EnableJpaAuditing(auditorAwareRef = "auditorAware") //sn=
// @SpringBootApplication
@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
@EnableAsync
public class BookNetworkoooApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookNetworkoooApplication.class, args);
	}

}
