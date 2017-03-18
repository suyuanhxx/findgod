package com.findgods.fly.service;

import com.findgods.fly.entity.User;

/**
 * Created by huangxiaoxu on 18/03/2017.
 */
public interface UserService {

    void save(User user);

    User updateById(Long id);

    User findByUsername(String username);

    User findById(Long id);

    void delete(Long id);
}
