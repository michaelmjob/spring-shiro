package com.shawn.study.shiro.service;

import com.shawn.study.shiro.entity.User;
import com.shawn.study.shiro.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Shawn on 2016/2/22.
 */
@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public User findUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
