package com.benjamin.hcc;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.benjamin.hcc.domain.UserDO;

import com.benjamin.hcc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class hccApplication implements CommandLineRunner{

	public static void main(String[] args) {

		SpringApplication.run(hccApplication.class, args);
	}
	@Bean
	public WebMvcConfigurer webMvcConfigurer() {
		return new WebMvcConfigurerAdapter() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("*");
			}
		};
	}
	@Autowired
	UserService service;

	@Override
	public void run(String... args) throws Exception{
		//default admin
		try {
			service.generateAdmin();
			System.out.println("Auto added admin account");
		}catch (Exception e){
			System.out.println("Admin already exists!");
		}
	}
}
