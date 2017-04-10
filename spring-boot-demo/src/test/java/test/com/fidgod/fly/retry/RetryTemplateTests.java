package test.com.fidgod.fly.retry;

import com.findgod.fly.retry.aop.RemoteCallService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.retry.RecoveryCallback;
import org.springframework.retry.RetryCallback;
import org.springframework.retry.RetryContext;
import org.springframework.retry.support.RetryTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.rmi.RemoteException;

/**
 * REVIEW
 * @Description: 基于RetryTemplate的重试机制
 * @author xiaoxu.huang
 * @date 2017/3/8  11:11
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class RetryTemplateTests {

	@Autowired
	private RetryTemplate retryTemplate;
	@Autowired
	private RemoteCallService remoteCallService;

	RetryCallback<Object, RemoteException> retryCallback = new RetryCallback<Object, RemoteException>() {
		public Object doWithRetry(RetryContext context) throws RemoteException {
			//设置context一些属性,给RecoveryCallback传递一些属性
			context.setAttribute("key1", "value1");
			remoteCallService.call();
			return null;
		}
	};

	// 如果RetryCallback执行出现指定异常, 并且超过最大重试次数依旧出现指定异常的话,就执行RecoveryCallback动作
	RecoveryCallback<Object> recoveryCallback = new RecoveryCallback<Object>() {
		public Object recover(RetryContext context) throws Exception {
			System.out.println("do recovery operation");
			System.out.println(context.getAttribute("key1"));
			return null;
		}
	};

	/**
	 * 没有恢复规则回调的重试
	 * @author xiaoxu.huang
	 * @date 2017-04-10 11:33:34
	 */
	@Test
	public void testRetryTemplateWithOutRecover() {
		try {
			retryTemplate.execute(retryCallback);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 带恢复规则的重试
	 * @author xiaoxu.huang
	 * @date 2017-04-10 11:33:49
	 */
	@Test
	public void testRetryTemplate() {
		try {
			retryTemplate.execute(retryCallback, recoveryCallback);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
