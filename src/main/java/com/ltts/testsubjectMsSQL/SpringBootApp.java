package com.ltts.testsubjectMsSQL;
import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
//import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.ltts.testsubjectMsSQL.SpringBootApp;


@SpringBootApplication
@ComponentScan("com.ltts")
@EntityScan("com.ltts.model")
@EnableJpaRepositories("com.ltts.jpa")
public class SpringBootApp {
	public static void main(String[] args) {
		SpringApplication.run(SpringBootApp.class, args);
		System.out.println("Project started");
	}
}
