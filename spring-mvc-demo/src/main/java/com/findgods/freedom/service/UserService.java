package com.findgods.freedom.service;

import com.findgods.freedom.aop.annotations.LogImp;
import com.findgods.freedom.model.User;
import com.findgods.freedom.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Huangxiaoxu on 2016/6/4.
 */

@Service("userService")
public class UserService {

    @Autowired
    private UserMapper userMapper;

    @LogImp(value = "test")
    public User selectById(int id){
        return userMapper.selectByPrimaryKey(id);
    }
}
