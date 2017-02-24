package com.findgods.freedom.controller;

import com.findgods.freedom.model.User;
import com.findgods.freedom.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Huangxiaoxu on 2016/6/2.
 */

@Controller
public class BaseController {

    @Autowired
    private UserService userService;

    @RequestMapping(value="/login")
    public String login(Model model){
        User user = userService.selectById(1);
        model.addAttribute(user);

        return "test";
    }
}
