package test.com.fidgod.fly.retry;

import com.findgod.fly.retry.RetryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.rmi.RemoteException;

/**
 * Created by xiaoxu.huang on 2017/4/7.
 * 基于注解的Spring-retry
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class RetryServiceTests {

	@Autowired
	private RetryService retryService;

	@Test
	public void testSpringRetry() throws RemoteException {
		retryService.service();
	}
}
