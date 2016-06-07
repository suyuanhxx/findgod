package com.freedom.service;

import com.freedom.aop.imp.LogPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Service;

/**
 * Created by Huangxiaoxu on 2016/6/2.
 */
public class BaseService implements LogPoint{
    public void save(ProceedingJoinPoint joinPoint, String methodName, String operate) {

    }
}
