package com.findgods.freedom.aop.aspect;

/**
 * Created by xxhuang on 2016/6/2.
 * 使用spring AOP实现动态代理
 */
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Component
@Aspect//该注解标明该类为切面类
public class LogAspect {

    @Around("execution(* org.springframework.web.servlet.mvc.annotation.AnnotationMethodHandlerAdapter.handle(..))")
    public Object recordSysLog(ProceedingJoinPoint point) throws Throwable{
        System.out.println("lfkdjj================================================================");
        return point.proceed();
    }

    /**
     * 对service层进注解代理
     * @param joinPoint
     * @return
     * @throws Throwable
     */
    @Around(value = "@annotation(com.findgods.freedom.aop.annotations.LogImp)")
    public Object saveLog(ProceedingJoinPoint joinPoint) throws Throwable{
        System.out.print("呵呵呵呵");

        String methodName = joinPoint.getSignature().getName();
        Method method = currentMethod(joinPoint, methodName);

        return joinPoint.proceed();
    }


    /**
     * 获取目标类的所有方法，找到当前要执行的方法
     * @param joinPoint
     * @param methodName
     * @return
     */
    private Method currentMethod(ProceedingJoinPoint joinPoint, String methodName) {
        Method[] methods = joinPoint.getTarget().getClass().getMethods();
        Method resultMethod = null;
        for (Method method : methods) {
            if (method.getName().equals(methodName)) {
                resultMethod = method;
                break;
            }
        }
        return resultMethod;
    }

}
