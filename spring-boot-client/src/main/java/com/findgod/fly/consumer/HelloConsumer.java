package com.findgod.fly.consumer;

import com.alibaba.boot.dubbo.annotation.DubboConsumer;
import com.findgod.fly.service.IHelloService;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by huangxiaoxu on 16/04/2017.
 */
@Component
@RestController
public class HelloConsumer {
    @DubboConsumer
    private IHelloService iHelloService;


    @RequestMapping(value = "/user/{username}", method = RequestMethod.GET)
    public String getUserByUsername(@PathVariable String username) {
        String msg = iHelloService.service();
        return msg;
    }
}
