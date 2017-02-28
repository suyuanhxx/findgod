package com.findgods.fly;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * REVIEW
 * @Description:
 * @author xiaoxu.huang@baidao.com xiaoxu.huang
 * @date 2017/2/24  16:56
 *
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}