package com.findgod.fly.provider;

import com.alibaba.dubbo.config.annotation.Service;
import com.findgod.fly.service.IHelloService;
import org.springframework.stereotype.Component;

/**
 * Created by huangxiaoxu on 16/04/2017.
 */
@Component
@Service(interfaceClass = IHelloService.class)
public class HelloServiceImpl implements IHelloService {

    @Override
    public String service() {
        return "success";
    }
}
