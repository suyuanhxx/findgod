package com.findgod.fly;

import com.alibaba.boot.dubbo.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@EnableDubboConfiguration
public class ConsumeApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsumeApplication.class, args);
	}

}
