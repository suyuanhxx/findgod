package com.findgods.fly.service;

import com.findgods.fly.entity.User;
import com.findgods.fly.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * REVIEW
 * @description:
 * @author xiaoxu.huang
 * @date 2017/3/16  18:38
 *
 */
@Service("userService")
public class UserService {

	@Resource
	private UserRepository userRepository;

	public User find(String username) {
		return userRepository.findByUsername(username);
	}

	public void save(String username) {
		User user = new User(2L, username);
		userRepository.save(user);
	}
}
