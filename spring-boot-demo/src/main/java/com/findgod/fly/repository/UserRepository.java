package com.findgod.fly.repository;

import com.findgod.fly.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * REVIEW
 * @Description:
 * @author xiaoxu.huang
 * @date 2017/3/2  11:37
 *
 */
public interface UserRepository extends MongoRepository<User, String> {
	public User findByUsername(String username);
	public User findById(Long id);

}
