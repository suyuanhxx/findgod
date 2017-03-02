package com.findgods.fly.repository;

import com.findgods.fly.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * REVIEW
 * @Description:
 * @author xiaoxu.huang@baidao.com xiaoxu.huang
 * @date 2017/3/2  11:37
 *
 */
//@Repository("userRepository")
public interface UserRepository extends MongoRepository<User, String> {
	public User findByUsername(String username);

}
