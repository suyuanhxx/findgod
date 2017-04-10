package com.findgod.fly.retry;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.retry.RetryCallback;
import org.springframework.retry.RetryContext;
import org.springframework.retry.support.RetryTemplate;
import org.springframework.stereotype.Component;


/**
 * Created by xiaoxu.huang on 2017/4/7.
 * AOP切面类
 */
@Component
@Aspect
public class RetryAspect {

	private final static Logger logger = LoggerFactory.getLogger(RetryAspect.class);

	@Autowired
	private RetryTemplate retryTemplate;

	@Pointcut("execution(* com.findgod.fly.retry.aop..*(..)))")
	public void serviceMethods() {
		logger.info("retryTemplate serviceMethods");
	}

	/**
	 * AOP重试，不能恢复，补偿
	 * @param joinPoint joinPoint
	 * @return
	 * @author xiaoxu.huang
	 * @date 2017-04-10 15:13:59
	 */
	@Around("serviceMethods()")
	public Object aroundServiceMethods(final ProceedingJoinPoint joinPoint) {
		try {
			return retryTemplate.execute(new RetryCallback<Object, Throwable>() {
				@Override
				public Object doWithRetry(RetryContext retryContext) throws Throwable {
					return joinPoint.proceed();
				}
			});
		} catch (Throwable e) {
			logger.error("RetryAspect Throwable exception", e);
		}
		return null;
	}
}
