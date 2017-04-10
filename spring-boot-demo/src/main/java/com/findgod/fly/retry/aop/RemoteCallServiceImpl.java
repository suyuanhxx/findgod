package com.findgod.fly.retry.aop;

import org.springframework.stereotype.Service;

/**
 * Created by xiaoxu.huang on 2017/4/10.
 */
@Service("remoteCallService")
public class RemoteCallServiceImpl implements RemoteCallService {

	@Override
	public String call() throws RuntimeException {
		System.out.println("RemoteCallServiceImpl call");
		throw new RuntimeException("RemoteCallServiceImpl call");
	}

}
