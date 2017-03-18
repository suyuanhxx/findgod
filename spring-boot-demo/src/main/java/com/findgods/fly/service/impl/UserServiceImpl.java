package com.findgods.fly.service.impl;

import com.findgods.fly.entity.User;
import com.findgods.fly.repository.UserRepository;
import com.findgods.fly.service.UserService;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * REVIEW
 *
 * @author xiaoxu.huang
 * @description:
 * @date 2017/3/16  18:38
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    /**
     * @Resource byName -> byType (优先使用byName注入，然后使用byType,如果指定name不会按照type类型装配)
     * @Autowired byType
     */
    @Resource(name = "userRepository")
    private UserRepository userRepository;

    @Resource
    private MongoOperations mongoOperations;

    public User findById(Long id) {
        return userRepository.findByUsername("");
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public void save(User user) {
        userRepository.save(user);
    }

    /**
     * mongodb 更新方式：findOne->save
     *
     * @param id
     * @return
     */
    public User updateById(Long id) {
        User user = userRepository.findById(id);
        if (user != null) {
            user.setUsername("huangxiaoxu");
            userRepository.save(user);
        }
        Query searchUserQuery = new Query(Criteria.where("username").is("huangxiaoxu"));
        Update update = new Update();
        update.set("username", "BigBang");

        mongoOperations.updateFirst(searchUserQuery, update, User.class);
        return user;
    }

    public void delete(Long id) {
        User user = new User(2L, "");
        userRepository.delete(user);
    }
}
