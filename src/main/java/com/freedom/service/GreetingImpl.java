package com.freedom.service;

import com.freedom.service.Greeting;

/**
 * Created by xxhuang on 2016/6/2.
 */
public class GreetingImpl implements Greeting {
    private void before() {
        System.out.println(">> Before");
    }

    private void after() {
        System.out.println(">> After");
    }

    public void sayHello(String name) {
        System.out.println(name);
    }
}