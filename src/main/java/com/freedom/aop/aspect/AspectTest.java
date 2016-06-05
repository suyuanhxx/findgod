package com.freedom.aspect;

/**
 * Created by xxhuang on 2016/6/2.
 * 使用spring AOP实现动态代理
 */

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.After;

@Aspect//该注解标明该类为切面类
public class AspectTest {

    @Before("execution(* com.service.*.*(..))")
    public void before(){
        System.out.println("<< before");
    }

    @After("execution(* com.service.*.*(..))")
    public void after(){
        System.out.println("<< after");
    }



}
