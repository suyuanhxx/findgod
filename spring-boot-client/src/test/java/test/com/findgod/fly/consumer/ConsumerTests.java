package test.com.findgod.fly.consumer;

import com.alibaba.boot.dubbo.annotation.DubboConsumer;
import com.findgod.fly.ConsumeApplication;
import com.findgod.fly.service.IHelloService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by huangxiaoxu on 16/04/2017.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ConsumeApplication.class)
public class ConsumerTests {

    @DubboConsumer
    private IHelloService iHelloService;

    @Test
    public void testHello() {
        String msg = iHelloService.service();
    }
}
