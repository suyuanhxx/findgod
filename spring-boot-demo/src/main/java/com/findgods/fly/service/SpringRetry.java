package com.findgods.fly.service;

/**
 * REVIEW
 * @Description:
 * @author xiaoxu.huang@baidao.com xiaoxu.huang
 * @date 2017/3/8  11:28
 *
 */

import org.springframework.remoting.RemoteAccessException;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

/**
 * REVIEW
 * @Description:
 * @author xiaoxu.huang@baidao.com xiaoxu.huang
 * @date 2017/3/8  11:10
 *
 */
@Service("springRetry")
public class SpringRetry {

	@Retryable(value = { RemoteAccessException.class, RuntimeException.class },
			maxAttempts = 2,
			backoff = @Backoff(value = 2000))
	public void service() {
		System.out.println("do some things");
		// this exception will just trigger recover1, do not trigger recover3
		throw new RemoteAccessException("remote access exception");
		// this exception will just trigger recover2
		//        throw new RuntimeException("runtime exception");

		//        System.out.println("do another things");
	}

	// 如果使用注解的话,这个recover貌似只能写在本类中,我测试了如果将recover方法写在
	// recoverService中,好像找不到

	@Recover
	public void recover1(RemoteAccessException e) {
		System.out.println(e.getMessage());
		System.out.println("do recover operation1");
	}

	@Recover
	public void recover2(RuntimeException e) {
		System.out.println(e.getMessage());
		System.out.println("do recover operation2");
	}


}
