package com.shawn.study.shiro.repository;

import com.shawn.study.shiro.entity.Permission;
import com.shawn.study.shiro.entity.Role;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Shawn on 2016/2/22.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
        "classpath:spring-context.xml",
        "classpath:spring-repository.xml",
        "classpath:spring-shiro.xml"
})
public class RoleRepositoryTest {
    @Autowired
    RoleRepository repository;

    @Test
    public void saveTest() {
        Role role = new Role();
        role.setName("管理员");
        role.setCode("ADMIN");

        List<Permission> permissionList = new ArrayList<>();
        Permission permission1 = new Permission();
        permission1.setName("添加用户");
        permission1.setCode("user_add");
        permission1.setPath("user:add");
        Permission permission2 = new Permission();
        permission2.setName("编辑用户");
        permission2.setCode("user_edit");
        permission2.setPath("user:edit");
        permissionList.add(permission1);
        permissionList.add(permission2);

        role.setPermissionList(permissionList);

        repository.save(role);
    }
}