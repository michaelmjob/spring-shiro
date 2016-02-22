package com.shawn.study.shiro.repository;

import com.shawn.study.shiro.entity.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Shawn on 2016/2/22.
 */
public interface UserRepository extends CrudRepository<User, Long> {
    public User findByUsername(String username);
}
