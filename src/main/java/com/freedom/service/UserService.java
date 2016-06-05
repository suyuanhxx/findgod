package com.freedom.service;

import com.freedom.bean.User;
import com.freedom.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Huangxiaoxu on 2016/6/4.
 */

@Service("userService")
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public int insert(User user){
        return userMapper.insert(user);
    }
}
