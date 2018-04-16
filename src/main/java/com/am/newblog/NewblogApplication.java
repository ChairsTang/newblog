package com.am.newblog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.am.newblog.dao")
@ComponentScan(basePackages = {"com.am.newblog.service","com.am.newblog.controller"})
public class NewblogApplication {
	public static void main(String[] args) {
		SpringApplication.run(NewblogApplication.class, args);
	}
}
