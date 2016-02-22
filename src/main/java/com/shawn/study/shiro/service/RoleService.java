package com.shawn.study.shiro.service;

import com.shawn.study.shiro.entity.Role;
import com.shawn.study.shiro.entity.User;
import com.shawn.study.shiro.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Shawn on 2016/2/22.
 */
@Service
public class RoleService {
    @Autowired
    RoleRepository roleRepository;

    public Set<String> findStringRolesByUser(User user) {
        List<User> userList = new ArrayList<>();
        userList.add(user);
        List<Role> roleList = roleRepository.findByUserList(userList);
        Set<String> roles = new HashSet<>();
        for (Role role : roleList) {
            roles.add(role.getCode());
        }
        return roles;
    }
}
