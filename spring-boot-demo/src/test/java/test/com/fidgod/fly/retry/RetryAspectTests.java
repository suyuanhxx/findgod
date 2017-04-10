package test.com.fidgod.fly.retry;

import com.findgod.fly.retry.aop.RemoteCallService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by xiaoxu.huang on 2017/4/10.
 * 基于AOP的spring-retry
 */

@RunWith(SpringJUnit4ClassRunner.class)
public class RetryAspectTests {

	@Autowired
	private RemoteCallService remoteCallService;

	/**
	 * 基于AOP的重试
	 * @throws Exception
	 * @author xiaoxu.huang
	 * @date 2017-04-10 15:24:39
	 */
	@Test
	public void testRetry() throws Exception {
		remoteCallService.call();
	}

}
