package com.findgods.fly.repository;

import com.findgods.fly.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * REVIEW
 * @Description:
 * @author xiaoxu.huang@baidao.com xiaoxu.huang
 * @date 2017/3/2  11:37
 *
 */
public interface UserRepository extends MongoRepository<BaseRepository, String> {
	public User findByusername(String username);
}
