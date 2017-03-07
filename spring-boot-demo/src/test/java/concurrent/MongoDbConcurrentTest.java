package concurrent;

import com.findgods.fly.entity.User;
import com.findgods.fly.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.annotation.Resource;

/**
 * REVIEW
 * @Description:
 * @author xiaoxu.huang@baidao.com xiaoxu.huang
 * @date 2017/3/7  11:31
 *
 */

public class MongoDbConcurrentTest {
	public int a = 1;

	@Test
	public void testConcurrent() {
		for (int i = 0; i < 10; i++) {
			Thread thread = new Thread(new Runnable() {
				@Override
				public void run() {
					saveOrUpdate();
				}
			});
			thread.start();
		}
		System.out.println(a);

	}

	public void saveOrUpdate() {
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
		}
		a ++;
	}
}
