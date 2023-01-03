package com.accenture;

import java.util.Random;
import java.util.Scanner;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Bean;

@Configuration
@ComponentScan("com.accenture.classes")
@PropertySource("classpath:settings.properties")
public class BeanConfig {
	
	@Bean
	Random random() {
		return new Random();
	}
	
	@Bean
	Scanner scanner() {
		return new Scanner(System.in);
	}
}
