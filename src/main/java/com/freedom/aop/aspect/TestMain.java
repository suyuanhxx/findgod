package com.freedom.aspect;

import com.freedom.service.Greeting;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by xxhuang on 2016/6/2.
 */
public class TestMain {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext factory = new ClassPathXmlApplicationContext("spring.xml");
        Greeting test = (Greeting)factory.getBean("greeting");
        test.sayHello("王五");
    }
}