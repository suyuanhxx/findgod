package com.findgods.fly;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Description:  @SpringBootApplication相当于 @Configuration,@EnableAutoConfiguration,@ComponentScan三个注解
 * @author xiaoxu.huang
 * @date 2017/2/24  16:56
 */
@SpringBootApplication
//@Configuration
//@EnableAutoConfiguration
//@ComponentScan
public class Application{

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
