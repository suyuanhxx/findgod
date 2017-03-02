package com.findgods.fly.api;

import com.findgods.fly.repository.UserRepository;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * REVIEW @RestController  注解相当于 @Controller 和 @ResponseBody
 * @Description: restful api
 * @author xiaoxu.huang
 * @date 2017/3/2  10:33
 *
 */
@RestController
public class UserController {

    @Resource
    UserRepository repository;

    public String getUserByUsername() {
        repository.findByusername("111111");
        return "";
    }


}
