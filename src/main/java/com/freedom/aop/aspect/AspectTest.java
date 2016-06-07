package com.freedom.aop.aspect;

/**
 * Created by xxhuang on 2016/6/2.
 * 使用spring AOP实现动态代理
 */

import com.freedom.aop.imp.LogPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect//该注解标明该类为切面类
public class AspectTest {

    private LogPoint logPoint;

   // @Pointcut("within(@org.springframework.stereotype.Controller *)")
    public void cutController(){
        System.out.print("test");
    }

   // @Around("cutController()")
    public Object recordSysLog(ProceedingJoinPoint point) throws Throwable{
        System.out.println("lfkdjj================================================================");
        return point.proceed();
    }

    @Around(value = "@annotation(com.freedom.aop.annotations.LogImp)")
    public void saveLog(){
        System.out.print("");
    }

    public void setLogPoint(LogPoint logPoint) {
        this.logPoint = logPoint;
    }
}
