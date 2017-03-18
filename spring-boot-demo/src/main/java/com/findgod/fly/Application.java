package com.findgod.fly;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Description:  @SpringBootApplication相当于 @MongoConfiguration,@EnableAutoConfiguration,@ComponentScan三个注解
 * @author xiaoxu.huang
 * @date 2017/2/24  16:56
 */
@SpringBootApplication
//@MongoConfiguration
//@EnableAutoConfiguration
//@ComponentScan
public class Application{

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
