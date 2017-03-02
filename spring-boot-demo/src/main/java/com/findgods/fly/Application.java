package com.findgods.fly;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
