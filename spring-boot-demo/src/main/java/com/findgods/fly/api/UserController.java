package com.findgods.fly.api;

import com.alibaba.fastjson.JSON;
import com.findgods.fly.entity.User;
import com.findgods.fly.service.impl.UserServiceImpl;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.Semaphore;

/**
 * REVIEW @RestController  注解相当于 @Controller 和 @ResponseBody
 *
 * @author xiaoxu.huang
 * @Description: restful api
 * @date 2017/3/2  10:33
 */
@RestController
public class UserController {
    private Semaphore semaphore = new Semaphore(10);


    @Resource
    private UserServiceImpl userService;

    @RequestMapping(value = "/user/{username}", method = RequestMethod.GET)
    public String getUserByUsername(@PathVariable String username) {
        userService.findByUsername(username);
        return "success";
    }

    @RequestMapping(value = "/user/{username}", method = RequestMethod.POST)
    public String saveUser(@PathVariable String username) {
        User user = new User(23L, username);
        userService.save(user);
        return "success";
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
    public String updateUserByUsername(@PathVariable Long id) {
        User user = userService.updateById(id);
        return JSON.toJSONString(user);
    }

    @RequestMapping(value = "/user/{username}", method = RequestMethod.DELETE)
    public String deleteUserByUsername(@PathVariable String username) {
        return "success";
    }
}
