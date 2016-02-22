package com.shawn.study.shiro.repository;

import com.shawn.study.shiro.entity.Permission;
import com.shawn.study.shiro.entity.Role;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shawn on 2016/2/22.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
        "classpath:spring-context.xml",
        "classpath:spring-repository.xml",
        "classpath:spring-shiro.xml"
})
public class PermissionRepositoryTest {

    @Autowired
    PermissionRepository repository;

    @Autowired
    RoleRepository roleRepository;

    @Test
    public void testFindByRoleList() throws Exception {
        Role role = roleRepository.findOne(3L);
        List<Role> roleList = new ArrayList<>();
        roleList.add(role);

        List<Permission> permissionList = repository.findByRoleList(roleList);
        Assert.assertEquals(2, permissionList.size());
    }
}