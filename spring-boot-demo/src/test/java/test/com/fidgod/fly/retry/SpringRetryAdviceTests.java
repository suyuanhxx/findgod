package test.com.fidgod.fly.retry;

import com.findgod.fly.retry.aop.RemoteCallService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 *
 * @author xiaoxu.huang@baidao.com xiaoxu.huang
 * @date 2017-04-10 14:47:27
 */

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class SpringRetryAdviceTests {

	@Autowired
	private RemoteCallService remoteCallService;

	/**
	 * 基于Advice(配置文件)的重试
	 * @throws Exception
	 * @author xiaoxu.huang
	 * @date 2017-04-10 15:23:53
	 */
	@Test
	public void testRetry() throws Exception {
		remoteCallService.call();
	}

}
