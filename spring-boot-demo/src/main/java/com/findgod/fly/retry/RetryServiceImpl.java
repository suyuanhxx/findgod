package com.findgod.fly.retry;

import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

import java.rmi.RemoteException;

/**
 * Created by xiaoxu.huang on 2017/4/7.
 */
@Service("retryService")
@EnableRetry
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class RetryServiceImpl implements RetryService {

	/**
	 * 业务处理方法
	 * @throws RemoteException
	 */
	@Retryable(include = RuntimeException.class, maxAttempts = 2, backoff = @Backoff(delay = 5000, multiplier = 1.5))
	@Override
	public void service() throws RemoteException {
		System.out.println("do some things");
		throw new RemoteException("remote access exception");
	}

	/**
	 * 异常处理方法，出错后恢复方法
	 * @param e exception
	 * @throws RemoteException
	 */
	@Recover
	public void recover(RemoteException e) throws RemoteException {
		System.out.println(e.getMessage());
		System.out.println("do recover operation1");
	}
}
