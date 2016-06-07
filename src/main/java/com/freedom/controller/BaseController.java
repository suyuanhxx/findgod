package com.freedom.controller;

import com.freedom.aop.annotations.LogImp;
import com.freedom.bean.User;
import com.freedom.service.BaseService;
import com.freedom.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

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
