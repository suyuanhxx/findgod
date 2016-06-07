package com.freedom.aop.imp;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * Created by Huangxiaoxu on 2016/6/6.
 */
public interface LogPoint {
    public void save(ProceedingJoinPoint joinPoint, String methodName, String operate);;
}
