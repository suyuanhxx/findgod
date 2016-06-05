package com.freedom.controller;

import com.freedom.aop.imp.LogImp;
import com.freedom.bean.User;
import com.freedom.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
    public ModelAndView login(ModelMap modelMap){
        User user = new User();
        user.setId(1);
        user.setUsername("aaa");
        user.setPassword("aaa");
        userService.insert(user);
        return new ModelAndView(new RedirectView("test.jsp"));
    }
}
