package com.findgod.fly.retry;

import java.rmi.RemoteException;

/**
 * Created by xiaoxu.huang on 2017/4/7.
 */
public interface RetryService {

	void service() throws RemoteException;
}
